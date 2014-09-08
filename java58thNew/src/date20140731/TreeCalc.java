package date20140731;

import java.math.*;
public class TreeCalc {

	public static void main(String[] args) {
		//				# a는 높이,
		double atreew = 150;
		double atreeh;
		//				# atreeh = atreew * 0.5317
		System.out.print("math.tan((28/180.0)*math.pi)의 값 ");
		System.out.println(Math.tan((28/180.0)*Math.PI));
		atreeh = atreew * Math.tan((28/180.0)*Math.PI);
		System.out.print("A나무의 높이");
		System.out.println(atreeh+1.8);

		double btreew = 100;
		double btreeh;
		//				# btreeh = btreew * 0.6249
		System.out.print("math.tan((32/180.0)*math.pi)의 값");
		System.out.println(Math.tan((32/180.0)*Math.PI));
		btreeh = btreew * Math.tan((32/180.0)*Math.PI);
		System.out.println("B나무의 높이");
		System.out.println(btreeh+1.8);
		if (atreeh > btreeh){
			System.out.println("A나무의 높이가 더 큽니다.");
		}
		else if (atreeh == btreeh){
			System.out.println("A나무와 B나무의 높이가 같습니다.");
		}
		else if (atreeh < btreeh){
			System.out.println("B나무의 높이가 더 큽니다.");
		}
	}

}

