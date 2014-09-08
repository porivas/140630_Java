package org.thinker.fs;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class MakeInstance {

	public static Map<String, Task> loadTask(String fileName, FoodStoreService service) throws Exception {
		
		Map<String, Task> taskMap = new HashMap<String, Task>();
		
		Properties prop = new Properties();
		prop.load(new FileInputStream(fileName));
		
		Iterator names = prop.keySet().iterator();
		while(names.hasNext()){
			String key = (String)names.next();
			String value = (String)prop.get(key);
			System.out.println(key +":" + value);
			
			Task obj = (Task)Class.forName(value).newInstance();
			obj.setService(service);
			
			taskMap.put(key, obj);
		}
		
		return taskMap;
	}

}







