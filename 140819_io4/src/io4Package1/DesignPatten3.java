package io4Package1;

public abstract class DesignPatten3 {
	public final void doAll(){
		this.doA();
		this.doB();			// 추상클래스이기 때문에 객체를 만들지 않았어도 추상 메소드를 호출 가능하다. 
		this.doC();
	}
	private void doA(){
		System.out.println("라면 재료 준비");
	}
	
	public abstract void doB(); //오버라이드하는 라면 조리법. 너구리, 짜파게티, 비빔면은 조리법이 다름. 
	
	private void doC(){
		System.out.println("완성하여 접시에 담습니다.");
	}

}
