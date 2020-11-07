package com.bosssoft.hr.train.xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxTest {
    public static void main(String[] args){
        File file =new File("./src/com/bosssoft/hr/train/xml/student.xml");
        try {
            // 通过SAXParserFactory的静态方法newInstance()方法获取SAXParserFactory实例对象factory
            SAXParserFactory factory = SAXParserFactory.newInstance();
            // 通过SAXParserFactory实例的newSAXParser()方法返回SAXParser实例parser
            SAXParser saxParser = factory.newSAXParser();
            // 定义SAXParserHandler对象
            SaxHandler handler = new SaxHandler();
            // 解析XML文档
            saxParser.parse(file, handler);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




