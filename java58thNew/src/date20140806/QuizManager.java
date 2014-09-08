package date20140806;

public class QuizManager {

	private Quiz[] arr;
	private int idx = 0;
	
	public QuizManager() {
		super();
		
		arr = new Quiz[5];
		
		arr[0] = new Quiz(1, "'물좀 주소' 라는 영화는 19세 이상 관람가다 ", "X", 100);
		
		arr[1] = new ObjectiveQuiz(2, "명량 개봉날짜?", "5", 500, 
				new String[]{"1 20140630.", "2. 20140726", "3. 20140728", "4. 20140729", "5.  20140730"});

		arr[2] = new ObjectiveQuiz(3, "설국열차 주인공이름으로 커티스역을 맡은 외국배우 이름은 ?", "4", 500, 
				new String[]{"1 니콜라스 홀트.", "2. 스칼렛 요한슨", "3. 조쉬 하트넷", "4.  크리스 에반스", "5. 에드해리스"});		
		
		arr[3] = new SubjectiveQuiz(4,"[야 X빠는 소린 니네엄마 달나라갈때나하고 담배나 한대줘봐]라는 대사가 나오는 영화이름은?", "악마를 보았다",800, "악마를 보았다.");
		
		arr[4] = new SubjectiveQuiz(5,"사람은 향기를 지나고 산데요\n\n그리고 그 향기를 피우면서 살고요\n\n그 향기가 다 날아가면,\n\n그 때 사람은 죽는가봐요\n\n그런데 어떤 사람은 죽어도 향기가 나는 사람이 있데요\n\n그리고 그 향기를 다른이에게 옮기는 사람도 있구요\n\n그럼 그 좋은 향기가 영원히 퍼질 수 있겠죠?\n\n나...그 사람의 향기를 알아요\n\n언제 어디서곤 눈을 감으면 맡을 수 있어요\n\n그 사람과 나 우린 분명같은 감정으로 살아요\n\n같은 슬픔....같은 기쁨.....\n\n같은 향기를 지니면서 그렇게 살 수 있어요\n\n1979년의 이 기분이요........	\n\n2000년에서도 알 수 있을거에요\n\n라는 명대사를 낳은 영화는?", "동감 ", 800, "동감 ");
		
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
