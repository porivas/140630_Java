package day8;

class Account{
	public String name;
	public long balance;

	public Account(){

	}
	public Account(String name){
		this.name = name;
		System.out.println(name+"���� ���°� ����������ϴ�.");
	}
	public void deposit(long amount){
		this.balance = this.balance + amount;
		System.out.println(name+"���� ���¿� "+ amount+"���� �ԱݵǾ� "+balance+"���� �Ǿ����ϴ�.");
	}
	public void withdraw(long amount){
		if(amount <= balance){
			this.balance = this.balance - amount;
			System.out.println(name+"���� ���¿� "+ amount+"���� ��ݵǾ� "+balance+"���� �Ǿ����ϴ�.");
		}
		else
			System.out.println("�ܰ� �����մϴ�.");
	}
	public long getBalance(){
		return balance;
	}
}

class AccountManager{
	private int accountNum;
	private Account[] arr;
	// Account Ÿ��(Ŭ����)�� arr �迭�� ����. 

	public AccountManager(){
		arr = new Account[10];
		// ���� 10�� arr �迭�� ����.
	}
	public void newAccount(String name){
		if (accountNum <10)
			arr[accountNum++]=new Account(name);
		else
			System.out.println("���°� 10���� �ʰ��߽��ϴ�.");
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
				str = name+"���� �ܰ��"+arr[i].getBalance()+"�� �Դϴ�.";
				break;
			}
		}
		return str;
	}
}

public class NewBanking {
	public static void main(String[] args){
		AccountManager am = new AccountManager();
		am.newAccount("�տ���");
		am.newAccount("���Ȱ�");
		am.newAccount("�����");
		am.deposit("�տ���", 1000);
		System.out.println(am.getBalance("�տ���"));
		am.withdraw("�տ���", 2000);
		am.withdraw("�տ���", 1000);
		System.out.println(am.getBalance("�տ���"));
		am.deposit("���Ȱ�", 3000);
		System.out.println(am.getBalance("���Ȱ�"));
		am.withdraw("���Ȱ�", 2000);
		am.withdraw("���Ȱ�", 1000);
		System.out.println(am.getBalance("���Ȱ�"));
		am.deposit("�����", 1000);
		System.out.println(am.getBalance("�����"));
		am.withdraw("�����", 2000);
		am.withdraw("�����", 1000);
		System.out.println(am.getBalance("�����"));

	}

}
