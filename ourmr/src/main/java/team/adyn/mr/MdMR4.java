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

import team.adyn.bean.MdNum4;
import team.adyn.bean.Orders_mailing4;

public class MdMR4 {

	public static class mapped extends Mapper<LongWritable, Orders_mailing4, IntWritable, Orders_mailing4> {

		@Override
		protected void map(LongWritable key, Orders_mailing4 value,
				Mapper<LongWritable, Orders_mailing4, IntWritable, Orders_mailing4>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			int mdid = value.getMdid();
			IntWritable mdkey4 = new IntWritable(mdid);
			context.write(mdkey4, value);
		}

	}

	public static class reduced extends Reducer<IntWritable, Orders_mailing4, MdNum4, Text> {

		@Override
		protected void reduce(IntWritable key, Iterable<Orders_mailing4> orders,
				Reducer<IntWritable, Orders_mailing4, MdNum4, Text>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			Integer mdid4 = key.get();
			int sum = 0;
			for (Orders_mailing4 order : orders) {
				sum++;
			}
			MdNum4 mdnum4 = new MdNum4(mdid4, "mailingdate4", sum);
			context.write(mdnum4, new Text(mdnum4.getCountinfo()));
		}

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		DBConfiguration.configureDB(conf, "com.mysql.jdbc.Driver", "jdbc:mysql://192.168.100.100:3306/training", "root",
				"92658");
		Job job = Job.getInstance(conf, "MdMR4");
		job.setJarByClass(MdMR4.class);
		job.setMapperClass(mapped.class);
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(Orders_mailing4.class);
		job.setReducerClass(reduced.class);
		job.setOutputKeyClass(MdNum4.class);
		job.setOutputValueClass(Text.class);
		job.setInputFormatClass(DBInputFormat.class);
		String[] fields = { "lid", "oid", "odid", "mdid", "mid", "cname", "cid", "pid", "gid", "gname" };
		DBInputFormat.setInput(job, Orders_mailing4.class, "orders_mailing4", null, "lid", fields);
		job.setOutputFormatClass(DBOutputFormat.class);
		DBOutputFormat.setOutput(job, "mdnum4", "mdid4", "countinfo", "mdcount4");
		boolean result = job.waitForCompletion(true);
		System.exit(result ? 0 : 1);
	}

}