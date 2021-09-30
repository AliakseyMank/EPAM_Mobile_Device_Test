package test.epam.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLWriter {

    ArrayList<Double> results = null;
    private static String FILE_DATA = "files/output.xml";


    public static void writeXML(List<Calculator.Result> results) {

    DocumentBuilderFactory documentBuilderFactory = null;
    DocumentBuilder documentBuilder = null;
    Document document = null;

        try {
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilder = documentBuilderFactory.newDocumentBuilder();
        document = documentBuilder.newDocument();

        Element information = document.createElement("Information");

        document.appendChild(information);

        for (Calculator.Result result : results) {
            Element e = document.createElement("inf");
            e.setAttribute("result",result.getNameOfResult());
            e.setAttribute("value",String.valueOf(result.getValue()));
            information.appendChild(e);
        }


    }catch (
    ParserConfigurationException e) {
        e.printStackTrace();
    }finally {
        if (document != null)
            writeDocument(document, FILE_DATA);
    }
}

    private static void writeDocument(Document document, String path){
        Transformer transformer = null;
        DOMSource source = null;
        FileOutputStream fileOutputStream = null;

        try {
            transformer = TransformerFactory.newInstance().newTransformer();
            source = new DOMSource(document);
            fileOutputStream = new FileOutputStream(path);

            StreamResult result = new StreamResult(fileOutputStream);
            transformer.transform(source, result);
        }catch (TransformerException | IOException e){
            e.printStackTrace();
        }
    }

}
