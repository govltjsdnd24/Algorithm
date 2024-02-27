package com.ssafy.k_xml_ui.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest02 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = dbf.newDocumentBuilder();
		Document doc=parser.parse("addr.xml");
		System.out.println(doc.getNodeName()+","+doc.getNodeValue());
		Element root = doc.getDocumentElement();
		NodeList items= root.getElementsByTagName("정보");
		System.out.println(items);
		
		List<Person>list= new ArrayList();
		
		for (int i = 0; i < items.getLength(); i++) {
			Node item= items.item(i);
			Person p = new Person();
			NodeList children= item.getChildNodes();
			for (int j = 0; j < children.getLength(); j++) {
				Node child = children.item(j);
//				System.out.println(child.getNodeName());
				if(child.getNodeName().equals("이름")){
					p.setName(child.getFirstChild().getNodeValue());
				} else if (child.getNodeName().equals("email")) {
					p.setEmail(child.getFirstChild().getNodeValue());
				} else if (child.getNodeName().equals("휴대전화")) {
					p.setMobile(child.getFirstChild().getNodeValue());
				} else if (child.getNodeName().equals("주소")) {
					p.setAddress(child.getFirstChild().getNodeValue());
				}
			}
			list.add(p);
		}
		System.out.println(list);
		

		
	}

}
