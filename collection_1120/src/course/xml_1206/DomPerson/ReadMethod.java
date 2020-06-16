package course.xml_1206.DomPerson;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;

public class ReadMethod {
    public void read() throws IOException, Exception {
        //获取解析工厂
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //通过工厂获取解析器
        DocumentBuilder db  = dbf.newDocumentBuilder();
        //解析xml文件获取doc文档
        Document doc  = db.parse(new File("person.xml"));

        //获取根节点
        Element root = doc.getDocumentElement();
        //获取元素
        NodeList childNodes = root.getElementsByTagName("student");

        for (int i = 0; i < childNodes.getLength(); i++) {
            //获取student节点
            Node node = childNodes.item(i);
            NodeList nodeList= node.getChildNodes();

            //获取student下面的子节点
            for (int j = 0; j < nodeList.getLength(); j++) {
                Node item= nodeList.item(j);

                /*
                node : 节点。可能是文字内容、CDATA段、元素、属性等，具体是什么，要靠NodeType来判断节点类型。
                ELEMENT_NODE : 是一个枚举值，代表元素节点类型。
                所以 if (item.getNodeType() == Node.ELEMENT_NODE) 表示 : 如果当前节点是元素节点的话。
                （判断当前节点的类型为 某种元素节点类型。）
                 */
                if (item.getNodeType() == Node.ELEMENT_NODE){
                    if (item.getNodeName().equals("name")){
                        System.out.println(item.getTextContent());
                    }
                    if (item.getNodeName().equals("age")){
                        System.out.println(item.getTextContent());
                    }
                    if (item.getNodeName().equals("phone")){
                        System.out.println(item.getTextContent());
                    }

                }

            }
        }
    }
}
