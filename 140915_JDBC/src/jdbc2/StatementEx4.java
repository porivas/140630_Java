package jdbc2;


public class StatementEx4 {

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		//	
		for (int i = 0; i < 100; i++) {
			new SqlAgent(){
				@Override
				protected void doJob() throws Exception {
					// TODO Auto-generated method stub	
					pstmt = con.prepareStatement("select sysdate from dual");
					rs = pstmt.executeQuery();
					rs.next();
					System.out.println(rs.getString(1));
				}
			}.doExecute();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
