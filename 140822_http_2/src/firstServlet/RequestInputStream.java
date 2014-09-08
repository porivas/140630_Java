package firstServlet;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Scanner;

//���� �߿�!! RequestInputStream��ü�� client�κ��� ������ url�������� ���� �߰� ������ ���� �������ִ�!!(getter�� �ҷ��ͼ� ���)
public class RequestInputStream {

	private InputStream in;
	private Scanner scanner;
	private String urlPattern; //����ڰ� ���ϴ� ����� �Է����ִ� url���Ϻκ���ü
	private String urlPage; // /~~.jsp, /~~.html�� ���� ����ڰ� ó���� ����ϰ����� ����� ������url
	private String ext; // jsp, html, htm�� ���� Ȯ���ڸ�
	private String query; //?�� �κ� ==> file=aaa.mp3
	
	private String urlPageName; // ~~.jsp, ~~.html���� ~~
	private String fileName; // aaa.mp3
	
	//������
	public RequestInputStream(InputStream in) throws Exception{
		
		this.in = in;
		this.scanner = new Scanner(in);
		
		//client(������, ũ��,..)�� ������ Scanner�� ������ ������ �о�´�.
		//�̳��� ==> 1. GET /listen?file=aaa.mp3 HTTP/1.1
		//         2. GET /list.htm HTTP/1.1 ==> �ڿ� .htm�� ���ΰ��� ������ ��� ������ �ڿ��� ó���Ҷ�
		//									       ��, �ڵ忡�� ���� �����͸������ؼ� client�� �����ٶ� ���̴� ���..
		parsingRequest(scanner.nextLine());
	}
	
	//url�� �Ľ��ϴ� �޼ҵ�
	private void parsingRequest(String dataStr) throws Exception {

		//GET / HTTP1.1	
		String[] arr = dataStr.split(" ");		
		this.urlPattern = URLDecoder.decode(arr[1],"utf-8");
		
		
		//?���ڴ� �տ� \���ϳ��� �־��־�� �ν��Ѵ�. �׷��� 2�������� ?������ ������ url������ �׳� ��������.
		//�׷��� �Ľ��ϴ� �۾��� ?���� �������ִ� �۾��� �Ѳ����� �־ �ȴ�.
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
	
	//getter�޼ҵ�
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






