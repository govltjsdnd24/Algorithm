package com.ssafy.k_xml_ui.parser;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class DOMTest01 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = dbf.newDocumentBuilder();
		Document root=parser.parse("addr.xml");
		System.out.println(root.getNodeName()+","+root.getNodeValue());
		Element rootEle = root.getDocumentElement();
		System.out.println(rootEle.getNodeName()+","+rootEle.getNodeValue());
		
		getNode(rootEle);
//		for (Node ch = rootEle.getFirstChild(); ch !=null; ch=ch.getNextSibling()) {
//			if(ch.getNodeType()==Node.ELEMENT_NODE)
//				System.out.println(ch.getNodeName());
//			
//		}
	}
	static void getNode(Node rootEle) {
		for(Node ch= rootEle.getFirstChild();ch!=null;ch=ch.getNextSibling()) {
			if(ch.getNodeType()==Node.ELEMENT_NODE) {
				System.out.println(ch.getNodeName());
				getNode(ch);
			} else if (ch.getNodeType()==Node.TEXT_NODE && ch.getNodeValue().trim().length()!=0) {
				System.out.println(ch.getNodeValue());
			}
		}
	}
}


