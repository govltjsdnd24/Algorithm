package com.ssafy.k_xml_ui.parse.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.ssafy.k_xml_ui.parse.dto.BoxOffice;

public class BoxOfficeSaxParser extends DefaultHandler implements BoxOfficeParser {
    // TODO: singleton 형태로 작성해보자.
	private static BoxOfficeSaxParser parser = new BoxOfficeSaxParser();
	
	public static BoxOfficeSaxParser getParser() {
		return parser;
	}
	
	private BoxOfficeSaxParser() {
		
	}
    // END

    // 파싱된 내용을 저장할 List
    private List<BoxOffice> list = new ArrayList<>();
    // 현재 파싱하고 있는 대상 객체
    private BoxOffice current;
    // 방금 읽은 텍스트 내용
    private String content;

    @Override
    public List<BoxOffice> getBoxOffice(InputStream resource) {
        // TODO: SAXParser를 구성하고 boxoffice.xml을 파싱하시오.
    	SAXParserFactory factory = SAXParserFactory.newInstance();
    	try {
			SAXParser parser= factory.newSAXParser();
			parser.parse(resource,this);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        // END
        return list;
    }

    // TODO: 필요한 매서드를 재정의 하여 boxOffice.xml을 파싱하시오.
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    	if(qName.contentEquals("dailyBoxOffice")) {
    		current = new BoxOffice();
    	}
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    	if(qName.equals("rank")) {
    		current.setRank(Integer.parseInt(content));
    	} else if (qName.equals("movieNm")){
    		current.setMovieNm(content);
    	} else if (qName.equals("openDt")){
    		current.setOpenDt(current.toDate(content));
    	} else if (qName.equals("audiAcc")){
    		current.setAudiAcc(Integer.parseInt(content));
    	} else if (qName.equals("dailyBoxOffice")) {
    		this.list.add(current);
    	}
    }
    
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
    	content= String.valueOf(ch,start,length);
    }
    
    @Override
    public void startDocument() throws SAXException {
    	// TODO Auto-generated method stub
    	System.out.println("문서 읽기 시작");
    	
    }
    
    @Override
    public void endDocument() throws SAXException {
    	// TODO Auto-generated method stub
    	System.out.println("문서 읽기 종료");
    }
    // END
}
