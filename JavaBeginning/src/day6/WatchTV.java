package day6;

class TV{

	private boolean power = false;
	private int channel = 9;
	private int volume = 20;


	public void powerOn(){
		if (power == false)
		{
			this.power = true;
			System.out.println("TV가 켜졌습니다.");
		}
		else
		{
			this.power = false;
			System.out.println("TV가 꺼졌습니다.");
			System.out.println("계속하려면 아무키나 누르십시오...");  // 기능 어떻게 구현하는지
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
		// 처음 TV의 채널은 9번, 볼륨은 20, 전원은 꺼져있다. 
		TV tv = new TV();
		tv.powerOn();
		System.out.printf("현재 TV채널은 %d입니다. \n", tv.getChannel());
		System.out.printf("현재 TV볼륨은 %d입니다. \n", tv.getVolume());
		tv.setChannel(16);
		tv.channelUp();
		tv.volumeUp();
		tv.volumeUp();
		System.out.printf("현재 TV채널은 %d입니다. \n", tv.getChannel());
		System.out.printf("현재 TV볼륨은 %d입니다. \n", tv.getVolume());
		tv.powerOn();
	}

}
