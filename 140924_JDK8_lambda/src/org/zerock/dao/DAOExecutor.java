package org.zerock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Interface's static Example 
 * 
 * @author Zerock
 *
 */
public interface DAOExecutor {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url ="jdbc:oracle:thin:@server:1521:SID";
	String user="user00";
	String pw ="user00";
	
	public static <T> T execute(String sql, DAOFunction fn, DAOConsumer<T> rs)throws Exception{
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		try{
			con = makeConnection();
			pstmt = con.prepareStatement(sql);
			resultSet = fn.apply(pstmt);
		
			if(resultSet != null){
				return rs.accept(resultSet);
			}
			
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}finally{
			if(resultSet != null) { try{ resultSet.close();}catch(Exception e){} }
			if(pstmt != null) { try{ pstmt.close();}catch(Exception e){} }
			if(con != null) { try{ con.close();}catch(Exception e){} }
		}
		return null;
		
	}

	public static Connection makeConnection()throws Exception{

		Class.forName(driver);
		return DriverManager.getConnection(url, user,pw);
		
	}
		
	
	
	
}
