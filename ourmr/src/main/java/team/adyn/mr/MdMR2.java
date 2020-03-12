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

import team.adyn.bean.MdNum2;
import team.adyn.bean.Orders_mailing2;

public class MdMR2 {

	public static class mapped extends Mapper<LongWritable, Orders_mailing2, IntWritable, Orders_mailing2> {

		@Override
		protected void map(LongWritable key, Orders_mailing2 value,
				Mapper<LongWritable, Orders_mailing2, IntWritable, Orders_mailing2>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			int mdid = value.getMdid();
			IntWritable mdkey2 = new IntWritable(mdid);
			context.write(mdkey2, value);
		}

	}

	public static class reduced extends Reducer<IntWritable, Orders_mailing2, MdNum2, Text> {

		@Override
		protected void reduce(IntWritable key, Iterable<Orders_mailing2> orders,
				Reducer<IntWritable, Orders_mailing2, MdNum2, Text>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			Integer mdid2 = key.get();
			int sum = 0;
			for (Orders_mailing2 order : orders) {
				sum++;
			}
			MdNum2 mdnum2 = new MdNum2(mdid2, "mailingdate2", sum);
			context.write(mdnum2, new Text(mdnum2.getCountinfo()));
		}

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		DBConfiguration.configureDB(conf, "com.mysql.jdbc.Driver", "jdbc:mysql://192.168.100.100:3306/training", "root",
				"92658");
		Job job = Job.getInstance(conf, "MdMR2");
		job.setJarByClass(MdMR2.class);
		job.setMapperClass(mapped.class);
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(Orders_mailing2.class);
		job.setReducerClass(reduced.class);
		job.setOutputKeyClass(MdNum2.class);
		job.setOutputValueClass(Text.class);
		job.setInputFormatClass(DBInputFormat.class);
		String[] fields = { "lid", "oid", "odid", "mdid", "mid", "cname", "cid", "pid", "gid", "gname" };
		DBInputFormat.setInput(job, Orders_mailing2.class, "orders_mailing2", null, "lid", fields);
		job.setOutputFormatClass(DBOutputFormat.class);
		DBOutputFormat.setOutput(job, "mdnum2", "mdid2", "countinfo", "mdcount2");
		boolean result = job.waitForCompletion(true);
		System.exit(result ? 0 : 1);
	}

}