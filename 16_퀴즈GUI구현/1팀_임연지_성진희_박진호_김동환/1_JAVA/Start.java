import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.Toolkit;
import java.util.*;

class Start extends JFrame implements ActionListener {
	Clip clip;
	String User; // >> 요거 더해보기 !
	JButton Username;
	int chaNum;
	Thread music;
	///////////////////////
	Container cp;
	JPanel Scene1;
	JLabel gif;
	ImageIcon Istart, Igif;
	JButton start;
	JPanel startP;
	////////////////////////
	JPanel Scene2;
	JLabel nTitle,nInfo,nBack; //함께할캐릭터, 이름입력설명
	JTextPane nText; //이름을 입력할 텍스트팬
	JButton nChoose, nNext, nPrev;// 전환버튼, 확인버튼
	JButton char1,char2,char3,char4;
	ImageIcon Iback, Ichoose, Iinfo, Ileft, Iright, Iok, lion, muzi, neo, gentle; //캐릭터 화면 입힐 이미지 아이콘
	////////////////////////
	JPanel Scene3;
	JButton a1, a2, a3, a4, a5, a6, a7, a8;
	ImageIcon a1i, a2i, a3i, a4i, a5i, a6i, a7i, a8i, Ibg5;
	JLabel bg5, usern1;
	JTextArea pta;
	////////////////////////
	JPanel p, Scene4;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,ox,b10;
	ImageIcon O,X,finish,time,Score,reStart,hint,quiz,Ibg4,question;
	JLabel bg4; //엘이야
	JPanel oxP;
	JTextPane nnText;
	JTextArea jtx;
	///////////////////////////
	JPanel Scene5;
	JButton bInput, bQuestion, bNext, bPrev,bClose, qz;
	ImageIcon Ibg1,Iqzpane, Inext,Iprev,Iexit, Iquestion, qzi;
	JLabel laBg4, laInputAnswer, laScore;
	JTextField tf;
	JTextArea ta,taQuestion;
    Font font20,font30,font40;
	static int intScore;

	JButton bgScene5;

	Start() throws IOException {
		makeMusic();
		music = new Thread();
		music.start();
		cp = getContentPane();
		start = new JButton(Istart);
		gif = new JLabel();
		startP = new JPanel();
		Scene1 = new JPanel();
		Username = new JButton(User);
		S1_init();
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
		setSize(540,960);
		setTitle("<BIT> A WildLife Adventure : Start");
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
		char1.setContentAreaFilled(false);
		char1.setFocusPainted(false);
		char1.setOpaque(false);
		char1.setSize(100,100);
		char1.setLocation(200,200);
		char2.setContentAreaFilled(false);
		char2.setFocusPainted(false);
		char2.setOpaque(false);
		char3.setContentAreaFilled(false); 
		char3.setFocusPainted(false);
		char3.setOpaque(false);
		char4.setContentAreaFilled(false); 
		char4.setFocusPainted(false);
		char4.setOpaque(false);
		nNext.addActionListener(this);
		nPrev.addActionListener(this);
		nChoose.addActionListener(this);
		Scene2.add(char1);
		Scene2.add(char2);
		Scene2.add(char3);
		Scene2.add(char4);
		Scene2.add(Username);
		Username.setSize(100,100);
		Username.setLocation(50,50);
	}
	void S2_loadImg(){
		Istart = new ImageIcon("img/버튼/스타트.png");
		Iback = new ImageIcon("img/bg3-b.png");
		Ichoose = new ImageIcon("img/cyc.png");
		Iinfo = new ImageIcon("img/eyn.png");
		Ileft = new ImageIcon("img/left.png");
		Iright = new ImageIcon("img/right.png");
		Iok = new ImageIcon("img/ok.png");
		lion = new ImageIcon("img/lion.png");
		muzi = new ImageIcon("img/muzi.png");
		neo = new ImageIcon("img/neo.png");
		gentle = new ImageIcon("img/gentle.png");
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
	}

