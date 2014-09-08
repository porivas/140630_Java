package firstServlet;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Mp3Server {
	
	private ServerSocket serverSocket;
	private Map<String, Agentlet> agentMap; 
	
	//생성자
	public Mp3Server(int port) throws Exception{
		this.serverSocket = new ServerSocket(port);
		System.out.println("ready............");
		agentMap = new HashMap<String, Agentlet>();
		readyAgent();
		mainLoop();
	}
	
	//말그대로 기능에 맞게 만들어놓은 ~~Agentlet을 추가하는 메소드
	public void readyAgent(){
		
		//사용자가 원하는 기능을 사용하기위해 port뒤에 붙이는 url패턴을 구분하여
		//그에 해당하는 기능을 수행하는 ~~Agentlet()을 만들어 key, value로 넣어준다.
		//let은 조각이라는 뜻으로 servlet은 서버의조각..이러한 의미
		agentMap.put("/list", new ListAgentlet()); 
		agentMap.put("/listen", new ListenAgentlet()); 
	}
	
	//서버를 반복적으로 돌게하여 주기능을 수행하는 메소드
	public void mainLoop()throws Exception{
		
		ServerSocket server = this.serverSocket;
		
		while(true){			
			Socket socket = server.accept();
			System.out.println("Client Connect...." + socket);
			
			//client(브라우져, 크롬,...)로부터 소켓이 연결되면 해당 client의 정보(url,....)를 InputStream으로 받는다.
			InputStream in = socket.getInputStream(); 
			OutputStream out = socket.getOutputStream();
			
			try{
				Agentlet agent = null; //url요청 정보가 바뀔때마다 계속 사용해야하기때문에 null로선언
				
				//in으로 들어오는 client의 모든 url정보는 RequestInputStream클래스가 가지게된다.
				RequestInputStream request = new RequestInputStream(in);
				ResponseOutputStream response = 
									new ResponseOutputStream(out, new ByteArrayOutputStream());
				
				if(request.getExt().equals("htm") == false){				
					agent = new StrictAgentlet();
				} else				
					agent = agentMap.get(request.getUrlPageName());
					//agent = new ListAgentlet();
					
				//////////////////////////////////////////////////////////////////
				agent.doJob(request, response);				
				response.getBos().writeTo(response.getOut());
				//////////////////////////////////////////////////////////////////
			
			}catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}finally{
				try{ in.close(); }catch(Exception e){}				
				try{ out.close(); }catch(Exception e){}
				try{ socket.close(); }catch(Exception e){}
			}
			//server.close();
		}				
	}
	
	public static void main(String[] args) throws Exception{	
		Mp3Server server = new Mp3Server(5555);
	}
}




//<audio src= "경로" controls="controls" Autoplay>













