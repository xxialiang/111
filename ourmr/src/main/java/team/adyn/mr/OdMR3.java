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

import team.adyn.bean.OdNum3;
import team.adyn.bean.Orders_goods3;

public class OdMR3 {

	public static class mapped extends Mapper<LongWritable, Orders_goods3, IntWritable, Orders_goods3> {

		@Override
		protected void map(LongWritable key, Orders_goods3 value,
				Mapper<LongWritable, Orders_goods3, IntWritable, Orders_goods3>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			int odid = value.getOdid();
			IntWritable odkey3 = new IntWritable(odid);
			context.write(odkey3, value);
		}

	}

	public static class reduced extends Reducer<IntWritable, Orders_goods3, OdNum3, Text> {

		@Override
		protected void reduce(IntWritable key, Iterable<Orders_goods3> orders,
				Reducer<IntWritable, Orders_goods3, OdNum3, Text>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			Integer odid3 = key.get();
			int sum = 0;
			for (Orders_goods3 order : orders) {
				sum++;
			}
			OdNum3 odnum3 = new OdNum3(odid3, "orderdate3", sum);
			context.write(odnum3, new Text(odnum3.getCountinfo()));
		}

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		DBConfiguration.configureDB(conf, "com.mysql.jdbc.Driver", "jdbc:mysql://192.168.100.100:3306/training", "root",
				"92658");
		Job job = Job.getInstance(conf, "OdMR3");
		job.setJarByClass(OdMR3.class);
		job.setMapperClass(mapped.class);
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(Orders_goods3.class);
		job.setReducerClass(reduced.class);
		job.setOutputKeyClass(OdNum3.class);
		job.setOutputValueClass(Text.class);
		job.setInputFormatClass(DBInputFormat.class);
		String[] fields = { "lid", "oid", "odid", "mdid", "mid", "cname", "cid", "pid", "gid", "gname" };
		DBInputFormat.setInput(job, Orders_goods3.class, "orders_goods3", null, "lid", fields);
		job.setOutputFormatClass(DBOutputFormat.class);
		DBOutputFormat.setOutput(job, "odnum3", "odid3", "countinfo", "odcount3");
		boolean result = job.waitForCompletion(true);
		System.exit(result ? 0 : 1);
	}

}