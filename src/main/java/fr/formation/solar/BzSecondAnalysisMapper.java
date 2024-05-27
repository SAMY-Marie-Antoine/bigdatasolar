package fr.formation.solar;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class BzSecondAnalysisMapper extends MapReduceBase implements Mapper<LongWritable,Text,Text,DoubleWritable>{

    @Override
    public void map(LongWritable key, Text value, OutputCollector<Text, DoubleWritable> output, Reporter reporter)
            throws IOException {
                
                // see if data matches condition
                String[] values = value.toString().split(" ");
                BigDecimal data = new BigDecimal(values[1]);
                if(!(data==null) && !data.equals(new BigDecimal("-999.9"))){
                    output.collect(new Text(values[0]),new DoubleWritable(data.doubleValue()));
                }
    }
}
