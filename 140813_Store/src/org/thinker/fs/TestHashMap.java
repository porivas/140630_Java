package org.thinker.fs;

import java.util.HashMap;
import java.util.Set;

public class TestHashMap {
	public static void main(String[] args) {
		
		HashMap<String, String> testHash = new HashMap<String, String>();
		testHash.put("������", "167");
		testHash.put("������", "152");
		testHash.put("����", "175");
		System.out.println(testHash);
		System.out.println(testHash.get("������"));
		System.out.println(testHash.keySet());
		Set newList = testHash.keySet();
	}
	
}
