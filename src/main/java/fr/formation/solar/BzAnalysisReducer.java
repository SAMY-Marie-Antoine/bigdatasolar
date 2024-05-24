package fr.formation.solar;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class BzAnalysisReducer extends MapReduceBase implements Reducer<Text, BigDecimal, Text, BigDecimal> {

    @Override
    public void reduce(Text key, Iterator<BigDecimal> values, OutputCollector<Text, BigDecimal> output,
            Reporter reporter) throws IOException {

               return;
    }

   

}
