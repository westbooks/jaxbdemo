package utils;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @author 施晓峰
 * @create 2018-06-20 14:54
 * @desc  xml读取工具类
 **/
public class XMLs {
    public static Document getDocFromStringXml(File file){
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        Document document = null;
        try {
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            document=documentBuilder.parse(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }
}
