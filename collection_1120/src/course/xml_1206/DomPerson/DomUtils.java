package course.xml_1206.DomPerson;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

//获取doc的操作
public class DomUtils {
    public static Document getDoc(String path) throws Exception {
        //获取工厂
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //获取解析工厂
        DocumentBuilder db  = dbf.newDocumentBuilder();
        //解析xml获取doc
        return db.parse(new File("person.xml"));
    }

    //回写操作
    public static void xmlWrite(Document doc, String path) throws Exception{
        //回写工厂
        TransformerFactory tff = TransformerFactory.newInstance();
        Transformer tf = tff.newTransformer();
        DOMSource doms = new DOMSource(doc);
        OutputStream os = new FileOutputStream("person.xml");
        StreamResult sr = new StreamResult(os);
        //回写
        tf.transform(doms,sr);

    }
}
