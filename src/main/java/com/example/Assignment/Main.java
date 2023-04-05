package com.example.Assignment;

import com.example.Assignment.CSVUtility.WriterCsv;
import com.example.Assignment.ReaderUtility.fileReader;
import com.example.Assignment.Parsing.Splitter.FilePath;
import com.example.Assignment.Parsing.Splitter.SentenceSpliter;
import com.example.Assignment.XMLUtility.XMLConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;


public class Main {
    public static Logger logger = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) throws IOException, JAXBException {

        FilePath path = new FilePath();
        if (args.length > 0) {
            if (args.length == 3) {
                String ReadingFilePath = args[0];
                String WritingXmlFilePath = args[1];
                String WritingCsvFilePath = args[2];
                FilePath.setINPUTTEXT(Paths.get(ReadingFilePath));
                FilePath.setOUTPUTCSV(Paths.get(WritingCsvFilePath));
                FilePath.setOUTPUTXML(Paths.get(WritingXmlFilePath));

            } else {
                logger.error("Any one the file is missing");
                return;
            }
        } else {
            Properties prop = new Properties();
            ClassLoader classloader = Main.class.getClassLoader();
//            InputStream input = new FileInputStream(classloader.getResource("config.properties").getFile());
         InputStream input=new FileInputStream("C:\\Users\\sathi\\Downloads\\TCSAssignment\\TCSAssignment\\src\\main\\resources\\config.properties");
            prop.load(input);
            FilePath.setINPUTTEXT(Paths.get(prop.getProperty("SmallText")));
            FilePath.setOUTPUTXML(Paths.get(prop.getProperty("outputXmlFile")));
            FilePath.setOUTPUTCSV(Paths.get(prop.getProperty("outputCsvFile")));
        }
        logger.info("The program starts....");
        fileReader read = new fileReader();

        File txtFile = read.TextFileReader(path);

        String text = read.reader(txtFile);

        SentenceSpliter spliter = new SentenceSpliter();

        ArrayList<String> Sentence = spliter.sentenceSplitter(text);

        Sentence = spliter.cleaner(Sentence);
        ArrayList<ArrayList<String>> word = spliter.wordSplitter(Sentence);
        word = spliter.wordSorter(word);

        XMLConverter r = new XMLConverter(path);

        r.converter(word);
        logger.info("The given file is converted into XML and written in the output.xml at " + FilePath.getOUTPUTXML().toString());
        WriterCsv write = new WriterCsv(path);
        write.Writer(word);
        logger.info("The given file is converted into XML and written in the output.csv at " + FilePath.getOUTPUTCSV().toString());


    }

}
