import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.Job;



public class WordDriver extends Configured{
	public static void main(String[] args) throws Exception
	{
		if(args.length!=2)
		{
			System.out.println("please give i/p and o/p properly");
			System.exit(-1);
		}
		Job j=new Job();
		j.setJarByClass(WordDriver.class);
		FileInputFormat.setInputPaths(j,new Path (args[0]));
		FileOutputFormat.setOutputPath(j,new Path (args[1]));
		
		j.setMapperClass(WordMapper.class);
		j.setReducerClass(WordReducer.class);
		
		j.setMapOutputKeyClass(Text.class);
		j.setMapOutputValueClass(IntWritable.class);
		
		j.setOutputKeyClass(Text.class);
		j.setOutputValueClass(IntWritable.class);
		
		System.exit(j.waitForCompletion(true)?0:-1);
	}
}
