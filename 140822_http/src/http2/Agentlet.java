package http2;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public abstract class Agentlet {
	
	static Map<String, String> mimeMap;
	
	// 전역 변수로 확장자에 따라 어떤 태그를 쓸 지를 매핑 
	static {
		mimeMap = new HashMap<String, String>();
		mimeMap.put("mp3","audio/mpeg3");
		mimeMap.put("jpg","image/jpeg");
		
	}
	
	// 헤더 보내주기. 확장자와 사이즈, out과 bos를 가지고 있는 res를 파라미터로 받는다. 
	public void makeResponseHearder(String ext, int size,  ResponseOutputStream res)throws Exception{
		OutputStream out = res.getOut();
		out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
		out.write(new String("Cache-Control: private\r\n").getBytes()); 
	    out.write(new String("Content-Length: "+size+"\r\n").getBytes()); 
	    out.write(new String("Content-Type: "+ mimeMap.get(ext)+"; charset=UTF-8\r\n\r\n").getBytes());
	}
	
	public abstract void doJob(
			RequestInputStream request, 
			ResponseOutputStream response)throws Exception;
	
}











