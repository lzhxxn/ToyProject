package four.quiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class MS extends JFrame   {
	JButton b, btt;
	Container cp;
	JLabel laFont;
	JTextField tfName;
	String nameG;
	ImageIcon reset;
	JPanel jp, j;

	MS(){
		laFont = new JLabel();
		tfName = new JTextField(20);
		init();
	}
	void init(){
		cp = getContentPane();
		cp.setLayout(new BorderLayout());
		j = new JPanel(new FlowLayout());
		j.add(laFont);
		j.add(tfName);
		cp.add(j);
		jp = new JPanel(new BorderLayout());
		cp.add(jp,BorderLayout.SOUTH);
		b = new JButton("Game Start");
		j.add(b);
		laFont.setFont(new Font("�������",Font.BOLD,16));
		laFont.setHorizontalAlignment(JLabel.CENTER);
		laFont.setVerticalAlignment(JLabel.CENTER);
		Border oBorder = laFont.getBorder();
		Border eBorder = new EmptyBorder(20,10,20,10);
		laFont.setBorder(oBorder);
		laFont.setBorder(eBorder);
		laFont.setText("Enter your name");
		
		reset = new ImageIcon("img\\reset.png");
		JToolBar bar =new JToolBar();
		btt = new JButton(null,reset);
		btt.setBorderPainted(false);//�ܰ��� �����ֱ�
		btt.setContentAreaFilled(false);//���뿵��ä��� �����ֱ�
		btt.setFocusPainted(false); //������ �׵θ� ���°�
		btt.setToolTipText("������ �ٽ� �����մϴ�.");

		bar.add(btt);
		jp.add(btt,BorderLayout.EAST);//��������� tool�������ϱ�
		
		
		//�̺�Ʈ ó��
		ActionListener msH = new MSHandler(this);
		b.addActionListener(msH);
		btt.addActionListener(msH);
		tfName.addActionListener(msH);

	    setUI();
	}
	
	void setUI(){
		setTitle("�̸�(��) �Է�â");
		pack();
		setSize(280,200);
		setVisible(true);
		//setLocation(200,100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String [] args) {
		new MS();
	}
}