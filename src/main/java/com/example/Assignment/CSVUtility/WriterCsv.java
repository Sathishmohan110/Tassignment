package com.example.Assignment.CSVUtility;

import com.example.Assignment.Parsing.Splitter.FilePath;
import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriterCsv {
    FilePath path;

    public WriterCsv() {
    }

    public WriterCsv(FilePath path) {
        this.path = path;
    }

    public static CSVWriter wordWriter(CSVWriter write, ArrayList<ArrayList<String>> f) {
        int MaxWord = 0;
        for (ArrayList<String> list : f) {
            if (list.size() > MaxWord) {
                MaxWord = list.size();

            }

        }
        ArrayList<String> l = new ArrayList<>();
        l.add("");
        for (int i = 0; i < MaxWord; i++) {
            l.add("Word" + (i + 1));
        }
        String[] s = l.toArray(new String[0]);
        write.writeNext(s);
        return write;
    }

    public void Writer(ArrayList<ArrayList<String>> f) throws IOException {


        CSVWriter write = (CSVWriter) new CSVWriterBuilder(new FileWriter(FilePath.getOUTPUTCSV().toFile())).withQuoteChar(CSVWriter.NO_QUOTE_CHARACTER).build();
        write = wordWriter(write, f);
        for (int i = 0; i < f.size(); i++) {
            ArrayList<String> t = f.get(i);
            t.add(0, "Sentence" + (i + 1));

            write.writeNext(t.toArray(new String[0]));
        }
        write.flush();
    }

}
