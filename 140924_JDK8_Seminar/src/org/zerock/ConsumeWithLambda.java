package org.zerock;
import java.util.function.Consumer;


public class ConsumeWithLambda {

	public void sandwich(String name, Consumer<String> consumer){
		
		System.out.println("������ġ �Ѳ�");
		consumer.accept(name);
		System.out.println("������ġ �ٴ�");
		
	}
	
	public static void main(String[] args) {
		
		ConsumeWithLambda obj = new ConsumeWithLambda();
		
		obj.sandwich("��", (x) -> System.out.println("�� ���� �־��ּ���"));
		
		
	}
	
}
