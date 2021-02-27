import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

import javax.sound.sampled.*;

public class ImagePanel extends JPanel implements ActionListener{
	Image image;
	JButton b1, b2, b3, b4, b5, quiz; 
	JPanel p;
	ImageIcon i1, i2, i3, i4, i5;
	//JLabel laImg;
	Clip clip;
    Test test;

	public ImagePanel(Test test){
		this.test = test; 
		makeMusic();
		makeSource();
	}
	void makeSource(){
		//�̹���
		//image = new ImageIcon("imgs/screen.png").getImage(); // Wallpaper
		image = new ImageIcon("imgs/screen2.png").getImage(); // Wallpaper
		i1 = new ImageIcon(getClass().getResource("imgs/testsend.gif"));
		i2 = new ImageIcon(getClass().getResource("imgs/audio.gif"));
		//i3 = new ImageIcon(getClass().getResource("imgs/passed.png"));
		i4 = new ImageIcon(getClass().getResource("imgs/score-board.png"));
		//i5 = new ImageIcon(getClass().getResource("imgs/ok.png"));

		
		i3 = new ImageIcon(getClass().getResource("imgs/passed1.png"));
		i5 = new ImageIcon(getClass().getResource("imgs/ok1.png"));
		
		
		//��ư
		b1 = new JButton(i4);//���ھ��
		b2 = new JButton(i2);//���� ���
		b3 = new JButton(i1);//�𷡽ð�                                                                                                                                                                       
		b4 = new JButton(i5);//OK
		b5 = new JButton(i3);//Pass
		quiz = new JButton("Quiz");
		
		//quiz font ����
		quiz.setFont(new Font("���� ���", Font.BOLD, 30));
        quiz.setForeground(Color.WHITE);
		quiz.setHorizontalAlignment(JButton.CENTER);
		
		quiz.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);

		//JButton �ܰ��� ����
		b1.setBorderPainted(false);b2.setBorderPainted(false);b3.setBorderPainted(false); 
		b4.setBorderPainted(false);b5.setBorderPainted(false);quiz.setBorderPainted(false);
		
		//Ŭ���� ����� �׵θ� ����
		b1.setFocusPainted(false);b2.setFocusPainted(false);b3.setFocusPainted(false); 
		b4.setFocusPainted(false);b5.setFocusPainted(false);quiz.setFocusPainted(false);
		
		//������ġ ��ġ
		setLayout(null); 
		add(b1);add(b2);add(b3);add(b4);add(b5);add(quiz);

		b1.setBackground(Color.white);
		b2.setBackground(Color.white);
		b3.setBackground(Color.white);
		b4.setBackground(Color.white);
		b5.setBackground(Color.white);
		quiz.setBackground(Color.white);
		//�����ϰ�
		b1.setOpaque(false);
		b2.setOpaque(false);
		b3.setOpaque(false);
		b4.setOpaque(false);
		b5.setOpaque(false);
		quiz.setOpaque(false);
    }
	//�̺�Ʈ
	public void actionPerformed(ActionEvent e){ //���� �̻��
		Object obj = e.getSource();
		if (obj == quiz){ // ����
		  quiz.setText("���ڿ��� �� ���� �׽�Ʈ ����");
		}else if(obj == b1){ //���ھ�� ������ â �߰�~ (���߿� ������ ���ھ� ������ ���� ����)
		  int a = 1;
		  JOptionPane.showMessageDialog(null, "���ھ�� \n "+test.teamName+" : "+a+"\n 2team: "+a, "Score Board", 
				JOptionPane.QUESTION_MESSAGE,
				null);
		}else if(obj == b2){ // BGM �̺�Ʈ
			if(clip.isRunning()==false){//bgm�� ������ ���� ������ ����~
				clip.start();
			}else if (clip.isRunning()==true){//bgm�� ������ ������ ��ž~
				clip.stop();
			}	
				
		}

    }
    // �������̵�
	public void paint(Graphics g){
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);//�����ϰ�
		super.paint(g);
    }
	//BGM ����
	void makeMusic(){
		try{
			File morlau = new File("music/morlau.wav");
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(morlau));		
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error");
		}
	}
}