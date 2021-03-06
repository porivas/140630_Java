package org.zerock.vo;

public class MemberVO {

	private final String id;
	private final String pw;
	private final String name;
	private final String email;
	
	public MemberVO(String id, String pw, String name, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name
				+ ", email=" + email + "]";
	}
	
	
	
}
