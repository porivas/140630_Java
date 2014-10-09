package org.zerock.sample3;

public class GradeVO {

	private final String subject;
	private final int grade;
	
	public GradeVO(String subject, int grade) {
		super();
		this.subject = subject;
		this.grade = grade;
	}

	public String getSubject() {
		return subject;
	}

	public int getGrade() {
		return grade;
	}

	@Override
	public String toString() {
		return "GradeVO [subject=" + subject + ", grade=" + grade + "]";
	}
	
	
}
