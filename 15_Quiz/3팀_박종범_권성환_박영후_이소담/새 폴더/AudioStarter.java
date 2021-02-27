import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

 

public class AudioStarter extends JFrame implements ActionListener {
	ImagePanel imgP=new ImagePanel();
	
	//생성자
	public AudioStarter() {


	}
	 
	public void Play(String fileName)
    {
        try
        {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
            Clip clip = AudioSystem.getClip();
            clip.stop();
            clip.open(ais);
            clip.start();
        }
        catch (Exception ex)
        {
        }
    }

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()==i2){  
			Play("music/morlau.wav");   //음악재생 메서드 호출. 파라미터로 파일의 위치와 이름을 써줘야 한다.
		}
	}
}