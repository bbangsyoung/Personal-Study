package polymorphism;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements Tv {
	

	@Autowired
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("---------엘지티비 객체생성");
	}

	@Override
	public void powerOn() {
		System.out.println("엘지티비 전원켠다");
		
	}

	@Override
	public void powerOff() {
		System.out.println("엘지티비 전원끗...엄마안잔다");
		
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
