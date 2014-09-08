package date20140806;

public class QuizManager {

	private Quiz[] arr;
	private int idx = 0;
	
	public QuizManager() {
		super();
		
		arr = new Quiz[5];
		
		arr[0] = new Quiz(1, "'���� �ּ�' ��� ��ȭ�� 19�� �̻� �������� ", "X", 100);
		
		arr[1] = new ObjectiveQuiz(2, "�� ������¥?", "5", 500, 
				new String[]{"1 20140630.", "2. 20140726", "3. 20140728", "4. 20140729", "5.  20140730"});

		arr[2] = new ObjectiveQuiz(3, "�������� ���ΰ��̸����� ĿƼ������ ���� �ܱ���� �̸��� ?", "4", 500, 
				new String[]{"1 ���ݶ� ȦƮ.", "2. ��Į�� ���ѽ�", "3. ���� ��Ʈ��", "4.  ũ���� ���ݽ�", "5. �����ظ���"});		
		
		arr[3] = new SubjectiveQuiz(4,"[�� X���� �Ҹ� �ϳ׾��� �޳��󰥶����ϰ� ��質 �Ѵ����]��� ��簡 ������ ��ȭ�̸���?", "�Ǹ��� ���Ҵ�",800, "�Ǹ��� ���Ҵ�.");
		
		arr[4] = new SubjectiveQuiz(5,"����� ��⸦ ������ �굥��\n\n�׸��� �� ��⸦ �ǿ�鼭 ����\n\n�� ��Ⱑ �� ���ư���,\n\n�� �� ����� �״°�����\n\n�׷��� � ����� �׾ ��Ⱑ ���� ����� �ֵ���\n\n�׸��� �� ��⸦ �ٸ��̿��� �ű�� ����� �ֱ���\n\n�׷� �� ���� ��Ⱑ ������ ���� �� �ְ���?\n\n��...�� ����� ��⸦ �˾ƿ�\n\n���� ��𼭰� ���� ������ ���� �� �־��\n\n�� ����� �� �츰 �и��� �������� ��ƿ�\n\n���� ����....���� ���.....\n\n���� ��⸦ ���ϸ鼭 �׷��� �� �� �־��\n\n1979���� �� ����̿�........	\n\n2000�⿡���� �� �� �����ſ���\n\n��� ���縦 ���� ��ȭ��?", "���� ", 800, "���� ");
		
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
