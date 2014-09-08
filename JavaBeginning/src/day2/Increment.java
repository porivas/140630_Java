package day2;

public class Increment {
	public static void main(String[] args)
	{
		int i = 10;
		char c = 'A';
		
		System.out.println("i="+i+"\t++i="+ ++i + "\ti++="+ i++ + "\t i="+ i);
		System.out.println("c="+c+"\t++c="+ ++c + "\tc++="+ c++ + "\t c="+ c);
		
		i = 3;
		
		System.out.println("i=3: i++ + i++ + --i =?" + (i++ + i ++ + --i));
		
	}

}
