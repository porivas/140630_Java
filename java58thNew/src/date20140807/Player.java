package date20140807;

import java.util.Scanner;

	

public class Player {
   public int myLocation; //���ݳ���ġ
   public int myMoney;    //��
   public String myName;   //�÷��̾� �̸�
   public int playerNum;  //�������̵� 
   public static int playerCnt;
   Scanner scanner; 
   
   //������
   public Player(String myName) {
      super();
      this.myLocation = 0;
      this.myMoney = 1500;
      this.myName = myName;
      this.playerNum += playerCnt;
      playerCnt++;
//      this.playerNum = playerNum;
   }
   //���� ��ġ �� �����ֱ�
   public int getMyLocation() {
      return myLocation;
   }
   //���� ��ġ �� ����
   public void setMyLocation(int myLocation) {
      this.myLocation = myLocation;
   }
   // ���� �Ӵ� �� �����ֱ�
   public int getMyMoney() {
      return myMoney;
   }
   // ���� �Ӵ� �� ����
   public void setMyMoney(int myMoney) {
      this.myMoney = 30;
      this.myMoney = myMoney;
   }
   // ���� �̸� �����ֱ�
   public String getMyName() {
      return myName;
   }
   // ���� �̸� ����
   public void setMyName(String myName) {
      this.myName = myName;
   }
   // �������̵� �����ֱ�
   public int getPlayerNum() {
      return playerNum;
   }
   //���� ���̵� ����
   public void setPlayerNum(int playerNum) {
      this.playerNum = playerNum;
   }
@Override
public String toString() {
	return "Player [myLocation=" + myLocation + ", myMoney=" + myMoney
			+ ", myName=" + myName + ", playerNum=" + playerNum + ", scanner="
			+ scanner + "]";
}

   
}