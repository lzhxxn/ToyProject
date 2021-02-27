import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

 

public class AudioStarter extends JFrame implements ActionListener {
	ImagePanel imgP=new ImagePanel();
	
	//������
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
			Play("music/morlau.wav");   //������� �޼��� ȣ��. �Ķ���ͷ� ������ ��ġ�� �̸��� ����� �Ѵ�.
		}
	}
}