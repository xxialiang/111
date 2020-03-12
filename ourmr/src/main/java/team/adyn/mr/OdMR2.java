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

import team.adyn.bean.OdNum2;
import team.adyn.bean.Orders_goods2;

public class OdMR2 {

	public static class mapped extends Mapper<LongWritable, Orders_goods2, IntWritable, Orders_goods2> {

		@Override
		protected void map(LongWritable key, Orders_goods2 value,
				Mapper<LongWritable, Orders_goods2, IntWritable, Orders_goods2>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			int odid = value.getOdid();
			IntWritable odkey2 = new IntWritable(odid);
			context.write(odkey2, value);
		}

	}

	public static class reduced extends Reducer<IntWritable, Orders_goods2, OdNum2, Text> {

		@Override
		protected void reduce(IntWritable key, Iterable<Orders_goods2> orders,
				Reducer<IntWritable, Orders_goods2, OdNum2, Text>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			Integer odid2 = key.get();
			int sum = 0;
			for (Orders_goods2 order : orders) {
				sum++;
			}
			OdNum2 odnum2 = new OdNum2(odid2, "orderdate2", sum);
			context.write(odnum2, new Text(odnum2.getCountinfo()));
		}

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		DBConfiguration.configureDB(conf, "com.mysql.jdbc.Driver", "jdbc:mysql://192.168.100.100:3306/training", "root",
				"92658");
		Job job = Job.getInstance(conf, "OdMR2");
		job.setJarByClass(OdMR2.class);
		job.setMapperClass(mapped.class);
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(Orders_goods2.class);
		job.setReducerClass(reduced.class);
		job.setOutputKeyClass(OdNum2.class);
		job.setOutputValueClass(Text.class);
		job.setInputFormatClass(DBInputFormat.class);
		String[] fields = { "lid", "oid", "odid", "mdid", "mid", "cname", "cid", "pid", "gid", "gname" };
		DBInputFormat.setInput(job, Orders_goods2.class, "orders_goods2", null, "lid", fields);
		job.setOutputFormatClass(DBOutputFormat.class);
		DBOutputFormat.setOutput(job, "odnum2", "odid2", "countinfo", "odcount2");
		boolean result = job.waitForCompletion(true);
		System.exit(result ? 0 : 1);
	}

}