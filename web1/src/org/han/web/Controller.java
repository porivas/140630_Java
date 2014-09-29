package org.han.web;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Ÿ���� �� ������̼��� ��� ���� ������ �����ش�. TYPE�� Ŭ����  
@Target(ElementType.TYPE)
// ���� �� ���ΰ�. �̰� ���ټ�. ��Ÿ�ӿ� ���÷������� ����� ���ΰ�. ������ �ܰ迡�� �� ���ΰ� ���. �츮�� ���������� ��Ÿ�ӿ����� ���� �Ǵϱ� �������� �� ��. 
@Retention(RetentionPolicy.RUNTIME)
//Ŭ����, ����, �޼ҵ�, �ʵ忡 �� �� �� �ִ�. 
public @interface Controller{
	String path();
}