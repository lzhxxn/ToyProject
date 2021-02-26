import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;

class UiTest extends JFrame implements ActionListener {
	JButton bN, bS, bW, bE, bC;
	JButton bPC, bPE, bPW, bPN;
	JButton eI1;
	Container cp;
	JPanel p;
	
	JButton b;
	ImageIcon iiAvocado, iiBanana, iiKiwi, iiWatermelon, iiGrapefruit, iiApple, iiStrawberry, iiBlueberry;
	File f;

	void init(){
		loadImg();
		p = new JPanel();
		p.setLayout(new GridLayout(2,2));
		bPC = new JButton(iiAvocado);
		bPE = new JButton(iiBanana);
		bPW = new JButton(iiKiwi);
		bPN = new JButton(iiWatermelon);
        p.add(bPC, BorderLayout.CENTER);
		p.add(bPE, BorderLayout.EAST);
		p.add(bPW, BorderLayout.WEST);
		p.add(bPN, BorderLayout.NORTH);
		bPC.addActionListener(this);
		bPE.addActionListener(this);
		bPW.addActionListener(this);
		bPN.addActionListener(this);

		bN = new JButton("북");
		bS = new JButton("남");
		bW = new JButton("서");
		bE = new JButton("동");
		bN.addActionListener(this);
		bS.addActionListener(this);
		bW.addActionListener(this);
		bE.addActionListener(this);
		cp = getContentPane();
		
		b = new JButton();
		cp.add(bN, BorderLayout.NORTH);
		cp.add(bS, BorderLayout.SOUTH);
		cp.add(bW, BorderLayout.WEST);
		cp.add(bE, BorderLayout.EAST);
		cp.add(p);

		setUI();
	}
	void loadImg(){
		try{
			File f = new File("imgs/002-avocado.png");
			BufferedImage bi = ImageIO.read(f);
			iiAvocado = new ImageIcon(bi);
			iiBanana = new ImageIcon(ImageIO.read(new File("imgs/011-banana.png")));
			iiKiwi = new ImageIcon(ImageIO.read(new File("imgs/014-kiwi.png")));
			iiWatermelon = new ImageIcon(ImageIO.read(new File("imgs/019-watermelon.png")));
			iiGrapefruit = new ImageIcon(ImageIO.read(new File("imgs/047-grapefruit.png")));
			iiApple = new ImageIcon(ImageIO.read(new File("imgs/001-apple.png")));
			iiStrawberry = new ImageIcon(ImageIO.read(new File("imgs/042-strawberry.png")));
			iiBlueberry = new ImageIcon(ImageIO.read(new File("imgs/034-blueberry.png")));
		}catch(IOException ie){
		}
	}
	void setUI(){
		setTitle("영후네 과일가게");
		pack();
		setVisible(true);
		setLocation(200, 100);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		JButton b = (JButton)obj;
		if(obj == bPC){
			q("아보카도 한 개 1000원인데 사실라우?", iiAvocado);
		}else if(obj == bPE){
			q("바나나 한 개 300원인데 사실라우?", iiBanana);
		}else if(obj == bPW){
			q("키위 한 개 500원인데 사실라우?", iiKiwi);
		}else if(obj == bPN){ 
			q("수박 한 통 15000원인데 사실라우?", iiWatermelon);
		}else if(obj == bW){
			JOptionPane.showMessageDialog(null, "자몽은 판매하고 있지 않습니다!", "경고", JOptionPane.YES_NO_OPTION, iiGrapefruit);
		}else if(obj == bE){
			int exitOption = JOptionPane.showConfirmDialog(null, "과일가게를 나가시겠습니까?", "종료", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, iiApple);
			if(exitOption == JOptionPane.YES_OPTION) {
				System.exit(-1);
			}
		}else if(obj == bN){
			String review[] = {"아주주 좋았어요", "쫌 좋았어요 머쓱", "그저 그랬어요", "별로예요"};
			JOptionPane.showInputDialog(null, "과일가게 이용이 어떠셨나요?", "이용후기", 0, iiStrawberry, review, review[0]);
		}else {
			String review[] = {"아보카도", "바나나", "키위", "수박"};
			JOptionPane.showOptionDialog(null, "가장 합리적인 가격의 과일은 무엇인가요?", "가격후기", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, iiBlueberry, review, review[0]);
		}
	}
	void q(String Question, ImageIcon img){
		int answer = JOptionPane.showConfirmDialog(null, Question, "질문",
			JOptionPane.OK_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			img);
		if(answer == JOptionPane.YES_OPTION){
			JOptionPane.showMessageDialog(null, "꿀맛이랍니다, 맛있게 드세요!");
		}else{
			JOptionPane.showMessageDialog(null, "저런, 아쉽군요! 조심히 들어가세요!");
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		UiTest ut = new UiTest();
		ut.init();
	}
}
