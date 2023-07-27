package com.ssafy.k_xml_ui.parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.json.simple.parser.JSONParser;

public class JsonTest02 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("object.json")));
		JSONParser parser= new JSONParser();
	}

}
