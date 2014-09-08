package http2;

import java.io.InputStream;
import java.util.Scanner;

public class RequestInputStream {

	private InputStream in;
	private Scanner scanner;
	private String urlPattern;
	private String urlPage;
	private String ext;
	private String query;
	
	
	
	public RequestInputStream(InputStream in){
		
		this.in = in;
		this.scanner = new Scanner(in);
		parsingRequest(scanner.nextLine());
	}
	
	private void parsingRequest(String dataStr) {

		//GET / HTTP1.1
		
		String[] arr = dataStr.split(" ");
		
		this.urlPattern =  arr[1];
		
		String[] outerArr = urlPattern.split("\\?");
		
		this.urlPage = outerArr[0];
		this.ext = outerArr[0].substring(outerArr[0].indexOf(".")+1);
		
		if(outerArr.length > 1){
			this.query = outerArr[1];
		}
		
	}

	public InputStream getIn() {
		return in;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public String getUrlPattern() {
		return urlPattern;
	}

	public String getUrlPage() {
		return urlPage;
	}

	public String getExt() {
		return ext;
	}

	public String getQuery() {
		return query;
	}
	
	
	

}






