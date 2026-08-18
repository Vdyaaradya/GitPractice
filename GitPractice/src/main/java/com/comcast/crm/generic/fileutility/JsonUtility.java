package com.comcast.crm.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.json.Json;

public class JsonUtility {

	public String getDataFromJsonFile(String key) throws Throwable, IOException, Throwable
	{
	JSONParser parser =new JSONParser();
	Object obj=	parser.parse(new FileReader("./src/main/resources/.appCommondata.json"));
	JSONObject map=(JSONObject)obj; //serialization
	String data=(String) map.get(key);
	return data;
			}
}