	void J1_init(){
		cp.add(Scene3);
		Scene3.setLayout(null);
		J1_loadImage();
		J1_setUI();
	}
	void J1_loadImage() {
		a1i = new ImageIcon("img/apple.png");
		a2i = new ImageIcon("img/Banana.png");
		a3i = new ImageIcon("img/Mango.png");
		a4i = new ImageIcon("img/Strawberry.png");
		a5i = new ImageIcon("img/ok.png");
		a6i = new ImageIcon("imgs/hint.png");
		a7i = new ImageIcon("img/right.png");
		a8i = new ImageIcon("img/qzpane.png");
		Ibg5 = new ImageIcon("img/bg5.png");
		bg5.setIcon(Ibg5);
	}
	public void J1_setUI() {
		setTitle("< 비트 >");
		setSize(540, 960);
		setVisible(true);
		bg5.setSize(540,960);
		bg5.setLocation(0,0);
		a1 = new JButton(a1i);
		a2 = new JButton(a2i);
		a3 = new JButton(a3i);
		a4 = new JButton(a4i);
		a5 = new JButton(a5i);  //제출버튼
		a6 = new JButton(a6i); //힌트버튼
		a7 = new JButton(a7i); //재생버튼
		a8 = new JButton(a8i);
		pta = new JTextArea();
		pta.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		usern1 = new JLabel(User);
		try{
			File quizFile = new File("a.txt");
			BufferedReader br = new BufferedReader(new FileReader(quizFile));
			String quiz="";
			while((quiz=br.readLine()) != null){
					pta.append(quiz+"\n");
			}
		}catch(FileNotFoundException fe){
		}catch(IOException ie){
		}
		a1.addActionListener(this);
		a2.addActionListener(this);
		a3.addActionListener(this);
		a4.addActionListener(this);
		a5.addActionListener(this);
		a6.addActionListener(this);
		a7.addActionListener(this);
		a8.addActionListener(this);
		Scene3.add(a1);
		Scene3.add(a2);
		Scene3.add(a3);
		Scene3.add(a4);
		Scene3.add(a5);
		Scene3.add(a6);
		Scene3.add(a7);
		Scene3.add(pta);		
		Scene3.add(a8);
		Scene3.add(bg5);
		Scene3.add(usern1);
		a1.setBounds(80, 680, 150, 50); 
		a2.setBounds(280, 680, 150, 50);
		a3.setBounds(80, 750, 150, 50);
		a4.setBounds(280, 750, 150, 50);
		a5.setBounds(130, 830, 260, 50);
		a6.setBounds(10,10,120,80);
		a7.setBounds(390,10,120,80);
		a8.setBounds(70,100,400,500);
		pta.setBounds(120,310,280,130);
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
		a6.setBorderPainted(false);
		a6.setContentAreaFilled(false);
		a6.setFocusPainted(false);
		a6.setOpaque(false);
		a7.setBorderPainted(false);
		a7.setContentAreaFilled(false);
		a7.setFocusPainted(false);
		a7.setOpaque(false);
		a8.setBorderPainted(false);
		a8.setContentAreaFilled(false);
		a8.setFocusPainted(false);
		a8.setOpaque(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void H1_init(){
		setLocationRelativeTo(null);
		H_loadImg();
		bg4.setIcon(Ibg4);
		cp.add(Scene4);
		Scene4.setLayout(null);
		Scene4.add(bg4);
		Scene4.add(oxP);
		oxP.add(ox);
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
		ox = new JButton(quiz);
		b1.setBorderPainted(false);
		b1.setContentAreaFilled(false);
		b1.setFocusPainted(false);
		b1.setOpaque(false);
		b2.setBorderPainted(false);
		b2.setContentAreaFilled(false);
		b2.setFocusPainted(false);
		b2.setOpaque(false);
		b3.setBorderPainted(false);
		b3.setContentAreaFilled(false);
		b3.setFocusPainted(false);
		b3.setOpaque(false);
		b4.setBorderPainted(false);
		b4.setContentAreaFilled(false);
		b4.setFocusPainted(false);
		b4.setOpaque(false);
		b5.setBorderPainted(false);
		b5.setContentAreaFilled(false);
		b5.setFocusPainted(false);
		b5.setOpaque(false);
		b6.setBorderPainted(false);
		b6.setContentAreaFilled(false);
		b6.setFocusPainted(false);
		b6.setOpaque(false);
		b7.setBorderPainted(false);
		b7.setContentAreaFilled(false);
		b7.setFocusPainted(false);
		b7.setOpaque(false);
		b8.setBorderPainted(false);
		b8.setContentAreaFilled(false);
		b8.setFocusPainted(false);
		b8.setOpaque(false);
		b9.setBorderPainted(false);
		b9.setContentAreaFilled(false);
		b9.setFocusPainted(false);
		b9.setOpaque(false);
		b10.setBorderPainted(false);
		b10.setContentAreaFilled(false);
		b10.setFocusPainted(false);
		b10.setOpaque(false);
		
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
		Scene4.add(b10);
		Scene4.add(nnText);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b10.addActionListener(this);

		b1.setBounds(80, 550, 150, 100);//O
		//b2.setBounds(280, 550, 150, 100);//X
		b3.setBounds(100,210,300,50);//게임화면
		b4.setBounds(80, 750, 150, 50);//점수보기
		b5.setBounds(280, 750, 150, 50);//힌트받기
		b6.setBounds(110, 830, 300, 50);//다시하기
		b7.setBounds(10,0,120,50);//힌트
		nnText.setBounds(120,300,280,120);
		nnText.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		b8.setBounds(100,210,150,50);//퀴즈창 틀어넣기
		b9.setBounds(100,210,100,50);
		b10.setBounds(280, 100, 204, 69);

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
			time = new ImageIcon(ImageIO.read(new File("imgs/time.gif")));
			bg4.setIcon(Ibg4);
		}catch(IOException ie){
		}catch(NullPointerException ne){
		}
	}
	void H_setUI(){
		setTitle("<BIT> A WildLife Adventure : Start");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		oxP.setBackground(new Color(255,0,0,0));
		oxP.setSize(350,930);
		oxP.setLocation(95,700);

		bg4.setSize(540,960);
		bg4.setLocation(0,0);
	}
	void D_init(){
		Scene5.setLayout(null);
		cp.add(Scene5);
		try{
			 qzi = new ImageIcon(ImageIO.read(new File("img/qzpane.png")));
			 Ibg1 = new ImageIcon(ImageIO.read(new File("img/bg1.png")));
			 Iok = new ImageIcon(ImageIO.read(new File("img/ok.png")));
			 Inext = new ImageIcon(ImageIO.read(new File("img/right.png")));
			 Iprev = new ImageIcon(ImageIO.read(new File("img/left.png")));
			 Iexit =new ImageIcon(ImageIO.read(new File("imgs/exit.png")));
			 Iquestion =new ImageIcon(ImageIO.read(new File("imgs/question.png")));
			 laBg4.setIcon(Ibg1);
		  }catch(IOException ie){
			 System.out.println( "dkdldh");
	    }catch(NullPointerException ne){
		}
		Scene5.add(laBg4);
		font20 = new Font("sans serif",Font.BOLD,20);//폰트
		font30 = new Font("sans serif",Font.BOLD,30);   
		font40 = new Font("sans serif",Font.BOLD,40);
		bNext = new JButton(Inext);
		bNext.setBorderPainted(false);
		bNext.setContentAreaFilled(false);
		bNext.setFocusPainted(false);
		bPrev = new JButton(Iprev);
        bPrev.setBorderPainted(false);
        bPrev.setContentAreaFilled(false);
        bPrev.setFocusPainted(false);
		bClose = new JButton(Iexit);
		bClose.setBorderPainted(false);
		bClose.setContentAreaFilled(false);
		bClose.setFocusPainted(false);
		bInput = new JButton(Iok);
        bInput.setBorderPainted(false);
        bInput.setContentAreaFilled(false);
        bInput.setFocusPainted(false);
		bInput.addActionListener(this);
		bQuestion = new JButton(Iquestion);
        bQuestion.setBorderPainted(false);
        bQuestion.setContentAreaFilled(false);
        bQuestion.setFocusPainted(false);

		qz = new JButton(qzi);
        qz.setBorderPainted(false);
        qz.setContentAreaFilled(false);
        qz.setFocusPainted(false);  
		laInputAnswer = new JLabel("▼ 답안을 입력하세요");// 문장라벨
        laInputAnswer.setFont(font20);
        laInputAnswer.setForeground(Color.white);
		laScore = new JLabel("점수: " + intScore);//점수 라벨
		tf = new JTextField(10);//TextField
        tf.setFont(font20);
        ta = new JTextArea(1,10);//TextArea
        ta.setFont(font30);
        taQuestion = new JTextArea(10,10);
        taQuestion.setFont(new Font("sans serif",Font.BOLD,20));
		Scene5.add(qz);
        Scene5.add(tf);
        Scene5.add(ta);
        Scene5.add(taQuestion);
        Scene5.add(qz);
        Scene5.add(laInputAnswer);
        Scene5.add(laScore);
        Scene5.add(bInput);
        Scene5.add(bNext);
        Scene5.add(bPrev);
        Scene5.add(bClose);
        Scene5.add(bQuestion);
        Scene5.add(laBg4);
		tf.setBounds(100,750,200,50);
        ta.setBounds(100,650,350,50);
        taQuestion.setBounds(120,280,300,100);
        taQuestion.setText("What is the most popular"+"\n"+"programming language"+"\n"+" in 2020?");
		laInputAnswer.setBounds(100,700,300,50);
		bPrev.setBounds(80,510,118,80);
        bNext.setBounds(200,510,118,80);
        bClose.setBounds(333,510,118,100);
        qz.setBounds(50,80,450,450);
		bInput.setBounds(300,750,150,50);
		laBg4.setSize(540,960);
        laBg4.setLocation(0,0);
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
			Scene2 = new JPanel();
			nTitle = new JLabel(Ichoose);
			nInfo = new JLabel(Iinfo);
			nBack = new JLabel(Iback);
			nText = new JTextPane();
			nChoose = new JButton(Iok);
			nNext = new JButton(Iright);
			nPrev = new JButton(Ileft);
			char1 = new JButton(lion);
			char2 = new JButton(muzi);
			char3 = new JButton(neo);
			char4 = new JButton(gentle);
			S2_init();
		}else if(obj == nChoose){
			User = nText.getText();
			getContentPane().removeAll();
			revalidate();
			repaint();
			Scene3 = new JPanel();
			bg5 = new JLabel();
			J1_init();
		}if(obj == a1 || obj==a2 || obj == a3 || obj == a4){
			JOptionPane.showConfirmDialog(null, "확실한가요?", "질문",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		}else if(obj == a5){
			System.out.println(User);
			getContentPane().removeAll();
			revalidate();
			repaint();
			bg4 = new JLabel();
			Scene4 = new JPanel();
			oxP = new JPanel();
			ox = new JButton(quiz);
			b10 = new JButton(time);
			nnText = new JTextPane();
			nnText.setText("Today is Tuesday");
			H1_init();
			if (obj == b1){
				JOptionPane.showConfirmDialog(null, "동그라미 선택하실건가용??", "Question",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			}else if(obj == b2){
				JOptionPane.showConfirmDialog(null, "엑스 선택하실건가용??", "Question",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			}else if(obj == b3){
				pln("게임화면");
			}else if(obj == b4){
				pln("점수보기");
			}else if(obj == b6){
				pln("다시하기");
			}else if(obj == b7){
				JOptionPane.showConfirmDialog(null, "힌트를 보실건가요??", "Question",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			}else {
				pln("힌트받기");
			}
		}else if(obj == b5){
			getContentPane().removeAll();
			revalidate();
			repaint();
			Scene5 = new JPanel();
			laBg4 = new JLabel();
			D_init();
		}else if(obj == bInput){
			ta.setText(tf.getText());   
			if(obj == bInput){
				if(tf.getText().equals("python")){
					ta.setText("정답입니다!");
					System.out.println(User);
					JOptionPane.showMessageDialog(null,User + " 님의 점수는 null 점입니다!");
				}else if(tf.getText().equals("Python")){
				}else {
				   ta.setText("틀렸습니다!");
				}
			}
		}
	}
	void makeMusic(){
		try{
			File mu = new File("Island Coconuts - Aaron Kenny.wav");
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(mu));		
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "이어폰을 이용해주세요.");
		}	
	}
	public static void main(String[] args){
		try{
			Start st = new Start();
		}catch(IOException ie){
		}
	}
}
