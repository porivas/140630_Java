package io3;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

public class propertiesTest {
	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream("C:\\zzz\\Mp3User.properties2.txt"));
		Iterator names = props.keySet().iterator();
		while(names.hasNext()){
			String var1 = (String) names.next();
			String var2 = (String) props.get(var1);
			System.out.println(var1+" : "+var2);
		}
		
	}

}
