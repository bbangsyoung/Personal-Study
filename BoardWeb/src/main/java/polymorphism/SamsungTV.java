package polymorphism;

/**
 * @author 502-t
 *
 */
public class SamsungTV implements TV{
	
	
	private Speaker speaker;
	private int price;

	public SamsungTV() {
		System.out.println("SamsunTV(1) 객체 생성....");
	}

	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() 호출");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("===> setPrice() 호출");
		this.price = price;
	}





	@Override
	public void powerOn() {
		System.out.println("SamsungTv....전원 켠다. (가격 : " + price + ")");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTv....전원 끈다");
		
	}

	@Override
	public void volumeUp() {
		//speaker = new SonySepaker();
		speaker.volumeUp();
		
	}

	@Override
	public void volumeDown() {
		//speaker = new SonySepaker();
		speaker.volumeDown();
	}
}
