package polymorphism;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker{
	

	@Override
	public void volumeUp() {
		System.out.println(" AppleSpeak -- 소리 울린다!!!!!!!!!");
	}
	
	@Override
	public void volumeDown() {
		System.out.println(" AppleSpeak -- 소리 내린다/////");
	}
	
	
}
