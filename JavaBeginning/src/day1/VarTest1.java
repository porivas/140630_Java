package day1;

public class VarTest1 {
	public static void main(String[] args){
		
		int v1 = 10; 
		// v1이라는 정수형 변수를 선언하고 10으로 초기화. 
		// 초기화란, 초기값을 설정하는 행위. 
		
//		int v2 = -5;
//		int v3 = v1/v2;
		
		System.out.println(v1);
		
		v1 = 20;
		// 이미 선언한 변수는 다시 int v1 처럼 선언을 하면 에러가 난다. 
		// 메인메소드 안에 같은 이름의 변수를 쓰면 안된다. 
		System.out.println(v1);

		int v2 = 20;
		int v3 = v1 + v2;
		System.out.println(v2+","+v3);
		int 테스트 = 15;				// 한글 변수 테스트
		System.out.println(테스트);		// 한글 변수 출력 테스트
		String 테스트2 = "초기화 성공";
		System.out.println(테스트2);
/* 

1. 자바에서는 변수의 대소문자를 구분한다.
- test 와 TEST는 다른 변수로 간주 합니다.
2. 예약어를 사용하면 안된다.
- int, long등 예약된 변수는 사용하면 안됩니다.
3. 영어 대소문자, 숫자, _(언더바), $(달러) 만 사용가능하다.
- #kk과 같은 형태는 허용되지 않습니다.
4. 시작은 숫자로 하면 안된다.
- _test는 허용되나 5test는 허용되지 않습니다.

아래는 지키지 않아도 에러는 나지 않지만 전세계적으로 지켜주면 좋은 아름다운 약속들 입니다.
1. 클래스의 이름은 대문자로 시작한다.
- 대부분의 경우 Test는 클래스로 이해하며 test는 변수로 이해합니다.
2. 메소드, 변수의 이름은 소문자로 시작한다.(약간의 예외적인 사항들이 있습니다.)
- testMethod(), test01 등 메소드와 변수는 소문자로 시작하는 것이 좋습니다.
3. 여러 단어들이 합쳐질경우 단어의 첫글자를 대문자로 하거나 _(언더바)로 이어준다.
- studentScore, my_Information과 같이 이어주시면 됩니다.
4. 상수는 싸그리 대문자로 쓴다. (상수란, 변하지 않는 값) 
- MAX_SCORE, MIN_NUMBER 과 같이 사용합니다. */

	}

}
