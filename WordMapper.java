import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class WordMapper extends Mapper<LongWritable,Text,Text,IntWritable>{
	public void map(LongWritable k,Text v,Context c)throws IOException,InterruptedException
	{
		String s=v.toString();
		for(String w:s.split("!"))
		{
			if(w.length()>0)
			{
				c.write(new Text(w), new IntWritable(1));
			}
		}
				
	}

}
