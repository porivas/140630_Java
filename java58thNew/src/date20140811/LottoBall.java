package date20140811;

import java.util.Arrays;

public class LottoBall implements Comparable<LottoBall> {
	private int num;
	private String name;

	public LottoBall(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}
	
	
	@Override
	public int compareTo(LottoBall other) {
		// TODO Auto-generated method stub
		System.out.println(this.name+ " : "+ other.name);
		System.out.println(this.num+" : "+other.num);
//		return this.num - other.num; 숫자비교
		return this.name.compareTo(other.name);
	}



	@Override
	public String toString() {
		return "LottoBall [num=" + num + ", name=" + name + "]";
	}


	public static void main(String[] args) {
		LottoBall[] balls = {
				new LottoBall(3, "aaa"),
				new LottoBall(43,  "zdc"),
				new LottoBall(33,  "d0d"),
				new LottoBall(23, "ccd"),
				new LottoBall(13,  "isp"),

		};
		Arrays.sort(balls);
		System.out.println(Arrays.toString(balls));
	}
}
