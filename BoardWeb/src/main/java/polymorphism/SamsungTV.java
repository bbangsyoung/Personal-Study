package polymorphism;

public class SamsungTV implements Tv {
	private Speaker speaker;
	private int price;
	

	public SamsungTV() {
		System.out.println("삼성티비 객체생성!!!!!!!!!");
	}
		
		
	public void setSpeaker(Speaker speaker) {
		System.out.println("setSpeaker() 호출");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("setPrice() 호출");
		this.price = price;
	}


	@Override
	public void powerOn() {
		System.out.println("(가격 : "+ price + ")");
		
		
	}

	@Override
	public void powerOff() {
		System.out.println("삼성티비 전원끈다");
		
	}

	@Override
	public void volumeUp() {
		
		speaker.volumeUp();
		
	}

	@Override
	public void volumeDown() {

		speaker.volumeDown();
		
	}

	

}
