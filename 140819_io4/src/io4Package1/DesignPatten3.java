package io4Package1;

public abstract class DesignPatten3 {
	public final void doAll(){
		this.doA();
		this.doB();			// �߻�Ŭ�����̱� ������ ��ü�� ������ �ʾҾ �߻� �޼ҵ带 ȣ�� �����ϴ�. 
		this.doC();
	}
	private void doA(){
		System.out.println("��� ��� �غ�");
	}
	
	public abstract void doB(); //�������̵��ϴ� ��� ������. �ʱ���, ¥�İ�Ƽ, ������� �������� �ٸ�. 
	
	private void doC(){
		System.out.println("�ϼ��Ͽ� ���ÿ� ����ϴ�.");
	}

}
