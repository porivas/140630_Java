package org.thinker.fs.DAO;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.thinker.fs.Logic.FoodStoreService;
import org.thinker.fs.UI.Task;

public class MakeInstance {
	
	// static �����޼ҵ� why?? ������ �����ϱ� ���� 
	// Map<String, Task>Ÿ���� ���𰡸� ����
	// StringŸ���� fileName, FoodStoreServiceŸ���� service�� �Ķ���ͷ�
	public static Map<String, Task>  loadTask  (String fileName, FoodStoreService service) throws Exception {
		
		// HashMap�ϳ� ���� Map Ÿ���� taskMap�� ����
		Map<String, Task> taskMap = new HashMap<String, Task>();
		
		// properties InputStream�̶� ������ �߶󳻴� ����� ����Ǿ� ����
		// properties�� ���� ���������� Ȯ����. ���������� ���� ��������ǰ�?
		Properties prop = new Properties(); // ������ �ڵ����� �߶��ֱ� ���� ����
		prop.load(new FileInputStream(fileName));
		// Iterator�� �ڹ��� �ݺ���. (�ݺ��ڴ� �ܺιݺ��ڿ� ���ιݺ��ڷ� �����µ�, �ڹٴ� �ܺιݺ��ڸ� ����)
		// ��ü�� ��ҵ��� ����� ��, ������ �ε��� ���� �̿��� ȣ���� �����ϴٰ� �����ؼ� ���� ���� ����̴�.
		Iterator names = prop.keySet().iterator();
		// �� ������ ���ذ� �Ȱ�
		while(names.hasNext()){			// ���� ���� �������� ����
			String key = (String)names.next();		// �������ҷ���
			String value = (String)prop.get(key);	// Ű �� �ε�
			System.out.println(key +":" + value);	
			
			Task obj = (Task)Class.forName(value).newInstance();
			// ���Ͽ��� Ŭ���� ��θ� �ҷ��ͼ� ��ü����
			obj.setService(service);
			
			taskMap.put(key, obj);
		}
		
		return taskMap;
	}

}
