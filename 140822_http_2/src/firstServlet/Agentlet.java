package firstServlet;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

//Agentlet클래스에서 공통적으로 할일과 반드시있어야할 doJop추상메소드가 있는 추상클래스
public abstract class Agentlet {
	
	//static으로 선언하여 hashMap을 이용해서 확장자와 컨텐츠타입을 key, value로...
	static Map<String, String> mimeMap;
	
	static {
		mimeMap = new HashMap<String, String>();
		mimeMap.put("mp3","audio/mpeg3");
		mimeMap.put("jpg","image/jpeg");
		mimeMap.put("htm", "text/html");
	}
	
	//Server가 Client로 response를해줄 때 header부분을 만들어주는 메소드 
	public void makeResponseHearder(String ext, int size,  ResponseOutputStream res) throws Exception{
		OutputStream out = res.getOut();
		out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
		out.write(new String("Cache-Control: private\r\n").getBytes()); 
	    out.write(new String("Content-Length: " + size + "\r\n").getBytes()); 
	    out.write(new String("Content-Type: " + mimeMap.get(ext) + "; charset=utf-8\r\n\r\n").getBytes());
	}

	public abstract void doJob(RequestInputStream request, ResponseOutputStream response)throws Exception;
	
}











