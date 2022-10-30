package polymorphism;

import org.springframework.stereotype.Component;


public class SonySepaker implements Speaker{


	@Override
	public void volumeUp() {
		System.out.println("SonySpeaker....소리 올린다.");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("SonySpeaker....소리 내린다.");
	}

}
