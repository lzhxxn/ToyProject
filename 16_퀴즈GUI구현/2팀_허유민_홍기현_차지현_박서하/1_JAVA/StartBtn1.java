import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.border.*;
import java.util.*;

// ��ŸƮ��ư ������ ���¹�Ʈ ����� ���´����� ��ŸƮ ����Ա����� �����߾��
class StartBtn1 extends JFrame implements ActionListener {
	
	class DrawingPanel extends JPanel{
		int score_i1, score_i2, score_i3, score_i4, score_i5;
		Color color = new Color(124,82,244);
		public void paint(Graphics g){
			g.clearRect(0,0,getWidth(),getHeight()); //�г��� ��ü Ŭ����
			g.drawLine(890,250,280,680); //x, y, ����, ���� ���߱� //50,250,265,520
			//y���� ���� �� ���� ���̴� ������ ����(����������)
			for(int cnt = 1 ;cnt<11;cnt++) //�׷��� ��� �׸���
			{
				//g.drawString(cnt *10 +"",25,255-20*cnt); //y�� ǥ�ð�
				//g.drawLine(50, 250-30*cnt, 270,250-30*cnt); //x�� ���α׸���/20��
			}
			g.drawLine(40,10,40,320); //y�� ����
			g.drawString("1",50,350); //���ڿ�,x,y��
			g.drawString("2",100,350);
			g.drawString("3",150,350);
			g.drawString("4",200,350);
			g.drawString("5",250,350);
			g.setColor(color); //���� ����
			if (score_i1>0)
				g.fillRect(50,(300-score_i1*3),18,score_i1*3); //x, y, ����, ����
			if(score_i2>0)
				g.fillRect(100,(300-score_i2*3),18,score_i2*3);
			if(score_i3>0)
				g.fillRect(150,(300-score_i3*3),18,score_i3*3);
			if(score_i4>0)
				g.fillRect(200,(300-score_i4*3),18,score_i4*3);
			if(score_i5>0)
				g.fillRect(250,(300-score_i5*3),18,score_i5*3);
		}
		void setScores(int score_i1, int score_i2, int score_i3, int score_i4, int score_i5)
		{ //�� �ޱ�
			this.score_i1=score_i1;
			this.score_i2=score_i2;
			this.score_i3=score_i3;
			this.score_i4=score_i4;
			this.score_i5=score_i5;
		}
	}

