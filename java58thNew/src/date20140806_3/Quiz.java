package date20140806_3;

public class Quiz {
	
	// 문제번호, 질문, 정답
	private int ord;
	private String question;
	private String answer;
	private int rewards;
	
	public Quiz(int ord, String question, String answer, int rewards) {
		super();
		this.ord = ord;
		this.question = question;
		this.answer = answer;
		this.rewards = rewards;
	} 
	
	public boolean checkAnswer(String useranswer){

		return this.answer.equals(useranswer);
	}

	public int getOrd() {
		return ord;
	}

	public String getQuestion() {
		return question;
	}

	public int getRewards() {
		return rewards;
	}

	public void setRewards(int rewards) {
		this.rewards = rewards;
	}

	@Override
	public String toString() {
		return "Quiz [ord=" + ord + ", question=" + question + ", answer="
				+ answer+ ", rewards=" + rewards  + "]";
	}
	
	
	
}
