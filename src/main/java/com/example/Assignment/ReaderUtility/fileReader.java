package com.example.Assignment.ReaderUtility;

import com.example.Assignment.Parsing.Splitter.FilePath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Properties;

@Component
public class fileReader {
    private final Logger logger = LoggerFactory.getLogger(fileReader.class);

    public String reader(File file) throws IOException {
        logger.info("The file reading starts...");
        BufferedReader read = null;
        StringBuilder builder = null;
        try {
            read = new BufferedReader(new FileReader(file));
            builder = new StringBuilder();
            String line;
            while ((line = read.readLine()) != null) {
                line = " " + line;

                builder.append(line);
            }

            return builder.toString();
        } catch (IOException e) {
            logger.error("The given  TExt file is Not found on the given Path");
        } finally {
            logger.info("The file content successfully converted into the String ");
            read.close();
            return builder.toString();
        }

    }

    public File TextFileReader(FilePath path) throws IOException {

        try {
            Properties prop = new Properties();


            File file = new File(FilePath.getINPUTTEXT().toUri());
            logger.info("File path is successfully fetched");
            return file;
        } catch (Exception e) {
            System.out.println("The file is Not found in the given path");
            throw new FileNotFoundException();
//    return new File("\"C:\\\\Users\\\\sathi\\\\Downloads\\\\TCSAssignment\\\\TCSAssignment\\\\src\\\\main\\\\resources\\\\config.properties\"");
        }
    }
}
