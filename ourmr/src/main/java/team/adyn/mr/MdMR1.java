package team.adyn.mr;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.db.DBConfiguration;
import org.apache.hadoop.mapreduce.lib.db.DBInputFormat;
import org.apache.hadoop.mapreduce.lib.db.DBOutputFormat;

import team.adyn.bean.MdNum1;
import team.adyn.bean.Orders_mailing1;

public class MdMR1 {

	public static class mapped extends Mapper<LongWritable, Orders_mailing1, IntWritable, Orders_mailing1> {

		@Override
		protected void map(LongWritable key, Orders_mailing1 value,
				Mapper<LongWritable, Orders_mailing1, IntWritable, Orders_mailing1>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			int mdid = value.getMdid();
			IntWritable mdkey1 = new IntWritable(mdid);
			context.write(mdkey1, value);
		}

	}

	public static class reduced extends Reducer<IntWritable, Orders_mailing1, MdNum1, Text> {

		@Override
		protected void reduce(IntWritable key, Iterable<Orders_mailing1> orders,
				Reducer<IntWritable, Orders_mailing1, MdNum1, Text>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			Integer mdid1 = key.get();
			int sum = 0;
			for (Orders_mailing1 order : orders) {
				sum++;
			}
			MdNum1 mdnum1 = new MdNum1(mdid1, "mailingdate1", sum);
			context.write(mdnum1, new Text(mdnum1.getCountinfo()));
		}

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		DBConfiguration.configureDB(conf, "com.mysql.jdbc.Driver", "jdbc:mysql://192.168.100.100:3306/training", "root",
				"92658");
		Job job = Job.getInstance(conf, "MdMR1");
		job.setJarByClass(MdMR1.class);
		job.setMapperClass(mapped.class);
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(Orders_mailing1.class);
		job.setReducerClass(reduced.class);
		job.setOutputKeyClass(MdNum1.class);
		job.setOutputValueClass(Text.class);
		job.setInputFormatClass(DBInputFormat.class);
		String[] fields = { "lid", "oid", "odid", "mdid", "mid", "cname", "cid", "pid", "gid", "gname" };
		DBInputFormat.setInput(job, Orders_mailing1.class, "orders_mailing1", null, "lid", fields);
		job.setOutputFormatClass(DBOutputFormat.class);
		DBOutputFormat.setOutput(job, "mdnum1", "mdid1", "countinfo", "mdcount1");
		boolean result = job.waitForCompletion(true);
		System.exit(result ? 0 : 1);
	}

}