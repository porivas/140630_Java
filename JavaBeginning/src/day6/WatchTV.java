package day6;

class TV{

	private boolean power = false;
	private int channel = 9;
	private int volume = 20;


	public void powerOn(){
		if (power == false)
		{
			this.power = true;
			System.out.println("TV�� �������ϴ�.");
		}
		else
		{
			this.power = false;
			System.out.println("TV�� �������ϴ�.");
			System.out.println("����Ϸ��� �ƹ�Ű�� �����ʽÿ�...");  // ��� ��� �����ϴ���
		}
	}
	public void channelUp(){
		this.channel = this.channel+1;
//		System.out.println(this.getChannel());
	}
	public void channelDown(){
		this.channel = this.channel-1;
//		System.out.println(this.getChannel());
	}
	public void setChannel( int sc1 )
	{
		this.channel = sc1;
	}
	public void volumeUp(){
		this.volume = this.volume +1;
	}
	public void volumeDown(){
		this.volume = this.volume -1;
	}

	public int getChannel(){
		return this.channel;
	}
	public int getVolume(){
		return this.volume;
	}
}



public class WatchTV {
	public static void main(String[] args){
		// ó�� TV�� ä���� 9��, ������ 20, ������ �����ִ�. 
		TV tv = new TV();
		tv.powerOn();
		System.out.printf("���� TVä���� %d�Դϴ�. \n", tv.getChannel());
		System.out.printf("���� TV������ %d�Դϴ�. \n", tv.getVolume());
		tv.setChannel(16);
		tv.channelUp();
		tv.volumeUp();
		tv.volumeUp();
		System.out.printf("���� TVä���� %d�Դϴ�. \n", tv.getChannel());
		System.out.printf("���� TV������ %d�Դϴ�. \n", tv.getVolume());
		tv.powerOn();
	}

}
