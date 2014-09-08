package firstServlet;

public class ListenAgentlet extends Agentlet {

	
	@Override
	public void doJob(RequestInputStream request, ResponseOutputStream response) throws Exception {
		
		//String play = "<audio src= "���" controls="controls" autoplay="autoplay">";		
		String play = "<audio src= "+ request.getFileName() + " controls=\"controls\" autoplay=\"autoplay\">";
				
		response.getBos().write(play.getBytes());
		
		//mp3�� �����ϱ⶧���� ����Ÿ���� mp3�λ����Ҽ��ִµ� ������ ������������ �ٷ� mp3�� �������ַ���
		//������±׾ȿ� ��θ� �ܼ��� �ش� mp3���Ϸ� �־��ְ� ����Ÿ���� �����س��� Ȯ����(htm, �������ģ��)�� �־��ָ�
		//������ Ŭ���̾�Ʈ�� ������±׸� �������ٶ� Ŭ���̾�Ʈ�� ������±׸� ����ް� �ٽ� ��û�ؼ�
		//mp3�� �ٿ�޴µ� �̶� mp3�� �������󿡼� �޾����� �ٷ� mp3������ȴ�.		
		System.out.println("����Ÿ�� : " + request.getExt()); 
		
		
		makeResponseHearder(request.getExt(), response.getBos().size(), response);		
	}
}
