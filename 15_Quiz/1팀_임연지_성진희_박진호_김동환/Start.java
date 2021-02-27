import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;


class Start extends JFrame implements ActionListener, Runnable {

	String User; // >> 요거 더해보기 !
	JButton Username;
	Thread music;
	//
	Container cp;
	JPanel Scene1;
	JLabel gif;
	ImageIcon Istart, Igif;
	JButton start;
	JPanel startP;
	////////////////////////
	CardLayout cardl;
	JPanel Scene2;
	JLabel nTitle,nInfo,nBack; //함께할캐릭터, 이름입력설명
	JTextPane nText; //이름을 입력할 텍스트팬
	JButton nChoose, nNext, nPrev, c1;// 전환버튼, 확인버튼
	ImageIcon Iback, Ichoose, Iinfo, Ileft, Iright, Iok, lion; //캐릭터 화면 입힐 이미지 아이콘
	////////////////////////
	JPanel Scene3;
	JButton a1, a2, a3, a4, a5;
	ImageIcon a1i, a2i, a3i, a4i, a5i, Ibg5;
	JLabel bg5, usern1;
	////////////////////////
	JPanel p, Scene4;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	ImageIcon O,X,finish,time,Score,reStart,hint,quiz,Ibg4,question;
	JLabel bg4; //엘이야

