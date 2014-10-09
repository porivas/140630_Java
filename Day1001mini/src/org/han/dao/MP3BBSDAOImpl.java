package org.han.dao;

import java.util.ArrayList;
import java.util.List;

import org.han.vo.MP3VO;

public class MP3BBSDAOImpl implements MP3BBSDAO {
	
   enum SQL {
      
         INSERT(" insert into tbl_mp3 (MNO,TITLE,FILENAME,DESCCONT,CATE,USERID,ART,IMG,ALB)"
            + " values (seq_mp3.nextval, ?, ?, ?, ?, ?, ?, ?, ?)"),
         SELECT(" select * from ( select /*+INDEX_DESC(tbl_mp3, pk_mp3) */ rownum rn, mno, title, art, img"
            + " from tbl_mp3 where mno>0 and rownum<= ? ) where rn >? "),
         UPDATE("  update tbl_mp3 set title = ? where mno = ?"),
         DELETE("   delete from tbl_mp3 where mno = ?"),
         MP3INFO(" select * from tbl_mp3 where mno = ?" );
         
         String value;
         
         SQL(String value) {
            this.value = value;
         }
   }

   @Override
   public void addMp3(MP3VO vo) throws Exception {
      
      new SQLExecutor(){

         @Override
         protected void doJob() throws Exception {

            pstmt = con.prepareStatement(SQL.INSERT.value);
            pstmt.setString(1, vo.getTitle()); //노래제목
            pstmt.setString(2, vo.getFileName()); //파일경로
            pstmt.setString(3, vo.getDescCont()); //노래 설명
            pstmt.setString(4, vo.getCate()); // 장르
            pstmt.setString(5, vo.getUserID()); //업로드한 사람
            pstmt.setString(6, vo.getArt()); // 가수
            pstmt.setString(7, vo.getImg()); // 그림파일 경로
            pstmt.setString(8, vo.getAlb()); // 앨범

            
            int resultCount = pstmt.executeUpdate();
            
            if (resultCount < 1){
               throw new Exception("INSERT ERROR!!");
            } 
            
            
            //TITLE,FILENAME,DESCCONT,CATE,USERID,RCOUNT,VCOUNT,ART,IMG,ALB
         }
         
      }.execute();

   }

   @Override
   public List<MP3VO> mainList(Integer maxNum, Integer minNum) throws Exception {
      
	   final List<MP3VO> mp3VO = new ArrayList<MP3VO>(); 
      new SQLExecutor(){
         
         @Override
         protected void doJob() throws Exception{
            pstmt = con.prepareStatement(SQL.SELECT.value);
            pstmt.setInt(1, maxNum);
            pstmt.setInt(2, minNum);
            // sname, addr, keyword, tel, sdesc
            rs = pstmt.executeQuery();

            while(rs.next()){
            	MP3VO tempVO = new MP3VO();
               //mp3Vo를 이용해서 리스트를 넣어준다.
               //한줄씩 넘어가면서 널이 아닌값을 넣어줘야 한다.
               tempVO.setRn (rs.getInt(1));
               tempVO.setMno(rs.getInt(2));
               tempVO.setTitle(rs.getString(3));
               tempVO.setArt(rs.getString(4));
               tempVO.setImg(rs.getString(5));
               mp3VO.add(tempVO);
            }
         }
      }.execute();
      
      return mp3VO;
     

   }

   @Override
   public void update(MP3VO vo) throws Exception {
      
      new SQLExecutor(){

         @Override
         protected void doJob() throws Exception {

            pstmt = con.prepareStatement(SQL.UPDATE.value);
            pstmt.setString(1, vo.getTitle());
            pstmt.setInt(2, vo.getMno());
            
            
            int resultCount = pstmt.executeUpdate();
            
            if (resultCount < 1){
               throw new Exception("UPDATE ERROR!!");
            }
         }
      }.execute();
   }

   @Override
   public void delete(Integer mno) throws Exception {

      new SQLExecutor(){

         @Override
         protected void doJob() throws Exception {

            pstmt = con.prepareStatement(SQL.DELETE.value);
            pstmt.setInt(1, mno);
            
            int resultCount = pstmt.executeUpdate();
            
            if (resultCount < 1){
               throw new Exception("DELETE ERROR!!");
            }
         }
      }.execute();
   }

@Override
public MP3VO MP3Info(Integer mno) throws Exception {
	final MP3VO tempVO = new MP3VO(); 
    new SQLExecutor(){      
       @Override
       protected void doJob() throws Exception{
          pstmt = con.prepareStatement(SQL.MP3INFO.value);
          pstmt.setInt(1, mno);
          rs = pstmt.executeQuery();
          while(rs.next()){
             //mp3Vo를 이용해서 리스트를 넣어준다.
             //한줄씩 넘어가면서 널이 아닌값을 넣어줘야 한다.
//             tempVO.setRn (rs.getInt(1));
//             tempVO.setMno(rs.getInt(2));
          	//제목, 가수, 장르, 등록일자, 등록자, 설명, 파일 이름
             tempVO.setTitle(rs.getString(2));
             tempVO.setFileName(rs.getString(3));
             tempVO.setDescCont(rs.getString(4));
             tempVO.setCate(rs.getString(5));
             tempVO.setUserID(rs.getString(6));
             // rCount, vCount 생략
             tempVO.setRegDate(rs.getDate(9));
             tempVO.setArt(rs.getString(10));
             tempVO.setImg(rs.getString(11));
             tempVO.setAlb(rs.getString(12));
          }
       }
    }.execute();   
	return tempVO;
}


}
