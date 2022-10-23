package polymorphism;

import org.springframework.stereotype.Component;


public class AppleSpeaker implements Speaker{

	@Override
	public void volumeUp() {
		System.out.println("AppleSpeaker....소리 올린다.");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("AppleSpeaker....소리 내린다.");
	}

}
