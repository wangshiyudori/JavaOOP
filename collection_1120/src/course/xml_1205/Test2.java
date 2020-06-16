package course.xml_1205;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Test2 {
    public static void main(String[] args) throws IOException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        Source source = new DOMSource();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer(source);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }

        transformer.setOutputProperty("aa","12");
        OutputStream outputStream = new FileOutputStream("phone.txt");
        StreamResult streamResult = new StreamResult(outputStream);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        streamResult.setWriter(outputStreamWriter);
        outputStreamWriter.write("aaaaaa");
        outputStreamWriter.flush();

        outputStreamWriter.close();
        outputStream.close();


    }
}
