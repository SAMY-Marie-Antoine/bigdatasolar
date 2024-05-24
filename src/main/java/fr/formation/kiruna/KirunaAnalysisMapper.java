package fr.formation.kiruna;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class KirunaAnalysisMapper extends MapReduceBase implements Mapper<LongWritable,Text,Text,IntWritable>{

    @Override
    public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
            throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'map'");
    }
    
    public KirunaDataEntry parseKiruna(String data){
        String[] values = data.split(";");
        KirunaDataEntry kirunaData = new KirunaDataEntry();
        kirunaData.setDate(values[0]);
        if(values[1].length() != 0){kirunaData.setX(new BigDecimal(values[1]));}
        return kirunaData;
    }
}
