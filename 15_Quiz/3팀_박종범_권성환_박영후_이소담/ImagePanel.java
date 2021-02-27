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
		//이미지
		//image = new ImageIcon("imgs/screen.png").getImage(); // Wallpaper
		image = new ImageIcon("imgs/screen2.png").getImage(); // Wallpaper
		i1 = new ImageIcon(getClass().getResource("imgs/testsend.gif"));
		i2 = new ImageIcon(getClass().getResource("imgs/audio.gif"));
		//i3 = new ImageIcon(getClass().getResource("imgs/passed.png"));
		i4 = new ImageIcon(getClass().getResource("imgs/score-board.png"));
		//i5 = new ImageIcon(getClass().getResource("imgs/ok.png"));

		
		i3 = new ImageIcon(getClass().getResource("imgs/passed1.png"));
		i5 = new ImageIcon(getClass().getResource("imgs/ok1.png"));
		
		
		//버튼
		b1 = new JButton(i4);//스코어보드
		b2 = new JButton(i2);//음악 재생
		b3 = new JButton(i1);//모래시계                                                                                                                                                                       
		b4 = new JButton(i5);//OK
		b5 = new JButton(i3);//Pass
		quiz = new JButton("Quiz");
		
		//quiz font 설정
		quiz.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        quiz.setForeground(Color.WHITE);
		quiz.setHorizontalAlignment(JButton.CENTER);
		
		quiz.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);

		//JButton 외곽선 제거
		b1.setBorderPainted(false);b2.setBorderPainted(false);b3.setBorderPainted(false); 
		b4.setBorderPainted(false);b5.setBorderPainted(false);quiz.setBorderPainted(false);
		
		//클릭시 생기는 테두리 제거
		b1.setFocusPainted(false);b2.setFocusPainted(false);b3.setFocusPainted(false); 
		b4.setFocusPainted(false);b5.setFocusPainted(false);quiz.setFocusPainted(false);
		
		//절대위치 배치
		setLayout(null); 
		add(b1);add(b2);add(b3);add(b4);add(b5);add(quiz);

		b1.setBackground(Color.white);
		b2.setBackground(Color.white);
		b3.setBackground(Color.white);
		b4.setBackground(Color.white);
		b5.setBackground(Color.white);
		quiz.setBackground(Color.white);
		//투명하게
		b1.setOpaque(false);
		b2.setOpaque(false);
		b3.setOpaque(false);
		b4.setOpaque(false);
		b5.setOpaque(false);
		quiz.setOpaque(false);
    }
	//이벤트
	public void actionPerformed(ActionEvent e){ //아직 미사용
		Object obj = e.getSource();
		if (obj == quiz){ // 퀴즈
		  quiz.setText("문자열이 긴 문장 테스트 내용");
		}else if(obj == b1){ //스코어보드 누르면 창 뜨게~ (나중에 퀴즈의 스코어 변수를 넣을 예정)
		  int a = 1;
		  JOptionPane.showMessageDialog(null, "스코어보드 \n "+test.teamName+" : "+a+"\n 2team: "+a, "Score Board", 
				JOptionPane.QUESTION_MESSAGE,
				null);
		}else if(obj == b2){ // BGM 이벤트
			if(clip.isRunning()==false){//bgm이 나오고 있지 않을때 시작~
				clip.start();
			}else if (clip.isRunning()==true){//bgm이 나오고 있을때 스탑~
				clip.stop();
			}	
				
		}

    }
    // 오버라이딩
	public void paint(Graphics g){
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);//투명하게
		super.paint(g);
    }
	//BGM 생성
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