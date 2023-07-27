package com.ssafy.k_xml_ui.parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonTest02 {

	public static void main(String[] args) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("object.json")));
		
		JSONParser parser= new JSONParser();
		parser.parse(br);
		
		JSONArray objs = new JSONArray();
		ArrayList<Person> list = new ArrayList();
		Person p =null;
		
		for (int i = 0; i < objs.size(); i++) {
			p=new Person();
			JSONObject obj= (JSONObject)objs.get(i);
			p.setName(obj.get("휴대전화"));
			p.setName(obj.get("이름"));
			p.setName(obj.get("이름"));
			
		}
	}

}
