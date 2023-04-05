package com.example.Assignment.Parsing.Reformer;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class text {
    ArrayList<Word> sentence = new ArrayList<Word>();

    public text() {

    }

    public text(ArrayList<Word> sentence) {
        this.sentence = sentence;
    }

    public ArrayList<Word> getSentence() {
        return sentence;
    }

    public void setSentence(ArrayList<Word> sentence) {
        this.sentence = sentence;
    }

    public void fixer(ArrayList<ArrayList<String>> letter) {
        for (int i = 0; i < letter.size(); i++) {
            ArrayList<String> content = letter.get(i);
            Word w = new Word();
            for (int j = 0; j < content.size(); j++) {
                w.word.add(content.get(j));
            }
            this.sentence.add(w);
        }

    }
}
