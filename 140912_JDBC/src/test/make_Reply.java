package test;

public class make_Reply {
	public static void main(String[] args) {
		
		//16386
		int max = 16876;

		for (int i = 0 ; i < 1000 ; i++){
			
			// �ƹ� �Խñۿ��� ������ �ޱ� ���� ���̰�
			//0 ~ 99 ������ ���� ����
			int value =(int)(Math.random()*100);
			
			String sql = "insert into tbl_reply (REPLY_NO, BBSNO, reply, replyer) values " + 
			"(seq_reply.nextval,"+(max - value) + ", '����...','user01');";
			
			System.out.println(sql);
		}
	}

}
