package date20140806_3;

public class SubjectiveQuiz extends Quiz {
	
	private String synonym;

	public SubjectiveQuiz(int ord, 
			String question, 
			String answer,
			int rewards,
			String synonym) {
		
		super(ord, question, answer, rewards);
		
		this.synonym = synonym;
	}

	@Override
	public boolean checkAnswer(String userAnswer) {
		// TODO Auto-generated method stub
		return 
				super.checkAnswer(userAnswer)||synonym.equals(userAnswer);
	}
	
	

}
