package course.xml_1206.Dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.*;

/*
1、读取
新增节点    添加文本
新增属性
修改
删除属性
删除节点
 */

//添加文本并读取
public class Test1 {
    public static void main(String[] args) throws IOException {
        DocumentFactory documentFactory = DocumentFactory.getInstance();
        Document document = documentFactory.createDocument();
        document.setXMLEncoding("UTF-8");
        Element root =document.addElement("手机");

        Element child1 = root.addElement("华为");
        child1.addText("国产品牌");
        child1.addAttribute("name","huawei");

        Element child2 = root.addElement("苹果");
        child2.addText("外国品牌");
        child2.addAttribute("name","apple");

        //document.add(root);


        OutputFormat outputFormat = new OutputFormat();
        outputFormat.setEncoding("UTF-8");
        XMLWriter writer = new XMLWriter(new FileWriter("phone1.txt"),outputFormat);
        writer.write(document);
        writer.flush();
        writer.close();


    }
}
