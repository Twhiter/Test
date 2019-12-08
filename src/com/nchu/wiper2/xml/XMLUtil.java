package com.nchu.wiper2.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @author T.Whiter
 * @Date 2019/11/20 19:06
 * @Version 1.0
 */
public class XMLUtil {

    /***
     * 根据相关的节点名字，在配置文件中获取该类，并返回
     * @param tagName 节点名字
     * @return  对应对象的Class
     */
    public static  Class getBean(String tagName,String fileName)
    {
        try
        {
            //创建文档对象
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File(fileName));

            //获取包含类名的文本节点
            NodeList nl = doc.getElementsByTagName(tagName);
            Node classNode=nl.item(0).getFirstChild();
            String cName=classNode.getNodeValue().trim();

            //返回类
            return Class.forName(cName);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
