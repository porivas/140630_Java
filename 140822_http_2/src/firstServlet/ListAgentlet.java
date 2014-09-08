package firstServlet;
import java.io.File;

public class ListAgentlet extends Agentlet {

	private static final String ROOT = "C:\\zzz\\mp3\\";
	
	@Override
	public void doJob(RequestInputStream request, ResponseOutputStream response) throws Exception {
		
		File targetFile = new File(ROOT);
		String[] mp3List = targetFile.list();
		StringBuilder builder = new StringBuilder();
		                
        for (String mp3Name : mp3List) {          
           builder.append("<ui><li>" + "<a href='listen.htm?file=" + mp3Name + "'>"+mp3Name+"</a></li></ui>");   
        }
		
		//String msg = "<hr> Hello World </hr>";	
        String msg = builder.toString();
		
		//ByteArrayOutputStream������ writeTo�� �ƴ϶� write�Լ������ִ�.
		//ByteArrayOutputStream���� �ȿ��� msg�� getBytes�Ѱ��� �������ִ»���
		response.getBos().write(msg.getBytes());
		
		//response.getBos().size()�� ByteArrayOutputSream���밡 ����ִ°�(msg.getBytes)�� ������
		makeResponseHearder(request.getExt(), response.getBos().size(), response);
	}

}
