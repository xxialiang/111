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

import team.adyn.bean.OdNum1;
import team.adyn.bean.Orders_goods1;

public class OdMR1 {

	public static class mapped extends Mapper<LongWritable, Orders_goods1, IntWritable, Orders_goods1> {

		@Override
		protected void map(LongWritable key, Orders_goods1 value,
				Mapper<LongWritable, Orders_goods1, IntWritable, Orders_goods1>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			int odid = value.getOdid();
			IntWritable odkey1 = new IntWritable(odid);
			context.write(odkey1, value);
		}

	}

	public static class reduced extends Reducer<IntWritable, Orders_goods1, OdNum1, Text> {

		@Override
		protected void reduce(IntWritable key, Iterable<Orders_goods1> orders,
				Reducer<IntWritable, Orders_goods1, OdNum1, Text>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			Integer odid1 = key.get();
			int sum = 0;
			for (Orders_goods1 order : orders) {
				sum++;
			}
			OdNum1 odnum1 = new OdNum1(odid1, "orderdate1", sum);
			context.write(odnum1, new Text(odnum1.getCountinfo()));
		}

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		DBConfiguration.configureDB(conf, "com.mysql.jdbc.Driver", "jdbc:mysql://192.168.100.100:3306/training", "root",
				"92658");
		Job job = Job.getInstance(conf, "OdMR1");
		job.setJarByClass(OdMR1.class);
		job.setMapperClass(mapped.class);
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(Orders_goods1.class);
		job.setReducerClass(reduced.class);
		job.setOutputKeyClass(OdNum1.class);
		job.setOutputValueClass(Text.class);
		job.setInputFormatClass(DBInputFormat.class);
		String[] fields = { "lid", "oid", "odid", "mdid", "mid", "cname", "cid", "pid", "gid", "gname" };
		DBInputFormat.setInput(job, Orders_goods1.class, "orders_goods1", null, "lid", fields);
		job.setOutputFormatClass(DBOutputFormat.class);
		DBOutputFormat.setOutput(job, "odnum1", "odid1", "countinfo", "odcount1");
		boolean result = job.waitForCompletion(true);
		System.exit(result ? 0 : 1);
	}

}