package course.xml_1205;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/*
解析（读取）：操作XML文档，将文档中的数据读取到内存中。
写入：将内存中的数据保存到XML文档中。持久化的存储。
解析XML的方式：
1、 DOM（document object mode）： 将标记语言文档一次性加载进内存，在内存中形成一颗DOM树。
2、 SAX （Simple Apis for XML）：XML简单应用程序接口。逐行读取，基于事件驱动的。
Document： 文档对象。代表内存中的DOM树。
Elements： 元素element对象的集合。可以当作ArrayList<Element>来使用。
Node： 节点对象。是document和element的父类。

 */

public class PhoneTest1 {
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
        System.out.println(root.getTagName());
        NodeList list = root.getChildNodes();
        for (int i = 0; i <list.getLength() ; i++) {
            Node node = list.item(i);

            if (node.getNodeName().equals("Brand")){
                System.out.println(node.getNodeName());
                System.out.println(node.getAttributes().getNamedItem("name").getNodeValue());
            }
        }

    }
}
