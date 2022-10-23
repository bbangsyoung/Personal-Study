package polymorphism;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{


	
	
	@Autowired
	private Speaker speaker;
	
	
	public LgTV() {
		System.out.println("LgTV 媛앹껜 �깮�꽦");
	}

	@Override
	public void powerOn() {
		System.out.println("LgTV...�쟾�썝 耳좊떎.");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV...�쟾�썝 �걟�떎.");

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
