package com.example.Assignment.Parsing.Splitter;

import com.example.Assignment.ComparatorUtility.CapitalLetterComparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class SentenceSpliter {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public ArrayList<String> sentenceSplitter(String text) {
        logger.info("The Sentence has been splitted Successfully");
        ArrayList<String> Sentence = new ArrayList<String>(Arrays.asList(text.split("(?<!\\bMr)(?<!\\bMrs)[.?!]")));
        return Sentence;
    }

    public ArrayList<String> cleaner(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String input = list.get(i);
            input = input.trim();
            input = input.replaceAll("[-\\!@#$%^&*()+=,:/]", " ");

            input = input.trim();
            list.set(i, input);
        }
        logger.info("The special characters has been removed from the sentence");
        return list;
    }

    public ArrayList<ArrayList<String>> wordSplitter(ArrayList<String> sen) {
        ArrayList<ArrayList<String>> sentence = new ArrayList<ArrayList<String>>();
//        sen.stream().map((e)->sentence.add(new ArrayList<String>(Arrays.asList(e.split("\\s+")))));
        for (int i = 0; i < sen.size(); i++) {
            ArrayList<String> word = new ArrayList<>(Arrays.asList(sen.get(i).split("\\s+")));
            sentence.add(word);
        }
        logger.info("The word has been successfully splitted from the sentence");


        return sentence;

    }

    public ArrayList<ArrayList<String>> wordSorter(ArrayList<ArrayList<String>> sen) {
//        for(int i =0;i<sen.size();i++){
//          Collections.sort(sen.get(i),new CapitalLetterComparator());
//        }
        sen = (ArrayList<ArrayList<String>>) sen.stream().peek(list -> Collections.sort(list, new CapitalLetterComparator())).collect(Collectors.toList());
        logger.info("The words has been sorted based upon the given format");
        return sen;
    }
}
