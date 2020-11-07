package com.bosssoft.hr.train.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {
    private int StudentIndex = 0;

    // 解析开始的标志
    @Override
    public void startDocument() throws SAXException {
        System.out.println("SAX解析开始...");
    }

    // 解析结束的标志
    @Override
    public void endDocument() throws SAXException {
        System.out.println("SAX解析结束...");
    }

    // 用来遍历XML文件的开始标签
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // 调用DefaultHandler类的startElement方法
        super.startElement(uri, localName, qName, attributes);
        // 开始解析Student元素节点
        if (qName.equals("student")) {
            ++StudentIndex;
            System.out.println("开始解析第" + StudentIndex + "个学生");
            //输出XML属性，也就是XML文件中的num属性，注意在因使用属性而引起的一些问题：
            /*1 ，属性无法包含多重的值（元素可以）
            2，属性无法描述树结构（元素可以）
            3，属性不易扩展（为未来的变化）
            4，属性难以阅读和维护
            5，请尽量使用元素来描述数据。而仅仅使用属性来提供与数据无关的信息。*/
            for (int i = 0; i < attributes.getLength(); ++i) {
                System.out.println(attributes.getQName(i) + "：" + attributes.getValue(i));
            }
        } else if (!qName.equals("Students")) {
            System.out.print(qName + "：");//输出元素值
        }
    }

    // 用来遍历XML文件的结束标签
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        // 判断一个学生是否解析完
        if (qName.equals("Student")) {
            System.out.println("结束解析第" + StudentIndex + "个学生");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String text = new String(ch, start, length);
        if (!text.trim().equals("")) {
            System.out.println(text);
        } // if
    }
}
