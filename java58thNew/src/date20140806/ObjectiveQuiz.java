package date20140806;

import java.util.Arrays;

public class ObjectiveQuiz extends Quiz {

	private String[] options;

	public ObjectiveQuiz(int ord, String question, String answer, int rewards,
			String[] options) {
		super(ord, question, answer, rewards);
		this.options = options;
	}

	@Override
	public String getQuestion() {

		return super.getQuestion() + Arrays.toString(this.options);
	}

}
