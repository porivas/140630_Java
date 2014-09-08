package firstServlet;

public class ListenAgentlet extends Agentlet {

	
	@Override
	public void doJob(RequestInputStream request, ResponseOutputStream response) throws Exception {
		
		//String play = "<audio src= "경로" controls="controls" autoplay="autoplay">";		
		String play = "<audio src= "+ request.getFileName() + " controls=\"controls\" autoplay=\"autoplay\">";
				
		response.getBos().write(play.getBytes());
		
		//mp3를 실행하기때문에 마임타입을 mp3로생각할수있는데 원래는 웹페이지에서 바로 mp3를 실행해주려면
		//오디오태그안에 경로를 단순히 해당 mp3파일로 넣어주고 마임타입을 설정해놓은 확장자(htm, 사용차가친것)로 넣어주면
		//서버가 클라이언트로 오디오태그를 응답해줄때 클라이언트는 오디오태그를 응답받고 다시 요청해서
		//mp3를 다운받는데 이때 mp3는 브라우져상에서 받아지고 바로 mp3가재생된다.		
		System.out.println("마임타입 : " + request.getExt()); 
		
		
		makeResponseHearder(request.getExt(), response.getBos().size(), response);		
	}
}