	//��ư �������� �����ϴ� ������
	class DrawActionListener implements ActionListener
	{
		JTextField text1,text2,text3,text4,text5;
		DrawingPanel drawingPanel;
		DrawActionListener(JTextField text1, JTextField text2, JTextField text3, JTextField text4, JTextField text5, DrawingPanel drawingPanel)
		{
			this.text1=text1; //1~5���� �� �ޱ�
			this.text2=text2;
			this.text3=text3;
			this.text4=text4;
			this.text5=text5;
			this.drawingPanel = drawingPanel; // drawingPanel �� �ޱ�
		}
		public void actionPerformed(ActionEvent e2) //�̺�Ʈ �߻�
		{
			Object obj = e2.getSource();
			JButton sb2 = (JButton)obj;
			if(obj == bShow){
				try
				{ //�������·� �ٲ㼭 TEXT�� ���
					int i1 = Integer.parseInt(text1.getText());
					int i2 = Integer.parseInt(text2.getText());
					int i3 = Integer.parseInt(text3.getText());
					int i4 = Integer.parseInt(text4.getText());
					int i5 = Integer.parseInt(text5.getText());
					drawingPanel.setScores(i1, i2, i3,i4,i5);
					drawingPanel.repaint(); //paint�޼ҵ� ���� ȣ��
				}
				catch (NumberFormatException nfe){
					JOptionPane.showMessageDialog(drawingPanel,"�߸��� ���� �Է��Դϴ�","�����޽���",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	Vector<String> Qlist = new Vector<String>();
	Quiz ql = new Quiz(this);int Qnum;
	Random r = new Random();

	String font = "Oranienbaum";
	Color color = new Color(124,82,244);
	JButton bS, bR, bo, bx, bp, bOpen;
	Container cp;
	FlowLayout flow= new FlowLayout(FlowLayout.CENTER,0,210);
	JPanel pQ, pS, pt, pg, pU, pD, pz, OX;
	JTextPane tp;
	JScrollPane sp;
	MyMouseListener listener = new MyMouseListener();
	JLabel label1,label2;
	//JPanel pU, pD, pz, OX;
	ImageIcon timer, reseticon;
	JLabel laImg = new JLabel();
	JLabel lg,lt;
	JButton a,g,quiz,bShow;
	JPanel pAll, pInput;
	JTextField text1,text2,text3,text4,text5,textField;
	JTextArea textArea;//�����ġ
	String text;
	int score_i1, score_i2, score_i3, score_i4, score_i5;
	void init(){
		cp = getContentPane();
		setUpDown();
		
		pS = new JPanel();
		OX = new JPanel();
		OX.setLayout(null);
		
		pt = new JPanel(); 
		
		loadImg();
		setOXBtn();
		
		bo.addMouseListener(listener);
		bp.addMouseListener(listener);
		bx.addMouseListener(listener);
		
		butSet();
		setChat();
		setStartB();
		setTeamN();
		cp.add(laImg);
		cp.add(OX);
		cp.add(pS);
		pS.setBackground(Color.white);
		OX.setBackground(Color.white);
		OX.setBounds(30,650,850,100);
		pt.setBackground(Color.white);
		pt.setBounds(500,30,250,100);
		pt.setLayout(null);
		setUI();
	}
	void setTeamN(){
		JPanel lowerpanel = new JPanel(); //pl1 ������
		JPanel upperPanel = new JPanel();//oppl
		textField = new JTextField("�� �̸�",10); textField.setFont(new Font(font, Font.PLAIN, 15));
		textField.setSize(100,70);
		textArea = new JTextArea(1, 10); textArea.setFont(new Font(font, Font.BOLD, 35));
		textArea.setSize(180,80);
		text = textField.getText(); textArea.setEditable(false);
		upperPanel.setLayout(new FlowLayout(FlowLayout.LEFT,20,50));
		lowerpanel.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		upperPanel.setSize(350,100); upperPanel.setLocation(0,10);
		lowerpanel.setSize(350,100); lowerpanel.setLocation(0,100);
		upperPanel.add(textArea);
		label1 = new JLabel("Team Name : "); label1.setFont(new Font(font, Font.BOLD, 25));
		upperPanel.add(label1); upperPanel.add(textField); lowerpanel.add(textArea);
		upperPanel.setBackground(Color.white); lowerpanel.setBackground(Color.white);
		textField.requestFocus();
		textField.addActionListener(this);
		cp.add(lowerpanel);
		cp.add(upperPanel);
	}
	void setUpDown(){
		pU = new JPanel();
		pD = new JPanel();
		pU.setLayout(null); pU.setBounds(0,0,1200,30);
		pU.setBackground(color);
		pD.setLayout(null); pD.setBounds(0,745,1200,30);
		pD.setBackground(color);
		cp.add(pU);
		cp.add(pD);
	}
	void butSet(){
		a = new JButton(timer);
		a.setBounds(0,0,200,100);
		a.setBorderPainted(false); a.setContentAreaFilled(false); a.setFocusPainted(false);
		pt.add(a);

	}
	void setQuiz(){
		pQ = new JPanel();
		quiz = new JButton();
		quiz.setFont(new Font(font,Font.BOLD,60));
		quiz.setPreferredSize(new Dimension(560, 350));
		quiz.setBorderPainted(true); quiz.setContentAreaFilled(false); quiz.setFocusPainted(false);
		//ActionListener listener2 = new A1Handler();
		pQ.add(quiz);
		pQ.setBackground(Color.white); pQ.setLayout(flow);
		quiz.addActionListener(this);
		cp.add(pQ);
	}
	void setChat(){
		setPanel();
        pInput = new JPanel();
        JTextField text1 = new JTextField(3);
        JTextField text2 = new JTextField(3);
        JTextField text3 = new JTextField(3);
		JTextField text4 = new JTextField(3);
		JTextField text5 = new JTextField(3);
		JLabel l1 = new JLabel("1 :"); l1.setFont(new Font(font,Font.BOLD,15));
		JLabel l2 = new JLabel("2 :"); l2.setFont(new Font(font,Font.BOLD,15));
		JLabel l3 = new JLabel("3 :"); l3.setFont(new Font(font,Font.BOLD,15));
		JLabel l4 = new JLabel("4 :"); l4.setFont(new Font(font,Font.BOLD,15));
		JLabel l5 = new JLabel("5 :"); l5.setFont(new Font(font,Font.BOLD,15));
		l1.setSize(25,10);text1.setSize(25,10);
		l2.setSize(25,10);text2.setSize(25,10);
		l3.setSize(25,10);text3.setSize(25,10);
		l4.setSize(25,10);text4.setSize(25,10);
		l5.setSize(25,10);text5.setSize(25,10);
        bShow = new JButton("Show");bShow.setFont(new Font(font,Font.BOLD,15));bShow.setSize(25,10);
		bShow.setBorderPainted(false);bShow.setContentAreaFilled(false);bShow.setFocusPainted(false); 
        pInput.add(l1);pInput.add(text1);
        pInput.add(l2);pInput.add(text2);
        pInput.add(l3);pInput.add(text3);
		pInput.add(l4);pInput.add(text4);
		pInput.add(l5);pInput.add(text5);
        pInput.add(bShow);
		
		pInput.setBackground(Color.white);
		pInput.setSize(70,200);
		pInput.setLocation(190,70);
		pAll.add(pInput);
		DrawingPanel drawingPanel = new DrawingPanel();
		drawingPanel.setSize(280,680);
		drawingPanel.setLocation(0,300);
		drawingPanel.setBackground(Color.white);
		pAll.add(drawingPanel);

		cp.add(pAll);
        bShow.addActionListener(new DrawActionListener(text1,text2,text3,text4,text5,drawingPanel));
        //"�׷��� �׸���" ��ư�� �������� �۵� �� �����͵��
        
	}
	void setPanel(){
		pAll = new JPanel();
		pAll.setSize(280,780);
		pAll.setLocation(890,30);
		pAll.setLayout(null);
		pAll.setBackground(Color.white);
	
	}
	void loadImg(){	
		timer = new ImageIcon(getClass().getResource("60seconds.gif"));
		reseticon = new ImageIcon(getClass().getResource("reload.PNG")); 
	}

	void setOXBtn(){
		bo = new JButton("O");
		bp = new JButton("P A S S");
		bx = new JButton("X");
		bR = new JButton(reseticon);
		OX.add(bo); OX.add(bp); OX.add(bx); OX.add(bR);
		bo.setFont(new Font(font,Font.BOLD,50));
		bp.setFont(new Font(font,Font.BOLD,50));
		bx.setFont(new Font(font,Font.BOLD,50));
		bo.setSize(100, 50); bp.setSize(200, 50); bx.setSize(100, 50); bR.setSize(64, 64);
		bo.setLocation(260, 5); bp.setLocation(480, 5); bx.setLocation(790, 5); bR.setLocation(0, 5);
		bo.setBorderPainted(false); bo.setContentAreaFilled(false);bo.setFocusPainted(false);//�׵θ� ���� ����
		bp.setBorderPainted(false);bp.setContentAreaFilled(false);bp.setFocusPainted(false);
		bx.setBorderPainted(false);bx.setContentAreaFilled(false);bx.setFocusPainted(false);
		bR.setBorderPainted(false);bR.setContentAreaFilled(false);bR.setFocusPainted(false);
		bo.addActionListener(this);
		bp.addActionListener(this);
		bx.addActionListener(this);
		bR.addActionListener(this);
	}
	void setUI(){
		setTitle("QUIZ");
		setBackground(Color.white);
		setSize(1200, 800);
		setVisible(true);
		setLocationRelativeTo(null);
		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void setStartB(){
		bS = new JButton("S T A R T");
		pS.setLayout(flow);
		pS.add(bS);		
		bS.addActionListener(this);
		bS.addMouseListener(listener);
		bS.setPreferredSize(new Dimension(550, 350));
		bS.setBorderPainted(false); //��� �ܰ���
		bS.setContentAreaFilled(false); //��ư ä���
		bS.setFocusPainted(false); //���õ����� ����� �ܰ���
		bS.setLocation(600,200);
		bS.setFont(new Font(font,Font.BOLD,80));
	}
	public void actionPerformed(ActionEvent e) {
		
		Object obj1 = e.getSource();
		textArea.setText(":" + e.getActionCommand());
		text = textField.getText();
		textArea.setText("Team : "+text);
		Object obj2 = e.getSource();
		JButton sb = (JButton)obj2;
		if(obj2 == bS){
			cp.add(pt);
			cp.remove(pS);
			setQuiz();
			Qnum = r.nextInt(Qlist.size());
			quiz.setText(Qlist.get(Qnum));
			Qlist.remove(Qlist.get(Qnum));
			revalidate();
			repaint();
		}else if(obj2 == bR){
			cp.removeAll();
			timer.getImage().flush();
			butSet();
			revalidate();
			repaint();
			init();
		}else if(obj2 == bo){
			Qnum = r.nextInt(Qlist.size());
			quiz.setText(Qlist.get(Qnum));
			Qlist.remove(Qlist.get(Qnum)); 
		}else if(obj2 == bp){
			Qnum = r.nextInt(Qlist.size());
			quiz.setText(Qlist.get(Qnum));
			Qlist.remove(Qlist.get(Qnum));
		}else if(obj2 == bx){
			Qnum = r.nextInt(Qlist.size());
			quiz.setText(Qlist.get(Qnum));
			Qlist.remove(Qlist.get(Qnum));
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) throws Exception
	{
		StartBtn1 s = new StartBtn1();
		s.init();
	}
}

class MyMouseListener implements MouseListener, MouseMotionListener{
	
	Color color = new Color(124,82,244);
	public void mouseMoved(MouseEvent e){
	}
	public void mouseExited(MouseEvent e){
		JButton sb = (JButton)e.getSource();
		sb.setForeground(Color.black);
	}
	public void mouseClicked(MouseEvent e){
		JButton sb = (JButton)e.getSource();
		sb.setForeground(color);
	}
	public void mouseReleased(MouseEvent e){
		JButton sb = (JButton)e.getSource();
		sb.setForeground(Color.black);
	}
	public void mousePressed(MouseEvent e){}
	public void mouseDragged(MouseEvent e){}
	public void mouseEntered(MouseEvent e){
		JButton sb = (JButton)e.getSource();
		sb.setForeground(color);
	}
}
