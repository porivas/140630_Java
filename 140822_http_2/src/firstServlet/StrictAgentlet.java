package firstServlet;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class StrictAgentlet extends Agentlet {

	private static final String ROOT = "C:\\zzz\\mp3";
	
	@Override
	public void doJob(RequestInputStream request, ResponseOutputStream response) throws Exception {
		// /aaa.mp3
		String targetFileName = request.getUrlPage();
		String ext = request.getExt();
		
		System.out.println("ext(확장자명) :" + ext);
		
		ByteArrayOutputStream bos = response.getBos();
		
		File targetFile = new File(ROOT + targetFileName.replaceAll("//", File.pathSeparator));
		// File.pathSeparator는 '\\'를 의미한다. 즉 RequestInputStream클래스에서 가져온 urlPage는 /가 들어가있기때문에
		// '/'을 '\\'로 바꿔주면 폴더내의 해당 파일까지 접근이되는것이다. 
		System.out.println(targetFile);
		
		//만들어놓은 CopyUtil클래스를 이용하여 FileInputStream으로 읽어온 파일을 ByteArrayOutputStream에 넣어준상태
		CopyUtil.copy(new FileInputStream(targetFile), bos, true, false);
		
		//그래서 header를 만들어줄때 확장자명과 읽어온파일의 사이즈와 response를넘겨준다. 
		makeResponseHearder(ext, bos.size(), response);		
	}
}










