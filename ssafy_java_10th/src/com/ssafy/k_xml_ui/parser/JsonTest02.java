package com.ssafy.k_xml_ui.parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonTest02 {

	public static void main(String[] args) throws IOException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("object.json")));
		
		JSONParser parser= new JSONParser();
		JSONObject parse = (JSONObject) parser.parse(br);
		
//		parser.parse(br);
		
		JSONArray objs = (JSONArray)parse.get("주소록");
		ArrayList<Person> list = new ArrayList();
		Person p =null;
		
		for (int i = 0; i < objs.size(); i++) {
			p=new Person();
			JSONObject obj= (JSONObject)objs.get(i);
			p.setMobile(obj.get("휴대전화").toString());
			p.setName(obj.get("이름").toString());
			p.setAddress(obj.get("주소").toString());
			p.setEmail(obj.get("email").toString());
			list.add(p);
		}
		System.out.println(list);
	}

}
