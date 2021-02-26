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

		bN = new JButton("��");
		bS = new JButton("��");
		bW = new JButton("��");
		bE = new JButton("��");
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
		setTitle("���ĳ� ���ϰ���");
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
			q("�ƺ�ī�� �� �� 1000���ε� ��Ƕ��?", iiAvocado);
		}else if(obj == bPE){
			q("�ٳ��� �� �� 300���ε� ��Ƕ��?", iiBanana);
		}else if(obj == bPW){
			q("Ű�� �� �� 500���ε� ��Ƕ��?", iiKiwi);
		}else if(obj == bPN){ 
			q("���� �� �� 15000���ε� ��Ƕ��?", iiWatermelon);
		}else if(obj == bW){
			JOptionPane.showMessageDialog(null, "�ڸ��� �Ǹ��ϰ� ���� �ʽ��ϴ�!", "���", JOptionPane.YES_NO_OPTION, iiGrapefruit);
		}else if(obj == bE){
			int exitOption = JOptionPane.showConfirmDialog(null, "���ϰ��Ը� �����ðڽ��ϱ�?", "����", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, iiApple);
			if(exitOption == JOptionPane.YES_OPTION) {
				System.exit(-1);
			}
		}else if(obj == bN){
			String review[] = {"������ ���Ҿ��", "�� ���Ҿ�� �Ӿ�", "���� �׷����", "���ο���"};
			JOptionPane.showInputDialog(null, "���ϰ��� �̿��� ��̳���?", "�̿��ı�", 0, iiStrawberry, review, review[0]);
		}else {
			String review[] = {"�ƺ�ī��", "�ٳ���", "Ű��", "����"};
			JOptionPane.showOptionDialog(null, "���� �ո����� ������ ������ �����ΰ���?", "�����ı�", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, iiBlueberry, review, review[0]);
		}
	}
	void q(String Question, ImageIcon img){
		int answer = JOptionPane.showConfirmDialog(null, Question, "����",
			JOptionPane.OK_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			img);
		if(answer == JOptionPane.YES_OPTION){
			JOptionPane.showMessageDialog(null, "�ܸ��̶��ϴ�, ���ְ� �弼��!");
		}else{
			JOptionPane.showMessageDialog(null, "����, �ƽ�����! ������ ������!");
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
