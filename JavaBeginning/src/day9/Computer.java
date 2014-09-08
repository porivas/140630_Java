package day9;

class Computer{
	private String owner;

	public Computer(String owner){
		this.owner = owner;
	}
	public void calculate(){
		System.out.println("요청 내용을 계산합니다.");
	}
}
