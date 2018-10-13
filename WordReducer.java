import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class WordReducer extends Reducer<Text,IntWritable,Text,IntWritable> {
public void reduce(Text k,Iterable<IntWritable> v, Context c)throws IOException,InterruptedException
{
	int count=0;
	while(v.iterator().hasNext())
	{
		IntWritable i= v.iterator().next();
		count+=i.get();
	}
c.write(k,new IntWritable(count));
}
}