	Start() throws IOException {
		music = new Thread();
		music.start();
		cp = getContentPane();
		start = new JButton(Istart);
		gif = new JLabel();
		startP = new JPanel();
		Scene1 = new JPanel();
		Username = new JButton(User);
		Username.setSize(100,100);
		Username.setLocation(50,50);
		S1_init();
	}
	void playSound() {
        try {
            File soundFile = new File("Island Coconuts - Aaron Kenny.mp3");
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(soundFile));
            clip.start();
        }
        catch (Exception e) {
            System.out.println("문제있음");
        }
    }
	public void run(){
		 playSound();
	}

	void S1_init(){
		S1_loadImg();
		cp = getContentPane();
		cp.add(Scene1);
		Scene1.setLayout(null);
		Scene1.add(startP);
		startP.add(start);
		Scene1.add(gif);
		start.addActionListener(this);
		S1_setUI();
	}
	void S1_loadImg()  { 
		Istart = new ImageIcon("img/스타트.png");
		Igif = new ImageIcon(getClass().getResource("main.gif"));
		gif.setIcon(Igif);
		start.setIcon(Istart);
	}
	void S1_setUI(){
		setTitle("<BIT> A WildLife Adventure : Start");
		setSize(540,960);
		Scene1.setSize(540,960);
		Scene1.setLocation(0,0);
		startP.setBackground(new Color(255,0,0,0));
		startP.setSize(350,930);
		startP.setLocation(95,700);
		gif.setSize(540,960);
		gif.setLocation(0,0); 
		start.setBorderPainted(false);
		start.setContentAreaFilled(false);
		start.setFocusPainted(false);
		start.setSize(350,930);
		start.setLocation(110,650);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void S2_init(){
		cp.add(Scene2);
		Scene2.setLayout(null);
		S2_loadImg();
		S2_setUI();
	}
	void S2_loadImg(){
		Istart = new ImageIcon("img/버튼/스타트.png");
		Iback = new ImageIcon("img/bg3-b.png");
		Ichoose = new ImageIcon("img/cyc.png");
		Iinfo = new ImageIcon("img/eyn.png");
		Ileft = new ImageIcon("img/left.png");
		Iright = new ImageIcon("img/right.png");
		Iok = new ImageIcon("img/ok.png");
		lion = new ImageIcon("img/lion.jpg");
	}
	void S2_setUI(){
		Scene2.setSize(540,960);
		Scene2.setLocation(0,0);
		nBack.setSize(540,960); // 배경
		nBack.setLocation(0,0);
		nTitle.setSize(400,57); // 타이틀
		nTitle.setLocation(70,50);
		nInfo.setSize(300,51); // 이름입력
		nInfo.setLocation(120,640);
		nPrev.setContentAreaFilled(false); // 이전버튼
		nPrev.setSize(70,70);
		nPrev.setLocation(30,320);
		nNext.setContentAreaFilled(false); // 다음버튼
		nNext.setSize(70,70);
		nNext.setLocation(430,320);
		nText.setSize(250,50); // 이름입력
		nText.setLocation(135, 700);
		nChoose.setContentAreaFilled(false); // 확인
		nChoose.setSize(200,53);
		nChoose.setLocation(160,780);
		c1.setBorderPainted(false);
		c1.setContentAreaFilled(true);
		c1.setSize(300,500); // 라이언 이미지???
		c1.setLocation(115,110);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Scene2.add(nTitle);
		Scene2.add(nInfo);
		Scene2.add(nPrev);
		Scene2.add(nNext);
		Scene2.add(nText);
		Scene2.add(nChoose);
		Scene2.add(nBack);
		Scene2.add(c1);
	}

	void J1_init(){
		cp.add(Scene3);
		Scene3.setLayout(null);
		J1_loadImage();
		J1_setUI();
	}
	void J1_loadImage() {
		a1i = new ImageIcon("img/나무판.png");
		a2i = new ImageIcon("img/나무판.png");
		a3i = new ImageIcon("img/나무판.png");
		a4i = new ImageIcon("img/나무판.png");
		a5i = new ImageIcon("img/ok.png");
		Ibg5 = new ImageIcon("img/bg5.png");
		bg5.setIcon(Ibg5);
	}
	public void J1_setUI() {
		setTitle("비트 : 어 와일드라이프 어드벤쳐");
		setSize(540, 960);
		setVisible(true);
		bg5.setSize(540,960);
		bg5.setLocation(0,0);
		a1 = new JButton(a1i);
		a2 = new JButton(a2i);
		a3 = new JButton(a3i);
		a4 = new JButton(a4i);
		a5 = new JButton(a5i);  //제출버튼
		a1.addActionListener(this);
		a2.addActionListener(this);
		a3.addActionListener(this);
		a4.addActionListener(this);
		a5.addActionListener(this);
		Scene3.add(a1);
		Scene3.add(a2);
		Scene3.add(a3);
		Scene3.add(a4);
		Scene3.add(a5);
		Scene3.add(bg5);
		a1.setBounds(80, 680, 150, 50); 
		a2.setBounds(280, 680, 150, 50);
		a3.setBounds(80, 750, 150, 50);
		a4.setBounds(280, 750, 150, 50);
		a5.setBounds(130, 830, 260, 50);
		a1.setBorderPainted(false);
		a1.setContentAreaFilled(false);
		a1.setFocusPainted(false);
		a1.setOpaque(false);
		a2.setBorderPainted(false);
		a2.setContentAreaFilled(false);
		a2.setFocusPainted(false);
		a2.setOpaque(false);
		a3.setBorderPainted(false);
		a3.setContentAreaFilled(false);
		a3.setFocusPainted(false);
		a3.setOpaque(false);
		a4.setBorderPainted(false);
		a4.setContentAreaFilled(false);
		a4.setFocusPainted(false);
		a4.setOpaque(false);
		a5.setBorderPainted(false);
		a5.setContentAreaFilled(false);
		a5.setFocusPainted(false);
		a5.setOpaque(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		void H1_init(){
		H_loadImg();
		cp = getContentPane();
		cp.add(Scene4);
		Scene4.setLayout(null);
		Scene4.add(bg4);
		p = new JPanel();
		b1 = new JButton(O);
		b2 = new JButton(X);
		b3 = new JButton(question);
		b4 = new JButton(Score);
		b5 = new JButton(finish);
		b6 = new JButton(reStart);
		b7 = new JButton(hint);
		b8 = new JButton(quiz);
		b9 = new JButton(finish);
		//b1.setBorderPainted(false);
		b1.setContentAreaFilled(false);
		b1.setFocusPainted(false);
		b1.setOpaque(false);
		//b2.setBorderPainted(false);
		b2.setContentAreaFilled(false);
		b2.setFocusPainted(false);
		b2.setOpaque(false);
		//b3.setBorderPainted(false);
		b3.setContentAreaFilled(false);
		b3.setFocusPainted(false);
		b3.setOpaque(false);
		//b4.setBorderPainted(false);
		b4.setContentAreaFilled(false);
		b4.setFocusPainted(false);
		b4.setOpaque(false);
		//b5.setBorderPainted(false);
		b5.setContentAreaFilled(false);
		b5.setFocusPainted(false);
		b5.setOpaque(false);
		//b6.setBorderPainted(false);
		b6.setContentAreaFilled(false);
		b6.setFocusPainted(false);
		b6.setOpaque(false);
		//b7.setBorderPainted(false);
		b7.setContentAreaFilled(false);
		b7.setFocusPainted(false);
		b7.setOpaque(false);
		//b8.setBorderPainted(false);
		b8.setContentAreaFilled(false);
		b8.setFocusPainted(false);
		b8.setOpaque(false);
		//b9.setBorderPainted(false);
		b9.setContentAreaFilled(false);
		b9.setFocusPainted(false);
		b9.setOpaque(false);
		
		Scene4.add(b1);
		Scene4.add(b2);
		Scene4.add(b3);
		Scene4.add(b4);
		Scene4.add(b5);
		Scene4.add(b6);
		Scene4.add(b7);
		Scene4.add(b8);
		Scene4.add(bg4);
		Scene4.add(b9);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);

		b1.setBounds(80, 550, 150, 100);//O
		b2.setBounds(280, 550, 150, 100);//X
		b3.setBounds(100,210,300,50);//게임화면
		b4.setBounds(80, 750, 150, 50);//점수보기
		b5.setBounds(280, 750, 150, 50);//힌트받기
		b6.setBounds(110, 830, 300, 50);//다시하기
		b7.setBounds(10,0,120,50);//힌트
		b8.setBounds(100,210,150,50);//퀴즈창 틀어넣기
		b9.setBounds(100,210,100,50);
		
		H_setUI();
	}
	void H_loadImg(){
		try {
			Ibg4 = new ImageIcon(ImageIO.read(new File("imgs/bg4.png")));
			O = new ImageIcon(ImageIO.read(new File("imgs/O.png")));
			X = new ImageIcon(ImageIO.read(new File("imgs/X.png")));
			finish = new ImageIcon(ImageIO.read(new File("imgs/finish.png")));
			time = new ImageIcon(ImageIO.read(new File("imgs/question.png")));
			Score = new ImageIcon(ImageIO.read(new File("imgs/score.png")));
			reStart = new ImageIcon(ImageIO.read(new File("imgs/reStart.png")));
			hint = new ImageIcon(ImageIO.read(new File("imgs/hint.png")));
			question = new ImageIcon(ImageIO.read(new File("imgs/question.png")));
			bg4.setIcon(Ibg4);
		}catch(IOException ie){
		}catch(NullPointerException ne){
		}
	}
	void H_setUI(){
		setTitle("<BIT> A WildLife Adventure : Start");
		setSize(540,960);
		setVisible(true);
		setLocation(0,0);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		bg4.setSize(540,960);
		bg4.setLocation(0,0);
	}
	void pln(String str){
		System.out.println(str);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == start){
			getContentPane().removeAll();
			revalidate();
			repaint();
			S2_loadImg();
			nTitle = new JLabel(Ichoose);
			nInfo = new JLabel(Iinfo);
			nBack = new JLabel(Iback);
			c1 = new JButton(lion);
			nText = new JTextPane();
			nChoose = new JButton(Iok);
			nNext = new JButton(Iright);
			nPrev = new JButton(Ileft);
			Scene2 = new JPanel();
			nNext.addActionListener(this);
			nPrev.addActionListener(this);
			nChoose.addActionListener(this);
			S2_init();
		}else if(obj == nChoose){
			User = nText.getText();
			getContentPane().removeAll();
			revalidate();
			repaint();
			Scene3 = new JPanel();
			bg5 = new JLabel();
			J1_init();
		}else if(obj == a5){
			System.out.println(User);
			getContentPane().removeAll();
			revalidate();
			repaint();
			bg4 = new JLabel();
			Scene4 = new JPanel();
			H1_init();
			int answer = JOptionPane.showConfirmDialog(null, "제출 하시겠어요?", "질문", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(answer == JOptionPane.YES_OPTION){
				 JOptionPane.showMessageDialog(null, "제출 완료");
			}else{
				 JOptionPane.showMessageDialog(null, "답을 다시 선택해주세요");
			}
		}
	}
	public static void main(String[] args){
		try{
			Start st = new Start();
		}catch(IOException ie){
		}
	}
}