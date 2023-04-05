package com.example.Assignment.XMLUtility;

import com.example.Assignment.Parsing.Reformer.text;
import com.example.Assignment.Parsing.Splitter.FilePath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XMLConverter {
    public Logger logger = LoggerFactory.getLogger(XMLConverter.class);

    FilePath path;

    public XMLConverter() {
    }

    public XMLConverter(FilePath path) {
        this.path = path;
    }

    public void converter(ArrayList<ArrayList<String>> s)  {
        try {
            JAXBContext context = JAXBContext.newInstance(text.class);
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            text txt = new text();
            txt.fixer(s);

            File output = new File(FilePath.getOUTPUTXML().toUri());
            mar.marshal(txt, output);
        } catch (Exception e) {
            logger.error("output Xml is not found,please give appropriate path " + e);
        }

    }


}
