package com.example.Assignment.ComparatorUtility;

import java.io.*;

public class XMLcomparator {
    public String Comapre(File Actual,File Expected) throws IOException {
        int flag=1;
//        File Expected=new File("C:\\Users\\sathi\\Downloads\\TCSAssignment\\TCSAssignment\\src\\main\\resources\\ExpectedXml.xml");
//        File Actual=new File("C:\\Users\\sathi\\Downloads\\TCSAssignment\\TCSAssignment\\src\\main\\resources\\output.xml");
        BufferedReader expected=new BufferedReader(new FileReader(Expected));
        BufferedReader actual=new BufferedReader(new FileReader(Actual));
        String l1,l2;
        while((l1=expected.readLine())!=null && (l2=actual.readLine())!=null){
            if(!l1.contentEquals(l2)) {
                System.out.println(l1);
                System.out.println(l2);
flag=0;
            }



        }
       if(flag==1) return "good";else return "There is a mismatch";
    }
}
