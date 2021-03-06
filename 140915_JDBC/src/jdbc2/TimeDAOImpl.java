package jdbc2;

public class TimeDAOImpl implements TimeDAO {
	
	// 이렇게 잡아주는게 가장 퍼포먼스가 좋다. 
	private static final String query = "select sysdate from dual";
	
	@Override
	public String getTime() throws Exception {
		
		final StringBuilder builder = new StringBuilder();
		// final은 값 자체가 고정되는 것이 아니라, 내용물이 고정되는 것이다. 
		// 문자열은 immutable 한 번 값이 지정되면 바뀌지 않는다. 
		// final 에 <List>를 넣으면 List에 값을 추가하는 것이 가능함 
		
		new SqlAgent(){
			@Override
			protected void doJob() throws Exception{
				pstmt = con.prepareStatement(query);
				rs = pstmt.executeQuery();
				rs.next();
			}
		}.doExecute();
		// TODO Auto-generated method stub
		return builder.toString();
	}

}
