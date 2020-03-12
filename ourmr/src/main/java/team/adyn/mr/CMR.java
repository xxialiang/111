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

import team.adyn.bean.CNum;
import team.adyn.bean.Orders;

public class CMR {

	public static class mapped extends Mapper<LongWritable, Orders, IntWritable, Orders> {

		@Override
		protected void map(LongWritable key, Orders value,
				Mapper<LongWritable, Orders, IntWritable, Orders>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			int cid = value.getCid();
			IntWritable ckey = new IntWritable(cid);
			context.write(ckey, value);
		}

	}

	public static class reduced extends Reducer<IntWritable, Orders, CNum, Text> {

		@Override
		protected void reduce(IntWritable key, Iterable<Orders> orders,
				Reducer<IntWritable, Orders, CNum, Text>.Context context) throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			Integer cid = key.get();
			int sum = 0;
			for (Orders order : orders) {
				sum++;
			}
			CNum cnum = new CNum(cid, "city", sum);
			context.write(cnum, new Text(cnum.getCountinfo()));
		}

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		DBConfiguration.configureDB(conf, "com.mysql.jdbc.Driver", "jdbc:mysql://192.168.100.100:3306/training", "root",
				"92658");
		Job job = Job.getInstance(conf, "CMR");
		job.setJarByClass(CMR.class);
		job.setMapperClass(mapped.class);
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(Orders.class);
		job.setReducerClass(reduced.class);
		job.setOutputKeyClass(CNum.class);
		job.setOutputValueClass(Text.class);
		job.setInputFormatClass(DBInputFormat.class);
		String[] fields = { "lid", "oid", "odid", "mdid", "mid", "cname", "cid", "pid", "gid", "gname" };
		DBInputFormat.setInput(job, Orders.class, "orders", null, "lid", fields);
		job.setOutputFormatClass(DBOutputFormat.class);
		DBOutputFormat.setOutput(job, "cnum", "cid", "countinfo", "ccount");
		boolean result = job.waitForCompletion(true);
		System.exit(result ? 0 : 1);
	}

}
