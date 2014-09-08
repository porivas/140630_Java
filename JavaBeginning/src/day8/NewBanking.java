package day8;

class Account{
	public String name;
	public long balance;

	public Account(){

	}
	public Account(String name){
		this.name = name;
		System.out.println(name+"님의 계좌가 만들어졌습니다.");
	}
	public void deposit(long amount){
		this.balance = this.balance + amount;
		System.out.println(name+"님의 계좌에 "+ amount+"원이 입금되어 "+balance+"원이 되었습니다.");
	}
	public void withdraw(long amount){
		if(amount <= balance){
			this.balance = this.balance - amount;
			System.out.println(name+"님의 계좌에 "+ amount+"원이 출금되어 "+balance+"원이 되었습니다.");
		}
		else
			System.out.println("잔고가 부족합니다.");
	}
	public long getBalance(){
		return balance;
	}
}

class AccountManager{
	private int accountNum;
	private Account[] arr;
	// Account 타입(클래스)의 arr 배열을 생성. 

	public AccountManager(){
		arr = new Account[10];
		// 길이 10인 arr 배열을 생성.
	}
	public void newAccount(String name){
		if (accountNum <10)
			arr[accountNum++]=new Account(name);
		else
			System.out.println("계좌가 10개를 초과했습니다.");
	}
	public void deposit(String name, long amount){
		for (int i = 0; i <accountNum; i++)
		{
			if(arr[i].name.equals(name)){
				arr[i].deposit(amount);
				break;
			}
		}
	}
	public void withdraw(String name, long amount){
		for (int i = 0; i <accountNum; i++)
		{
			if(arr[i].name.equals(name)){
				arr[i].withdraw(amount);
				break;
			}
		}
	}
	public String getBalance(String name){
		String str = null;
		for (int i = 0; i <accountNum; i++)
		{
			if(arr[i].name.equals(name)){
				str = name+"님의 잔고는"+arr[i].getBalance()+"원 입니다.";
				break;
			}
		}
		return str;
	}
}

public class NewBanking {
	public static void main(String[] args){
		AccountManager am = new AccountManager();
		am.newAccount("손오공");
		am.newAccount("저팔계");
		am.newAccount("사오정");
		am.deposit("손오공", 1000);
		System.out.println(am.getBalance("손오공"));
		am.withdraw("손오공", 2000);
		am.withdraw("손오공", 1000);
		System.out.println(am.getBalance("손오공"));
		am.deposit("저팔계", 3000);
		System.out.println(am.getBalance("저팔계"));
		am.withdraw("저팔계", 2000);
		am.withdraw("저팔계", 1000);
		System.out.println(am.getBalance("저팔계"));
		am.deposit("사오정", 1000);
		System.out.println(am.getBalance("사오정"));
		am.withdraw("사오정", 2000);
		am.withdraw("사오정", 1000);
		System.out.println(am.getBalance("사오정"));

	}

}
