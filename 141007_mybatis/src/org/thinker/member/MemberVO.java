package org.thinker.member;

public class MemberVO {
	
	// 일부러 DB와 이름을 맞췄는데 그럴 필요까지는 없다. 
	// 다만, 유지보수의 용이점을 위해 일치. 
	private String userid;
	private String userpw;
	private String username;
	private String phone;
	private String email;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", userpw=" + userpw
				+ ", username=" + username + ", phone=" + phone + ", email="
				+ email + "]";
	}
	
	
	
	

}
