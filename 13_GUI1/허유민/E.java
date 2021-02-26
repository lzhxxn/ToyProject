import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;

class E extends JFrame implements ActionListener {
	Container cp;
	JButton first, seeb, ivb, searb, moneyb, profileb;
	ImageIcon jobs,see,iv,sear,money,profile;
	ImageIcon back1;
	JLayeredPane lp;
	JPanel p;
	void init(){
		loadImg();
		cp = getContentPane();
		cp.setLayout(new FlowLayout());
		setBtn();
		
		setUI();
	}
	void setBtn(){
		first = new JButton(jobs);
		seeb = new JButton("���� ����",see);
		seeb = new JButton("���� ����",see);
		searb = new JButton("�� ��",sear);
		moneyb = new JButton("�����̾� ȸ����",money);
		ivb = new JButton("1:1 ��� ����",iv);
		profileb = new JButton("����������",profile);
		first.setBackground(Color.white);
		seeb.setBackground(Color.white);
		searb.setBackground(Color.white);
		moneyb.setBackground(Color.white);
		ivb.setBackground(Color.white);
		profileb.setBackground(Color.white);
		first.setPreferredSize(new Dimension(400, 600));
		seeb.setPreferredSize(new Dimension(400, 100));
		searb.setPreferredSize(new Dimension(400, 100));
		moneyb.setPreferredSize(new Dimension(400, 100));
		ivb.setPreferredSize(new Dimension(400, 100));
		profileb.setPreferredSize(new Dimension(400, 100));

		seeb.setFont(new Font("ī��24 �����",Font.PLAIN,25));
		searb.setFont(new Font("ī��24 �����",Font.PLAIN,25));
		moneyb.setFont(new Font("ī��24 �����",Font.PLAIN,25));
		ivb.setFont(new Font("ī��24 �����",Font.PLAIN,25));
		seeb.setFont(new Font("ī��24 �����",Font.PLAIN,25));
		profileb.setFont(new Font("ī��24 �����",Font.PLAIN,25));
		
		first.addActionListener(this);
		seeb.addActionListener(this);
		searb.addActionListener(this);
		profileb.addActionListener(this);
		moneyb.addActionListener(this);
		ivb.addActionListener(this);
		profileb.addActionListener(this);
		cp.add(first);cp.add(seeb);cp.add(searb);cp.add(moneyb);cp.add(ivb);cp.add(profileb);
	}
	void loadImg(){
		try{
			jobs = new ImageIcon(ImageIO.read(new File("imgs/jobs.PNG")));
			see = new ImageIcon(ImageIO.read(new File("imgs/see.PNG")));
			sear = new ImageIcon(ImageIO.read(new File("imgs/search.PNG")));
			money = new ImageIcon(ImageIO.read(new File("imgs/money.PNG")));
			iv = new ImageIcon(ImageIO.read(new File("imgs/interview.PNG")));
			profile = new ImageIcon(ImageIO.read(new File("imgs/profile.PNG")));
		}catch(IOException ie){
			System.out.println("ie: " + ie);
		}
	}
	void setUI(){
		setTitle("JobSearch");
		pack();
		setSize(400, 570);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		JButton e1 = (JButton)obj;
		if(obj == first){
			cp.remove(e1);
		}	
		revalidate();
		//repaint();
		if(obj == seeb){
				int answer1 = JOptionPane.showConfirmDialog(null, "�Խõ� ���� �����ϴ�.", "Message", 
				JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.QUESTION_MESSAGE,
				see);
		}else if(obj == searb){
			Object items[] = {"ä�����", "ȸ���", "��Ÿ"};
			Object answer2 = JOptionPane.showInputDialog(null, "�˻� �� ����", "Search", 
				JOptionPane.QUESTION_MESSAGE, 
				sear, items, items[0]);
		}else if(obj == moneyb){
			int answer3 = JOptionPane.showConfirmDialog(null, "ȸ������ �����Ͻðڽ��ϱ� ?", "����", 
			JOptionPane.OK_CANCEL_OPTION, 
			JOptionPane.QUESTION_MESSAGE, 
			money);
			if(answer3 == JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ� !");
			}else{
				JOptionPane.showMessageDialog(null, "������ ��ҵǾ����ϴ� !");
			}
		}
		else if(obj == ivb){
			Object items[] = {"��ȭ ���", "�湮 ���", "��Ÿ"};
			Object answer2 = JOptionPane.showInputDialog(null, "���� ���", "Question", 
			JOptionPane.QUESTION_MESSAGE, 
			sear, items, items[1]);
		}else if(obj == profileb){
			int answer5 = JOptionPane.showConfirmDialog(null, "�α��� �� �̿����ּ���.", "MyPage", 
				JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.WARNING_MESSAGE, 
				profile);
			}
	}
	
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String args[]){
		E e = new E();
		e.init();
	}
}