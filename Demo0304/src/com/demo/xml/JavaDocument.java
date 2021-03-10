package com.demo.xml;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Java JDK中W3C的document解析方式 DOM解析XML
 */
public class JavaDocument {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        //先通过DocumentBuilderFactory 创建一个documentBuilder实例
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        //documentBuilder专门用来解析XML文档。并且获得一个Document对象
        Document document = documentBuilder.parse(JavaDocument.class.getResourceAsStream("goods.xml"));
        //获取文档的字符编码 和 版本信息
        String xmlEncoding = document.getXmlEncoding();
        String xmlVersion = document.getXmlVersion();
        System.out.println(xmlEncoding);
        System.out.println(xmlVersion);
        //和JavaScript获取标签对象一样 返回一个NodeList
        NodeList nodeList = document.getElementsByTagName("good");
        //获取
        int length = nodeList.getLength();
        System.out.println("节点个数为:" + length);
        //遍历
        for (int i = 0; i < length; i++) {
            //获取每一个标签对象
            Node goodNode = nodeList.item(i);
            //获取标签名
            String goodNodeName = goodNode.getNodeName();
            System.out.println("第" + (i + 1) + "个标签名:" + goodNodeName);
            System.out.println("属性遍历开始");
            //获取属性节点集合
            NamedNodeMap goodNodeAttributes = goodNode.getAttributes();
            //获取属性长度
            int attrLength = goodNodeAttributes.getLength();
            for (int j = 0; j < attrLength; j++) {
                Node attrNode = goodNodeAttributes.item(j);
                System.out.println(attrNode.getNodeName() + ":" + attrNode.getNodeValue());
            }
            System.out.println("属性遍历结束");
            System.out.println("子节点遍历开始");
            //获取每一个good标签的子元素对象集合
            NodeList goodNodeChildList = goodNode.getChildNodes();
            //获取good标签子节点长度
            int goodNodeChildListLength = goodNodeChildList.getLength();
            System.out.println("子节点个数为:" + goodNodeChildListLength);
            for (int j = 0; j < goodNodeChildListLength; j++) {
                //获取good标签对象中的每一个子节点
                Node goodNodeChildNode = goodNodeChildList.item(j);
                System.out.println(goodNodeChildNode);
                //判断是否属于标签节点
                if (goodNodeChildNode.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println("标签节点");
                    //获取节点的标签名
                    String nodeTagName = goodNodeChildNode.getNodeName();
                    //获取标签内的文本内容
                    String nodeInnerHTML = goodNodeChildNode.getTextContent();
                    //打印内容
                    System.out.println("标签名:" + nodeTagName + ",文本内容:" + nodeInnerHTML);
                } else if (goodNodeChildNode.getNodeType() == Node.TEXT_NODE) {
                    System.out.println("文本节点");
                }
                System.out.println();
            }
            System.out.println("子节点遍历结束");
        }
    }
}
