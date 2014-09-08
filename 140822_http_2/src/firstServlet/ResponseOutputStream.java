package firstServlet;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

//ResponseOutputStream��ü�� Server�� Client���� �����͸� �����Ҷ� �ʿ��� OutputStream�� ByteArrayOutputStream��
//�Ű������ι޾� ����� �Ҽ��ֵ���.....
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
