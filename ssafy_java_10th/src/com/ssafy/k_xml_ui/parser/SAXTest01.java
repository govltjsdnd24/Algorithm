package com.ssafy.k_xml_ui.parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXTest01 {
	List<Person> list;
	StringBuilder sb;
	Person p;
	
	class MyHandler extends DefaultHandler{
		@Override
		public void startDocument() throws SAXException {
			super.startDocument();
			list=new ArrayList();
			sb=new StringBuilder();
		}
		@Override
		public void endDocument() throws SAXException {
			// TODO Auto-generated method stub
			super.endDocument();
			
		}
		@Override
		public void startElement(String uri, String localName, String name, Attributes attr)
				throws SAXException {
			super.startElement(uri, localName, name, attr);
			if(name.equals("정보")){
				p=new Person();
			}
			
		}
		@Override
		public void endElement(String uri, String localName, String name) throws SAXException {
			super.endElement(uri, localName, name);
			if(name.equals("이름")) {
				p.setName(sb.toString().trim());
			} else if(name.equals("email")) {
				p.setEmail(sb.toString().trim());
			} else if(name.equals("휴대전화")) {
				p.setMobile(sb.toString().trim());
			} else if(name.equals("주소")) {
				p.setAddress(sb.toString().trim());
			} else if(name.equals("정보")) {
				list.add(p);
			}
			//sb.setLength(0);
		}
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			
			super.characters(ch, start, length);
			sb.append(ch,start,length);
			
		}
	}
		
	public void go()throws SAXException, IOException, ParserConfigurationException {
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser= factory.newSAXParser();
		parser.parse(new FileInputStream("addr.xml"),new MyHandler());
		
		System.out.println(list);
	
	}

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		new SAXTest01().go();
	}

}
