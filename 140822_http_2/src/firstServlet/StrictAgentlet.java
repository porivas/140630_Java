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
		
		System.out.println("ext(Ȯ���ڸ�) :" + ext);
		
		ByteArrayOutputStream bos = response.getBos();
		
		File targetFile = new File(ROOT + targetFileName.replaceAll("//", File.pathSeparator));
		// File.pathSeparator�� '\\'�� �ǹ��Ѵ�. �� RequestInputStreamŬ�������� ������ urlPage�� /�� ���ֱ⶧����
		// '/'�� '\\'�� �ٲ��ָ� �������� �ش� ���ϱ��� �����̵Ǵ°��̴�. 
		System.out.println(targetFile);
		
		//�������� CopyUtilŬ������ �̿��Ͽ� FileInputStream���� �о�� ������ ByteArrayOutputStream�� �־��ػ���
		CopyUtil.copy(new FileInputStream(targetFile), bos, true, false);
		
		//�׷��� header�� ������ٶ� Ȯ���ڸ�� �о�������� ������� response���Ѱ��ش�. 
		makeResponseHearder(ext, bos.size(), response);		
	}
}










