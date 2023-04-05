package com.example.Assignment.Parsing.Reformer;

import java.util.ArrayList;

public class Word {
    ArrayList<String> word = new ArrayList<>();

    public Word() {
    }

    public Word(ArrayList<String> word) {
        this.word = word;
    }

    public ArrayList<String> getWord() {
        return word;
    }

    public void setWord(ArrayList<String> word) {
        this.word = word;
    }
}

