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
	
	//������
	public Mp3Server(int port) throws Exception{
		this.serverSocket = new ServerSocket(port);
		System.out.println("ready............");
		agentMap = new HashMap<String, Agentlet>();
		readyAgent();
		mainLoop();
	}
	
	//���״�� ��ɿ� �°� �������� ~~Agentlet�� �߰��ϴ� �޼ҵ�
	public void readyAgent(){
		
		//����ڰ� ���ϴ� ����� ����ϱ����� port�ڿ� ���̴� url������ �����Ͽ�
		//�׿� �ش��ϴ� ����� �����ϴ� ~~Agentlet()�� ����� key, value�� �־��ش�.
		//let�� �����̶�� ������ servlet�� ����������..�̷��� �ǹ�
		agentMap.put("/list", new ListAgentlet()); 
		agentMap.put("/listen", new ListenAgentlet()); 
	}
	
	//������ �ݺ������� �����Ͽ� �ֱ���� �����ϴ� �޼ҵ�
	public void mainLoop()throws Exception{
		
		ServerSocket server = this.serverSocket;
		
		while(true){			
			Socket socket = server.accept();
			System.out.println("Client Connect...." + socket);
			
			//client(������, ũ��,...)�κ��� ������ ����Ǹ� �ش� client�� ����(url,....)�� InputStream���� �޴´�.
			InputStream in = socket.getInputStream(); 
			OutputStream out = socket.getOutputStream();
			
			try{
				Agentlet agent = null; //url��û ������ �ٲ𶧸��� ��� ����ؾ��ϱ⶧���� null�μ���
				
				//in���� ������ client�� ��� url������ RequestInputStreamŬ������ �����Եȴ�.
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




//<audio src= "���" controls="controls" Autoplay>













