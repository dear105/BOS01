package com.bosssoft.hr.train.xml;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomTest {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("./src/com/bosssoft/hr/train/xml/student.xml");
            NodeList StudentList = document.getElementsByTagName("student");
            System.out.println("DOM解析开始...");
            for (int i = 0; i < StudentList.getLength(); i++) {
                Node node = StudentList.item(i);
                NamedNodeMap attrs = node.getAttributes();
                for (int j = 0; j < attrs.getLength(); j++) {
                    Node attr = attrs.item(j);
                    System.out.println(attr.getNodeName() + ":" + attr.getNodeValue());
                }
                NodeList childNodes = node.getChildNodes();
                for (int k = 0; k < childNodes.getLength(); k++) {
                    if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
                        System.out.println(childNodes.item(k).getNodeName() + ": " + childNodes.item(k).getFirstChild().getNodeValue());
                    }
                }
            }
        }catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
