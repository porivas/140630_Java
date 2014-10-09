package org.zerock;
import java.util.function.Consumer;


public class ConsumeWithLambda {

	public void sandwich(String name, Consumer<String> consumer){
		
		System.out.println("»÷µåÀ§Ä¡ ¶Ñ²±");
		consumer.accept(name);
		System.out.println("»÷µåÀ§Ä¡ ¹Ù´Ú");
		
	}
	
	public static void main(String[] args) {
		
		ConsumeWithLambda obj = new ConsumeWithLambda();
		
		obj.sandwich("ÇÜ", (x) -> System.out.println("¾ç ¸¹ÀÌ ³Ö¾îÁÖ¼¼¿ä"));
		
		
	}
	
}
