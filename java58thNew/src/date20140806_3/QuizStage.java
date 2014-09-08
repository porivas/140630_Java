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
			System.out.println(cnt + "ë²? : " + item);
		}
	}
	
	
	
	
	public boolean nextOrStop(){
		System.out.println("?‹¤?Œë¬¸ì œ ?• ê±°ë©´ 1 , ê·¸ë§Œ?• êº¼ë©´ 0 ");
		String goNext = sc.nextLine();
		if (goNext.equals("1")){
			System.out.println("?‹¤?Œë¬¸ì œë¡? ê°„ë‹¤.");
			return true;
		}
			System.out.println("ì¢…ë£Œ?•©?‹ˆ?‹¤.");
			return false;
	}
	
	public void createUser(){
		System.out.println("?´ì¦ˆ?‡¼?— ?˜¤?‹ ê±? ?™˜?˜?•©?‹ˆ?‹¤. ");
		System.out.print("?´ë¦„ì„ ?…? ¥?•˜?„¸?š” : ");
		userName = sc.nextLine();
		System.out.println(userName + " ?‹˜ ?…?…‡");
	}
	
	public void showQuestion(Quiz quiz1){
		System.out.println(quiz1.getOrd() + "ë²? ë¬¸ì œ?…?‹ˆ?‹¤. ë¬¸ì œ ?ƒê¸? : " + quiz1.getRewards() + "?›");
		System.out.println(quiz1.getQuestion());
	}
	
	public String askAnswer(){
		System.out.print("?‹µ?„ ?…? ¥?•´ì£¼ì„¸?š”: ");
		String userAnswer = sc.nextLine();
		return userAnswer;
	}
	
	
	public int addMoney(int amount){
		this.userMoney = this.userMoney + amount;
		System.out.println("?˜„?¬ ?ƒê¸ˆì? " + this.userMoney + "?…?‹ˆ?‹¤.");
		return this.userMoney;
	}
	
	
	public void phoneChance() throws InterruptedException {
		      Timer t = new Timer(true);
		      //TimerTask task1 = new MyTimeTask();
		      System.out.println("? „?™”?´ì¦ˆ?Š” 30ì´ˆê°„ ì§„í–‰?©?‹ˆ?‹¤.");
//		      t.schedule(task1, 0);
		      double countSec = 0;
		      for (double i = 0; i < 300 ; i++) {
		         countSec = i/10;
		         System.out.println("30ì´ˆê? ?˜ë©? ??‚©?‹ˆ?‹¤: "+countSec+"ì´?");
		         Thread.sleep(100); //1000?´ 1ì´? // ?‹¤?–‰?‹œê¹Œì? ??ê¸?
		      }
		      System.out.println("?´? œ ? „?™”?´ì¦ˆë¥? ì¢…ë£Œ?•©?‹ˆ?‹¤.");
		      return;
		   }
	
	
	public void solveQuestions() throws InterruptedException{
		Chance chanceInstance = null;
		currentQuiz = manager1.getNextQuiz();
		this.showQuestion(currentQuiz);
		
		System.out.println("ì°¬ìŠ¤ë¥? ?“°?‹œê² ìŠµ?‹ˆê¹??");
		if(sc.nextLine().equals("y")){
			this.showAllChance();
			System.out.println("?“°ê³ ì‹¶?? ì°¬ìŠ¤?˜ ë²ˆí˜¸ë¥? ?…? ¥?•´ì£¼ì„¸?š”");
			int userResponse = Integer.parseInt(sc.nextLine());
			chanceInstance = chance1.getSelectedChance(userResponse);
			chanceInstance.chanceEvent(currentQuiz);
		}
		
		if((chanceInstance.getClass().getName()).equals("date20140806.EraserChance")){
			for(int i = 0; i < 2; i++){
				if((((EraserChance)chanceInstance).getResult(currentQuiz))){
					this.solveQuestions();
				}else if(i == 1){
					System.out.println("ëª¨ë“  ê¸°íšŒ ?‹¤ ?“°?…¨?œ¼?‹ˆ ?‹¤?Œê¸°íšŒ?— ?„? „?•˜?„¸?š”!!");
					return;
				}
			}
		}else{
			 if((chanceInstance.getClass().getName()).equals("date20140806.ARSChance")){
					this.phoneChance();
				}
			oxValue = currentQuiz.checkAnswer(this.askAnswer());
			if (oxValue){
				System.out.println("? •?‹µ!");
				this.addMoney(currentQuiz.getRewards());
				if (manager1.getArr().length == manager1.getIdx())
				{
					System.out.println("ì¤?ë¹„ëœ ?´ì¦ˆë¥? ? „ë¶? ë§ì¶”?…¨?Šµ?‹ˆ?‹¤. ì¶•í•˜?•©?‹ˆ?‹¤.");
					return;
				}
				if(!this.nextOrStop()){
					return;
				}
			}
			else{
				System.out.println("?˜¤?‹µ! ?‹¤?Œê¸°íšŒ?—...");
				return;
			}
			this.solveQuestions();
		}
	}
}
