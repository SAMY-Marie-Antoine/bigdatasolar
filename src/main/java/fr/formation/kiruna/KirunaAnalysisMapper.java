package fr.formation.kiruna;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.commons.lang3.compare.ComparableUtils;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.io.Text;

public class KirunaAnalysisMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, DoubleWritable> {

    @Override
    public void map(LongWritable key, Text value, OutputCollector<Text, DoubleWritable> output, Reporter reporter)
            throws IOException {
        if (key.get() == 0) {
            return;
        }

        KirunaDataEntry data = this.parseKiruna(value.toString());
        BigDecimal limiteHaute = new BigDecimal("9000");
        BigDecimal limiteBasse = new BigDecimal("11000");
        if(!(data.getX()==null) && ComparableUtils.is(data.getX()).between(limiteBasse,limiteHaute)){
            output.collect(new Text(data.getDate()),new DoubleWritable(data.getX().doubleValue()));
        }

    }

    public KirunaDataEntry parseKiruna(String data) {
        String[] values = data.split(";");
        KirunaDataEntry kirunaData = new KirunaDataEntry();
        kirunaData.setDate(values[0]);
        if (values[1].length() != 0) {
            kirunaData.setX(new BigDecimal(values[1]));
        }
        return kirunaData;
    }
}
