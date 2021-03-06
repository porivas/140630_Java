package org.han.foodstore.dao;

import org.han.foodstore.util.SqlAgent;
import org.han.vo.StoreVO;

public class FoodStoreDAOImpl implements FoodStoreDAO {
	
	enum SQL{
		
		INSERT(" insert into tbl_yh_store (sno, sname, addr, keyword, tel, sdesc)"
				+ " values(sql_store.nextval, ?, ?, ?, ?, ?)"),
		// , 로 추가하는 것 알아둘 것. 
		SELECT("  select * from tbl_yh_store where SNO = ?"),
		UPDATE("  update tbl_yh_store set sname = ?, addr = ?, keyword = ?, tel = ?, sdesc = ? where sno = ?"),
		DELETE("   delete from TBL_YH_STORE  where sno = ?");
		String value;
		
		SQL(String value){
			this.value = value;
		}
	}

	@Override
	public void create(final StoreVO vo) throws Exception {
		// sname, addr, keyword, tel, sdesc
		new SqlAgent(){
			@Override
			protected void doJob() throws Exception{
				pstmt = con.prepareStatement(SQL.INSERT.value);
				pstmt.setString(1, vo.getSname());
				pstmt.setString(2, vo.getAddr());
				pstmt.setString(3, vo.getKeyword());
				pstmt.setString(4, vo.getTel());
				pstmt.setString(5, vo.getSdesc());
				
				// 이게 1이라는 건 한 건이 insert 된 것이다. 
				int resultCount = pstmt.executeUpdate();
				
				if (resultCount <1){
					throw new Exception("INSERT ERROR");
				}
			}
		}.doExecute();

	}
	StoreVO tempVO;
	@Override
	public StoreVO read(final Integer sno) throws Exception {
		//   select * from tbl_yh_store where SNO = ?
		
		tempVO = new StoreVO();
		new SqlAgent(){
			
			@Override
			protected void doJob() throws Exception{
				pstmt = con.prepareStatement(SQL.SELECT.value);
				pstmt.setInt(1, sno);
				// sname, addr, keyword, tel, sdesc
				rs = pstmt.executeQuery();
				rs.next();
				tempVO.setSno(rs.getInt(1));
				tempVO.setSname(rs.getString(2));
				tempVO.setAddr(rs.getString(3));
				tempVO.setKeyword(rs.getString(4));
				tempVO.setTel(rs.getString(5));
				tempVO.setSdesc(rs.getString(6));
				tempVO.setRegdate(rs.getDate(7));

				if (tempVO == null){
					throw new Exception("READ ERROR");
				}
			}
		}.doExecute();
		return tempVO;
		
	}

	@Override
	public void update(StoreVO vo) throws Exception {
		// sno, sname, addr, keyword, tel, sdesc
		new SqlAgent(){

			@Override
			protected void doJob() throws Exception{
				pstmt = con.prepareStatement(SQL.UPDATE.value);
				//sname, addr, keyword, tel, sdesc, sno
				pstmt.setString(1, vo.getSname());
				pstmt.setString(2, vo.getAddr());
				pstmt.setString(3, vo.getKeyword());
				pstmt.setString(4, vo.getTel());
				pstmt.setString(5, vo.getSdesc());
				pstmt.setLong(6, vo.getSno());

				int resultCount = pstmt.executeUpdate();
				
				if (resultCount <1){
					throw new Exception("UPDATE ERROR");
				}
			}
		}.doExecute();
	}

	@Override
	public void delete(Integer sno) throws Exception {
		// TODO Auto-generated method stub
		new SqlAgent(){
			@Override
			protected void doJob() throws Exception {
				// TODO Auto-generated method stub
				pstmt = con.prepareStatement(SQL.DELETE.value);
				pstmt.setInt(1, sno);
				rs = pstmt.executeQuery();
				if(rs != null){
					throw new Exception("DELETE ERROR");
				}
			}
		}.doExecute();
	}
}
