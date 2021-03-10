package com.demo.xml;

import com.demo.bean.Good;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;

/**
 * Java JDK里的SAX解析方式
 */
public class JavaSAX {
    //定义保存整个解析结果的集合
    static ArrayList<Good> goods = null;
    //定义解析标志变量
    static boolean nameTag = false;
    static boolean priceTag = false;
    static boolean firmTag = false;
    static Good good;

    public static void main(String[] args) throws Exception {
        //创建一个SAX解析器
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
        //xml的sax方式解析
        SaxHandler handler = new SaxHandler();
        saxParser.parse(JavaSAX.class.getResourceAsStream("goods.xml"), handler);
    }

    static class SaxHandler extends DefaultHandler2 {
        Good currentGood = null;

        /**
         * 整个文档开始解析时，调用该函数
         *
         * @throws SAXException
         */
        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
            System.out.println("文档开始解析");
            //当文档开始解析时，我们给ArrayList<Good>进行赋值
            goods = new ArrayList<>();
        }


        /**
         * 整个文档结束解析时，调用该函数
         *
         * @throws SAXException
         */
        @Override
        public void endDocument() throws SAXException {
            System.out.println();
            System.out.println("文档解析结束");
            super.endDocument();
            System.out.println(goods);
        }

        /**
         * 标签节点开始解析事件
         *
         * @param uri
         * @param localName
         * @param qName
         * @param attributes
         * @throws SAXException
         */
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println();
            System.out.println("开始进行标签解析");
            System.out.println("qName = " + qName);//qname 就是标签名称
            System.out.println("attributes = " + attributes.getValue(0));
            switch (qName) {
                case "good":
                    good = new Good();
                    good.setId(attributes.getValue(0));
                    break;
                case "name":
                    nameTag = true;
                    break;
                case "price":
                    priceTag = true;
                    break;
                case "firm":
                    firmTag = true;
                    break;
                default:
                    break;
            }
        }

        /**
         * 标签节点结束解析事件
         *
         * @param uri
         * @param localName
         * @param qName
         * @throws SAXException
         */
        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("结束标签解析事件");
            System.out.println("qName = " + qName);
            if (qName.equals("good")) {
                goods.add(good);
                good = null;
            }
        }

        /**
         * 文本节点解析事件
         *
         * @param ch
         * @param start
         * @param length
         * @throws SAXException
         */
        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("文本节点解析事件");
            System.out.println("文本节点内容（" + new String(ch, start, length) + ")");
            String str = new String(ch, start, length);
            if (nameTag == true){
                good.setName(str);
                nameTag = false;
            }else if (priceTag == true){
                good.setPrice(Double.valueOf(str));
                priceTag = false;
            }else if (firmTag == true){
                good.setFirm(str);
                firmTag = false;
            }
        }
    }
}
