package firstServlet;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

//ResponseOutputStream객체는 Server가 Client에게 데이터를 전송할때 필요한 OutputStream과 ByteArrayOutputStream을
//매개변수로받아 사용을 할수있도록.....
public class ResponseOutputStream {

	private OutputStream out;
	private ByteArrayOutputStream bos;
	
	public ResponseOutputStream(OutputStream out, ByteArrayOutputStream bos) {
		super();
		this.out = out;
		this.bos = bos;
	}

	public OutputStream getOut() {
		return out;
	}

	public ByteArrayOutputStream getBos() {
		return bos;
	}

}
