package fr.formation;

import java.math.BigDecimal;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

import fr.formation.solar.BzAnalysisMapper;
//import fr.formation.solar.BzAnalysisReducer;

public class Application {

	

	public static void main(String[] args) throws Exception {
		JobConf conf = new JobConf(Application.class);
        conf.setJobName("Repérage évenements où Bz < -20 nT");
        //valeurs de sorties 
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(BigDecimal.class);
        //mapper et reducer
        conf.setMapperClass(BzAnalysisMapper.class);
        //conf.setReducerClass(BzAnalysisReducer.class);
        // input
        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);

        //le ou les fichiers en entrée et le fichier en sortie
        FileInputFormat.setInputPaths(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));

        JobClient.runJob(conf);
	}
}
