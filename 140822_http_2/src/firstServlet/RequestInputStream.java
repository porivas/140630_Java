package firstServlet;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Scanner;

//아주 중요!! RequestInputStream객체는 client로부터 들어오는 url을정보를 전부 잘게 죠져서 전부 가지고있다!!(getter로 불러와서 사용)
public class RequestInputStream {

	private InputStream in;
	private Scanner scanner;
	private String urlPattern; //사용자가 원하는 기능을 입력해주는 url패턴부분전체
	private String urlPage; // /~~.jsp, /~~.html과 같은 사용자가 처음에 사용하고자할 기능의 페이지url
	private String ext; // jsp, html, htm과 같은 확장자명
	private String query; //?뒷 부분 ==> file=aaa.mp3
	
	private String urlPageName; // ~~.jsp, ~~.html에서 ~~
	private String fileName; // aaa.mp3
	
	//생성자
	public RequestInputStream(InputStream in) throws Exception{
		
		this.in = in;
		this.scanner = new Scanner(in);
		
		//client(브라우져, 크롬,..)의 정보를 Scanner로 맨윗줄 한줄을 읽어온다.
		//이내용 ==> 1. GET /listen?file=aaa.mp3 HTTP/1.1
		//         2. GET /list.htm HTTP/1.1 ==> 뒤에 .htm을 붙인것은 나만의 약속 동적인 자원을 처리할때
		//									       즉, 코드에서 직접 데이터를생성해서 client로 보내줄때 붙이는 약속..
		parsingRequest(scanner.nextLine());
	}
	
	//url을 파싱하는 메소드
	private void parsingRequest(String dataStr) throws Exception {

		//GET / HTTP1.1	
		String[] arr = dataStr.split(" ");		
		this.urlPattern = URLDecoder.decode(arr[1],"utf-8");
		
		
		//?문자는 앞에 \를하나더 넣어주어야 인식한다. 그런데 2번과같이 ?가없이 들어오는 url패턴은 그냥 지나간다.
		//그래서 파싱하는 작업을 ?까지 구분해주는 작업을 한꺼번에 넣어도 된다.
		String[] outerArr = urlPattern.split("\\?"); 								
		this.urlPage = outerArr[0]; 
		System.out.println(outerArr[0]);
		
		String[] outerArr2 = outerArr[0].split("\\."); //listen.htm?file=aaa.mp3
		this.urlPageName = outerArr2[0];
		System.out.println(urlPageName);
		
		this.ext = outerArr[0].substring(outerArr[0].indexOf(".")+1);	
		
		if(outerArr.length > 1){
			this.query = outerArr[1]; 
			String[] outArr3 = query.split("=");
			this.fileName = outArr3[1];
			System.out.println(outArr3[1]);
		}		
	}
	
	//getter메소드
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
	
	public String getUrlPageName() {
		return urlPageName;
	}

	public String getExt() {
		return ext;
	}

	public String getQuery() {
		return query;
	}
	
	public String getFileName() {
		return fileName;
	}

}






