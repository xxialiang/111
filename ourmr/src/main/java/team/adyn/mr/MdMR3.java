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

import team.adyn.bean.MdNum3;
import team.adyn.bean.Orders_mailing3;

public class MdMR3 {

	public static class mapped extends Mapper<LongWritable, Orders_mailing3, IntWritable, Orders_mailing3> {

		@Override
		protected void map(LongWritable key, Orders_mailing3 value,
				Mapper<LongWritable, Orders_mailing3, IntWritable, Orders_mailing3>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			int mdid = value.getMdid();
			IntWritable mdkey3 = new IntWritable(mdid);
			context.write(mdkey3, value);
		}

	}

	public static class reduced extends Reducer<IntWritable, Orders_mailing3, MdNum3, Text> {

		@Override
		protected void reduce(IntWritable key, Iterable<Orders_mailing3> orders,
				Reducer<IntWritable, Orders_mailing3, MdNum3, Text>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			Integer mdid3 = key.get();
			int sum = 0;
			for (Orders_mailing3 order : orders) {
				sum++;
			}
			MdNum3 mdnum3 = new MdNum3(mdid3, "mailingdate3", sum);
			context.write(mdnum3, new Text(mdnum3.getCountinfo()));
		}

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		DBConfiguration.configureDB(conf, "com.mysql.jdbc.Driver", "jdbc:mysql://192.168.100.100:3306/training", "root",
				"92658");
		Job job = Job.getInstance(conf, "MdMR3");
		job.setJarByClass(MdMR3.class);
		job.setMapperClass(mapped.class);
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(Orders_mailing3.class);
		job.setReducerClass(reduced.class);
		job.setOutputKeyClass(MdNum3.class);
		job.setOutputValueClass(Text.class);
		job.setInputFormatClass(DBInputFormat.class);
		String[] fields = { "lid", "oid", "odid", "mdid", "mid", "cname", "cid", "pid", "gid", "gname" };
		DBInputFormat.setInput(job, Orders_mailing3.class, "orders_mailing3", null, "lid", fields);
		job.setOutputFormatClass(DBOutputFormat.class);
		DBOutputFormat.setOutput(job, "mdnum3", "mdid3", "countinfo", "mdcount3");
		boolean result = job.waitForCompletion(true);
		System.exit(result ? 0 : 1);
	}

}