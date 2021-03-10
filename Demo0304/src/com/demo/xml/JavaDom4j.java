package com.demo.xml;

import com.demo.bean.Good;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：小兵
 * @date ：2021-03-04 10:23
 * @Description:
 */
public class JavaDom4j {
    public static void main(String[] args) throws DocumentException {
        ArrayList<Good> arrayList=new ArrayList<>();
        SAXReader saxReader = new SAXReader();
        //Document document = saxReader.read(JavaDom4j.class.getResourceAsStream("goods.xml"));
        Document document = saxReader.read("Demo0304/src/com/demo/xml/goods.xml");
        Element element =document.getRootElement();//获得根元素
        List<Element> list = element.elements();//获取所有子元素
        for (Element element1 :list){
            Good good=new Good();
            String id =element1.attributeValue("id");//获取指定属性名的属性值
            System.out.println("id:"+id);
            good.setId(id);
            List<Element>listElem=element1.elements();
            for (Element element2 : listElem) {
                String name =element2.getName();
                String text=element2.getText();
                System.out.println(name+":"+text);
                if (name.equals("name")){
                    good.setName(text);
                }else if (name.equals("firm")){
                    good.setFirm(text);
                }else if (name.equals("price")){
                    good.setPrice(Double.valueOf(text));
                }
            }
            arrayList.add(good);
        }
        for (Good good : arrayList) {
            System.out.println(good.toString());
        }
    }
}
