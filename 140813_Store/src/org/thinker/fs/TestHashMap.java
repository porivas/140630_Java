package org.thinker.fs;

import java.util.HashMap;
import java.util.Set;

public class TestHashMap {
	public static void main(String[] args) {
		
		HashMap<String, String> testHash = new HashMap<String, String>();
		testHash.put("±èÅÂÈñ", "167");
		testHash.put("±èÀ±¾Æ", "152");
		testHash.put("±è»ç¶û", "175");
		System.out.println(testHash);
		System.out.println(testHash.get("±èÀ±¾Æ"));
		System.out.println(testHash.keySet());
		Set newList = testHash.keySet();
	}
	
}
