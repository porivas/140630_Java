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
		
		//ByteArrayOutputStream에서는 writeTo뿐 아니라 write함수또한있다.
		//ByteArrayOutputStream빨대 안에서 msg를 getBytes한것을 가지고있는상태
		response.getBos().write(msg.getBytes());
		
		//response.getBos().size()는 ByteArrayOutputSream빨대가 담고있는것(msg.getBytes)의 사이즈
		makeResponseHearder(request.getExt(), response.getBos().size(), response);
	}

}
