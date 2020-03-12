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

import team.adyn.bean.GNum;
import team.adyn.bean.Orders;

public class GMR {

	public static class mapped extends Mapper<LongWritable, Orders, IntWritable, Orders> {

		@Override
		protected void map(LongWritable key, Orders value,
				Mapper<LongWritable, Orders, IntWritable, Orders>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			int gid = value.getGid();
			IntWritable gkey = new IntWritable(gid);
			context.write(gkey, value);
		}

	}

	public static class reduced extends Reducer<IntWritable, Orders, GNum, Text> {

		@Override
		protected void reduce(IntWritable key, Iterable<Orders> orders,
				Reducer<IntWritable, Orders, GNum, Text>.Context context) throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			Integer gid = key.get();
			int sum = 0;
			for (Orders order : orders) {
				sum++;
			}
			GNum gnum = new GNum(gid, "goods", sum);
			context.write(gnum, new Text(gnum.getCountinfo()));
		}

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		DBConfiguration.configureDB(conf, "com.mysql.jdbc.Driver", "jdbc:mysql://192.168.100.100:3306/training", "root",
				"92658");
		Job job = Job.getInstance(conf, "GMR");
		job.setJarByClass(GMR.class);
		job.setMapperClass(mapped.class);
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(Orders.class);
		job.setReducerClass(reduced.class);
		job.setOutputKeyClass(GNum.class);
		job.setOutputValueClass(Text.class);
		job.setInputFormatClass(DBInputFormat.class);
		String[] fields = { "lid", "oid", "odid", "mdid", "mid", "cname", "cid", "pid", "gid", "gname" };
		DBInputFormat.setInput(job, Orders.class, "orders", null, "lid", fields);
		job.setOutputFormatClass(DBOutputFormat.class);
		DBOutputFormat.setOutput(job, "gnum", "gid", "countinfo", "gcount");
		boolean result = job.waitForCompletion(true);
		System.exit(result ? 0 : 1);
	}

}