package date20140806_3;

public class QuizManager {

	private Quiz[] arr;
	private int idx = 0;
	
	public QuizManager() {
		super();
		
		arr = new Quiz[3];
		
		arr[0] = new Quiz(1, "이순신장군의 사호는 충무공이다", "O", 100);
		
		arr[1] = new ObjectiveQuiz(2, "임진왜란의 기간은 몇년인가?", "2", 500, 
				new String[]{"1.5년", "2.7년", "3.10년", "4.12년"});
		
		arr[2] = new SubjectiveQuiz(3,"미 우주 항공국의 이름은?", "NASA", 800, "나사");
		
	}
	
	public Quiz getNextQuiz(){
		if(idx == arr.length){
			return null;
		}
		return arr[idx++];	
	}

	public Quiz[] getArr() {
		return arr;
	}

	public void setArr(Quiz[] arr) {
		this.arr = arr;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}
	

		
/*	for (Quiz quiz : arr) {
		System.out.println(quiz.getQuestion());
	}*/
	
	
}
