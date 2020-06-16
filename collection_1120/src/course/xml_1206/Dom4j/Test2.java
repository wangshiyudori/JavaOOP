package course.xml_1206.Dom4j;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.util.List;

public class Test2 {
    public static void main(String[] args) throws Exception {
       // DocumentFactory documentFactory = DocumentFactory.getInstance();
        //Document document = documentFactory.createDocument();
        SAXReader saxReader = new SAXReader();
        Document document1= saxReader.read("phone1.txt");
        Element root = document1.getRootElement();
        List<Element> lists = root.elements();

        //删除
        Element deleteElement = null;
        for (Element e:lists) {
            if (e.getName().equals("小米")){
                deleteElement = e;
                break;
            }

        }
        deleteElement.getParent().remove(deleteElement);

        //修改
//        for (Element element: lists) {
//            if (element.getName().equals("华为")){
//                element.setName("小米");
//                element.setText("kgc");
//            }
//        }


        OutputFormat outputFormat = new OutputFormat();
        outputFormat.setEncoding("UTF-8");
        XMLWriter writer = new XMLWriter(new FileWriter("phone1.txt"),outputFormat);
        writer.write(document1);
        writer.flush();
        writer.close();

    }
}
