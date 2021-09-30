package test.epam;

import org.xml.sax.SAXException;
import test.epam.model.Gadget;
import test.epam.util.Calculator;
import test.epam.util.XMLReader;
import test.epam.util.XMLWriter;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        List<Gadget> gadgetList = XMLReader.readXML();
        List<Calculator.Result> results = Calculator.getResults(gadgetList);
        XMLWriter.writeXML(results);
    }
}
