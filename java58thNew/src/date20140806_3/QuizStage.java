package date20140806_3;

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
			cnt++;
			System.out.println(cnt + "�? : " + item);
		}
	}
	
	
	
	
	public boolean nextOrStop(){
		System.out.println("?��?��문제 ?��거면 1 , 그만?��꺼면 0 ");
		String goNext = sc.nextLine();
		if (goNext.equals("1")){
			System.out.println("?��?��문제�? 간다.");
			return true;
		}
			System.out.println("종료?��?��?��.");
			return false;
	}
	
	public void createUser(){
		System.out.println("?�즈?��?�� ?��?���? ?��?��?��?��?��. ");
		System.out.print("?��름을 ?��?��?��?��?�� : ");
		userName = sc.nextLine();
		System.out.println(userName + " ?�� ?��?��");
	}
	
	public void showQuestion(Quiz quiz1){
		System.out.println(quiz1.getOrd() + "�? 문제?��?��?��. 문제 ?���? : " + quiz1.getRewards() + "?��");
		System.out.println(quiz1.getQuestion());
	}
	
	public String askAnswer(){
		System.out.print("?��?�� ?��?��?��주세?��: ");
		String userAnswer = sc.nextLine();
		return userAnswer;
	}
	
	
	public int addMoney(int amount){
		this.userMoney = this.userMoney + amount;
		System.out.println("?��?�� ?��금�? " + this.userMoney + "?��?��?��.");
		return this.userMoney;
	}
	
	
	public void phoneChance() throws InterruptedException {
		      Timer t = new Timer(true);
		      //TimerTask task1 = new MyTimeTask();
		      System.out.println("?��?��?�즈?�� 30초간 진행?��?��?��.");
//		      t.schedule(task1, 0);
		      double countSec = 0;
		      for (double i = 0; i < 300 ; i++) {
		         countSec = i/10;
		         System.out.println("30초�? ?���? ?��?��?��?��: "+countSec+"�?");
		         Thread.sleep(100); //1000?�� 1�? // ?��?��?��까�? ??�?
		      }
		      System.out.println("?��?�� ?��?��?�즈�? 종료?��?��?��.");
		      return;
		   }
	
	
	public void solveQuestions() throws InterruptedException{
		Chance chanceInstance = null;
		currentQuiz = manager1.getNextQuiz();
		this.showQuestion(currentQuiz);
		
		System.out.println("찬스�? ?��?��겠습?���??");
		if(sc.nextLine().equals("y")){
			this.showAllChance();
			System.out.println("?��고싶?? 찬스?�� 번호�? ?��?��?��주세?��");
			int userResponse = Integer.parseInt(sc.nextLine());
			chanceInstance = chance1.getSelectedChance(userResponse);
			chanceInstance.chanceEvent(currentQuiz);
		}
		
		if((chanceInstance.getClass().getName()).equals("date20140806.EraserChance")){
			for(int i = 0; i < 2; i++){
				if((((EraserChance)chanceInstance).getResult(currentQuiz))){
					this.solveQuestions();
				}else if(i == 1){
					System.out.println("모든 기회 ?�� ?��?��?��?�� ?��?��기회?�� ?��?��?��?��?��!!");
					return;
				}
			}
		}else{
			 if((chanceInstance.getClass().getName()).equals("date20140806.ARSChance")){
					this.phoneChance();
				}
			oxValue = currentQuiz.checkAnswer(this.askAnswer());
			if (oxValue){
				System.out.println("?��?��!");
				this.addMoney(currentQuiz.getRewards());
				if (manager1.getArr().length == manager1.getIdx())
				{
					System.out.println("�?비된 ?�즈�? ?���? 맞추?��?��?��?��. 축하?��?��?��.");
					return;
				}
				if(!this.nextOrStop()){
					return;
				}
			}
			else{
				System.out.println("?��?��! ?��?��기회?��...");
				return;
			}
			this.solveQuestions();
		}
	}
}
