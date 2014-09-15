package test;

public class make_Reply {
	public static void main(String[] args) {
		
		//16386
		int max = 16876;

		for (int i = 0 ; i < 1000 ; i++){
			
			// 아무 게시글에나 리플을 달기 위한 더미값
			//0 ~ 99 까지의 값이 나옴
			int value =(int)(Math.random()*100);
			
			String sql = "insert into tbl_reply (REPLY_NO, BBSNO, reply, replyer) values " + 
			"(seq_reply.nextval,"+(max - value) + ", '리플...','user01');";
			
			System.out.println(sql);
		}
	}

}
