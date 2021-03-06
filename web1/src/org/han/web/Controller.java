package org.han.web;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//타겟은 이 어노테이션을 어디에 붙일 것인지 정해준다. TYPE은 클래스  
@Target(ElementType.TYPE)
// 언제 쓸 것인가. 이게 리텐션. 런타임에 리플렉션으로 사용할 것인가. 컴파일 단계에서 쓸 것인가 등등. 우리들 레벨에서는 런타임에서만 쓰면 되니까 걱정하지 말 것. 
@Retention(RetentionPolicy.RUNTIME)
//클래스, 변수, 메소드, 필드에 다 걸 수 있다. 
public @interface Controller{
	String path();
}
