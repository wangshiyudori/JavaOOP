package course.xml_1205;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class PhoneTest2 {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder db  = null;
        Document d = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        try {
            d = db.parse("phone.txt");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Element root = d.getDocumentElement();

        NodeList parent = root.getChildNodes();
        for (int i = 0; i <parent.getLength() ; i++) {
            System.out.println(parent.item(i).getNodeName()+":"+parent.item(i).getNodeValue());

            if (parent.item(i).getNodeName().equals("Brand")){
                NodeList child = parent.item(i).getChildNodes();

                for (int j = 0; j <child.getLength() ; j++) {

                    //System.out.println(child.item(j).getTextContent());
                    if (child.item(j).getNodeName().equals("Type") ){
                        System.out.println(child.item(j).getNodeName()+":"
                                +child.item(j).getAttributes().getNamedItem("name").getNodeValue()
                                +"---------"+child.item(j).getTextContent());
                    }


                }

            }
        }
    }
}
