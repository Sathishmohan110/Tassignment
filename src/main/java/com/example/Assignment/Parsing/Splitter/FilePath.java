package com.example.Assignment.Parsing.Splitter;

import java.nio.file.Path;

public class FilePath {
    private static Path INPUTTEXT;
    private static Path OUTPUTCSV;
    private static Path OUTPUTXML;

    public static Path getINPUTTEXT() {
        return INPUTTEXT;
    }

    public static void setINPUTTEXT(Path INPUTTEXT) {
        FilePath.INPUTTEXT = INPUTTEXT;
    }

    public static Path getOUTPUTCSV() {
        return OUTPUTCSV;
    }

    public static void setOUTPUTCSV(Path OUTPUTCSV) {
        FilePath.OUTPUTCSV = OUTPUTCSV;
    }

    public static Path getOUTPUTXML() {
        return OUTPUTXML;
    }

    public static void setOUTPUTXML(Path OUTPUTXML) {
        FilePath.OUTPUTXML = OUTPUTXML;
    }


}
