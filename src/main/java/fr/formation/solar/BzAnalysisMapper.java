package fr.formation.solar;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.commons.lang3.compare.ComparableUtils;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class BzAnalysisMapper extends MapReduceBase implements Mapper<LongWritable,Text,Text,DoubleWritable>{

    @Override
    public void map(LongWritable key, Text value, OutputCollector<Text, DoubleWritable> output, Reporter reporter)
            throws IOException {
                //skip first line
                if(key.get()==0){
                     return;
                }
                // see if data matches condition
                SolarWindDataEntry data = this.parseSolar(value.toString());
                BigDecimal limiteHaute = new BigDecimal("-20");
                if(ComparableUtils.is(data.getBz()).lessThanOrEqualTo(limiteHaute)){
                    output.collect(new Text(data.getDate()),new DoubleWritable(data.getBz().doubleValue()));
                    //output.collect(new Text("mockoutput"),new DoubleWritable(1.1));
                }
    }
    
    public SolarWindDataEntry parseSolar(String data){
        String[] values = data.split(";");
        SolarWindDataEntry solarData = new SolarWindDataEntry();
        solarData.setDate(values[0]);
        if(values[1].length() != 0){solarData.setSpeed(new BigDecimal(values[1]));}
        if(values[2].length() != 0){solarData.setDensity(new BigDecimal(values[2]));}
        if(values[3].length() != 0){solarData.setBt(new BigDecimal(values[3]));}
        if(values[4].length() != 0){solarData.setBz(new BigDecimal(values[4]));}
        return solarData;
    }
}
