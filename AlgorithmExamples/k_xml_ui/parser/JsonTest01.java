package com.ssafy.k_xml_ui.parser;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonTest01 {

	public static void main(String[] args) throws IOException {
		//JSONObject 
		//JSONArray
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("이름","둘리");
		jsonData.put("email","abc@abc.com");
		jsonData.put("휴대전화","0101234567");
		jsonData.put("주소","쌍문동");
		
		JSONArray persons= new JSONArray();
		persons.add(jsonData);
		
		jsonData= new JSONObject();
		jsonData.put("이름","도우너");
		jsonData.put("email","bbb@abc.com");
		jsonData.put("휴대전화","0108888888");
		jsonData.put("주소","깐따삐아");
		persons.add(jsonData);
		
		jsonData= new JSONObject();
		jsonData.put("이름","또치");
		jsonData.put("email","eeee@abc.com");
		jsonData.put("휴대전화","0109999999");
		jsonData.put("주소","써커스");
		persons.add(jsonData);
		
		JSONObject contact= new JSONObject();
		contact.put("주소록",persons);
		
		System.out.println(contact.toJSONString());
		
		BufferedWriter bw= new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream("object.json")));
		bw.write(contact.toJSONString());
		bw.close(); 
	}

}

