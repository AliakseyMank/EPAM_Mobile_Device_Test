package test.epam.util;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import test.epam.model.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLReader {

    private static final String INPUT_FILE = "files/input.xml";
    private static final List<Gadget> gadgetList = new ArrayList<>();

    public static List<Gadget> readXML() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(INPUT_FILE));


        for (TagsName tag : TagsName.values()) {
            collectInformation(document, tag);
        }
        return gadgetList;

    }

    private static void collectInformation(Document document, final TagsName tag) {
        NodeList elements = document.getElementsByTagName(tag.getTag());

        for (int i = 0; i < elements.getLength(); i++) {
            NamedNodeMap attributes = elements.item(i).getAttributes();
            String name = attributes.getNamedItem("name").getNodeValue();
            double cost = Double.parseDouble(attributes.getNamedItem("cost").getNodeValue());
            double weight = Double.parseDouble(attributes.getNamedItem("weight").getNodeValue());


            switch (tag) {
                case READER: {
                    gadgetList.add(new Reader(name, cost, weight));
                } break;
                case SMARTPHONE: {
                    gadgetList.add(new Smartphone(name, cost, weight));
                }
                break;
                case NOTEBOOK: {
                    gadgetList.add(new Notebook(name, cost, weight));
                }
                break;
                case DESKTOP_COMPUTER: {
                    gadgetList.add(new DesktopComputer(name, cost, weight));
                }
                break;
            }

        }
    }
}