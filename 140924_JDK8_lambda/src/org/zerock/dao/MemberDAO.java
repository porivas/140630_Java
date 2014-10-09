package org.zerock.dao;

import org.zerock.vo.MemberVO;

/**
 * Only use for Test
 * 
 * @author Zerock
 * 
 * 2014.10.1 --> use static 
 *
 */
public class MemberDAO {

	
	public static void create(MemberVO vo)throws RuntimeException{
		
		String sql ="insert into tbl_member (userid, userpw, username, email) values (?,?,?,?)";
		
	
		try {
			DAOExecutor.execute(sql, 
				(pstmt) ->{
						pstmt.setString(1, vo.getId());
						pstmt.setString(2, vo.getPw());
						pstmt.setString(3, vo.getName());
						pstmt.setString(4, vo.getEmail());
						pstmt.executeUpdate();
					return null;
			}, null);
		} catch (Exception e) {
			//use only for debug
			e.printStackTrace();
			
		}		
	}
	
	public static MemberVO read(String id)throws Exception{
		
		String sql ="select userid, userpw, username, email from tbl_member where userid=? ";
		
		DAOFunction fn = (pstmt) -> {
				pstmt.setString(1, id);
				return pstmt.executeQuery();
		};
		
		DAOConsumer<MemberVO> consumer = (rs) -> {
			rs.next();
			MemberVO vo  = new MemberVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			return vo;
		};
		
		return DAOExecutor.execute(sql, fn, consumer);
				
	}	
}



