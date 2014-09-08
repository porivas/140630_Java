package date20140806;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizStage {
	
	private QuizManager manager1 = new QuizManager();
	private ChanceManager chance1 = new ChanceManager();
	private String userName;
	private Quiz currentQuiz;
	private boolean oxValue;
	private int userMoney;
	

	Scanner sc = new Scanner (System.in); 
	
	public QuizStage() throws InterruptedException{
		//this.phoneChance();
		this.createUser();
		this.solveQuestions();
	}
	
	
	public void showAllChance(){
		int cnt = 0;
		for (Chance item : chance1.getArr()){
			if(item == null){
				continue;
			}
			cnt++;
			System.out.println(cnt + "번 : " + item);
		}
	}
	
	
	
	
	public boolean nextOrStop(){
		System.out.println("다음문제 할거면 1 , 그만할꺼면 0 ");
		String goNext = sc.nextLine();
		if (goNext.equals("1")){
			System.out.println("다음문제로 간다.");
			return true;
		}
			System.out.println("종료합니다.");
			return false;
	}
	
	public void createUser(){
		System.out.println("퀴즈쇼에 오신걸 환영합니다. ");
		System.out.print("이름을 입력하세요 : ");
		userName = sc.nextLine();
		System.out.println(userName + " 님 ㅎㅇ");
	}
	
	public void showQuestion(Quiz quiz1){
		System.out.println(quiz1.getOrd() + "번 문제입니다. 문제 상금 : " + quiz1.getRewards() + "원");
		System.out.println(quiz1.getQuestion());
	}
	
	public String askAnswer(){
		System.out.print("답을 입력해주세요: ");
		String userAnswer = sc.nextLine();
		return userAnswer;
	}
	
	
	public int addMoney(int amount){
		this.userMoney = this.userMoney + amount;
		System.out.println("현재 상금은 " + this.userMoney + "입니다.");
		return this.userMoney;
	}
	
	
	public void phoneChance() throws InterruptedException {
		      Timer t = new Timer(true);
		      //TimerTask task1 = new MyTimeTask();
		      System.out.println("전화퀴즈는 30초간 진행됩니다.");
//		      t.schedule(task1, 0);
		      double countSec = 0;
		      for (double i = 0; i < 300 ; i++) {
		         countSec = i/10;
		         System.out.println("30초가 되면 끝납니다: "+countSec+"초");
		         Thread.sleep(100); //1000이 1초 // 실행시까지 대기
		      }
		      System.out.println("이제 전화퀴즈를 종료합니다.");
		      return;
		   }
	
	
	public void solveQuestions() throws InterruptedException{
		Chance chanceInstance = null;
		currentQuiz = manager1.getNextQuiz();
		System.out.println("===========================================");
		this.showQuestion(currentQuiz);
		System.out.println("===========================================");
		System.out.println("찬스를 쓰시겠습니까?(쓰려면 y, 안쓰려면 n)");
		if(sc.nextLine().equals("y")){
			this.showAllChance();
			System.out.println("쓰고싶은 찬스의 번호를 입력해주세요");
			int userResponse = Integer.parseInt(sc.nextLine());
			chanceInstance = chance1.getSelectedChance(userResponse);
			chanceInstance.chanceEvent(currentQuiz);
			//chance1.getArr()[userResponse-1] = null;
			
			if((chanceInstance.getClass().getName()).equals("date20140806.EraserChance")){
				for(int i = 0; i < 2; i++){
					if((((EraserChance)chanceInstance).getResult(currentQuiz))){
						if(!this.nextOrStop()){
							return;
						}
						this.solveQuestions();
					}else if(i == 1){
						System.out.println("모든 기회 다 쓰셨으니 다음기회에 도전하세요!!");
						return;
					}
				}
			}else if((chanceInstance.getClass().getName()).equals("date20140806.ARSChance")){
						this.phoneChance();
					}
			
		}
			oxValue = currentQuiz.checkAnswer(this.askAnswer());
			if (oxValue){
				System.out.println("정답!");
				this.addMoney(currentQuiz.getRewards());
				if (manager1.getArr().length == manager1.getIdx())
				{
					System.out.println("준비된 퀴즈를 전부 맞추셨습니다. 축하합니다.");
					return;
				}
				if(!this.nextOrStop()){
					return;
				}
			}
			else{
				System.out.println("오답! 다음기회에...");
				return;
			}
			this.solveQuestions();
		}
}
