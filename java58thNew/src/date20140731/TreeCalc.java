package date20140731;

import java.math.*;
public class TreeCalc {

	public static void main(String[] args) {
		//				# a�� ����,
		double atreew = 150;
		double atreeh;
		//				# atreeh = atreew * 0.5317
		System.out.print("math.tan((28/180.0)*math.pi)�� �� ");
		System.out.println(Math.tan((28/180.0)*Math.PI));
		atreeh = atreew * Math.tan((28/180.0)*Math.PI);
		System.out.print("A������ ����");
		System.out.println(atreeh+1.8);

		double btreew = 100;
		double btreeh;
		//				# btreeh = btreew * 0.6249
		System.out.print("math.tan((32/180.0)*math.pi)�� ��");
		System.out.println(Math.tan((32/180.0)*Math.PI));
		btreeh = btreew * Math.tan((32/180.0)*Math.PI);
		System.out.println("B������ ����");
		System.out.println(btreeh+1.8);
		if (atreeh > btreeh){
			System.out.println("A������ ���̰� �� Ů�ϴ�.");
		}
		else if (atreeh == btreeh){
			System.out.println("A������ B������ ���̰� �����ϴ�.");
		}
		else if (atreeh < btreeh){
			System.out.println("B������ ���̰� �� Ů�ϴ�.");
		}
	}

}

