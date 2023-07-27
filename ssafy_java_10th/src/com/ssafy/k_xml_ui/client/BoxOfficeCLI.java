package com.ssafy.k_xml_ui.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.ssafy.k_xml_ui.parse.dto.BoxOffice;
import com.ssafy.k_xml_ui.parse.parser.BoxOfficeDomParser;
import com.ssafy.k_xml_ui.parse.parser.BoxOfficeJsonParser;
import com.ssafy.k_xml_ui.parse.parser.BoxOfficeParser;
import com.ssafy.k_xml_ui.parse.parser.BoxOfficeSaxParser;

public class BoxOfficeCLI {
    private BoxOfficeParser parser = null;
    private InputStream resource = null;

    public BoxOfficeCLI() {
        // TODO: resource와 parser를 구성해서 정보를 가져와보자.
    	//parser= BoxOfficeSaxParser.getParser();
//    	parser=BoxOfficeDomParser.getParser();
    	parser=BoxOfficeJsonParser.getParser();
//    	resource= BoxOfficeCLI.class.getResourceAsStream("../res/boxoffice.xml");
        try {
        	resource = new URL("http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20120101").openStream();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch( IOException e) {
			e.printStackTrace();
		}
    	// END
    }

    private void readBoxOfficeList() {
        List<BoxOffice> list = parser.getBoxOffice(resource);
        System.out.println("결과 크기: "+ list.size());
        for (BoxOffice boxOffice : list) {
            System.out.println(boxOffice);
        }
    }

    public static void main(String[] args) {
        BoxOfficeCLI cli = new BoxOfficeCLI();
        cli.readBoxOfficeList();
    }
}
