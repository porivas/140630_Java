package org.han.storeuser.vo;
/**
 *   create table tbl_yh_User(
  userKey number,
  userID varchar2(20), 
  userName varchar2(500) not null,
  birthdate date, 
  SEX varchar2(20), 
  joindate date default sysdate
  );
 */
public class UserVO {
	
	Integer userKey;
	String userID;
	String userName;
	

}
