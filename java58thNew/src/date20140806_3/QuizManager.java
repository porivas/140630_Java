package date20140806_3;

public class QuizManager {

	private Quiz[] arr;
	private int idx = 0;
	
	public QuizManager() {
		super();
		
		arr = new Quiz[3];
		
		arr[0] = new Quiz(1, "�̼����屺�� ��ȣ�� �湫���̴�", "O", 100);
		
		arr[1] = new ObjectiveQuiz(2, "�����ֶ��� �Ⱓ�� ����ΰ�?", "2", 500, 
				new String[]{"1.5��", "2.7��", "3.10��", "4.12��"});
		
		arr[2] = new SubjectiveQuiz(3,"�� ���� �װ����� �̸���?", "NASA", 800, "����");
		
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
