import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.border.*;
import java.util.*;
// 스타트버튼 누르면 리셋버트 생기고 리셋누르면 스타트 생기게까지만 구현했어양
class StartBtn1 extends JFrame implements ActionListener {
	String pont = "Oranienbaum";
	Color color = new Color(124,82,244);
	JButton startB, bR;
	Container cp;
	FlowLayout flow= new FlowLayout(FlowLayout.CENTER,0,210);
	JPanel p;// 문제창 에리어
	JPanel p1; //스타트 버튼 에리어
	JTextPane tp;
	JScrollPane sp;
	JButton bOpen;
	String fPath = "C:/SOO/Java/자료실";
	MyMouseListener listener = new MyMouseListener();
	final static int FC_OPEN = 0;
	final static int FC_SAVE = 1;
	//젼
	JLabel label1,label2;
	JTextField tf1, tf2;
	JPanel pl1, pl2;
	JPanel pU, pD;
	//서하,기현
	JPanel OX; //판넬 -> 쟁반
	JButton bo; //반찬
    JButton bp;
	JButton bx;
	ImageIcon timer, iii, iiii;
	JLabel laImg = new JLabel();
	JLabel lg,lt;
	JPanel pt,pg;
	JButton a,g;

	void init(){
		cp = getContentPane();
		setUpDown();
		pl1 = new JPanel();
		pl2 = new JPanel();
		p1 = new JPanel();
		p1.setBackground(Color.white);
		OX = new JPanel();
		OX.setLayout(null);
		OX.setBackground(Color.white);
		OX.setBounds(30,650,850,100);
		pt = new JPanel(); 
		pt.setBackground(Color.white);
		pt.setBounds(500,30,200,100);
		pt.setLayout(null);
		pg = new JPanel();
		pg.setBackground(Color.white);
		pg.setBounds(910,260,265,520);
		loadImg();
		setOXBtn();
		
		bo.addMouseListener(listener);
		bp.addMouseListener(listener);
		bx.addMouseListener(listener);
		
		butSet();
		
		setStartB();
		setTNS();
		cp.add(laImg);
		cp.add(OX);
		cp.add(p1);
		setUI();
	}
	void setUpDown(){
		pU = new JPanel();
		pD = new JPanel();
		pU.setLayout(null);
		pU.setBounds(0,0,1200,30);
		pU.setBackground(color);
		pD.setLayout(null);
		pD.setBounds(0,745,1200,30);
		pD.setBackground(color);
		cp.add(pU);
		cp.add(pD);
	}
	void butSet(){
		a = new JButton(timer);
		a.setBounds(0,0,200,100);
		a.setBorderPainted(false);
		a.setContentAreaFilled(false);
		a.setFocusPainted(false);
		pt.add(a);
		//cp.add(pt);

	}

	void loadImg(){	
		timer = new ImageIcon(getClass().getResource("60seconds.gif"));
		iii = new ImageIcon(getClass().getResource("G.PNG")); 
		iiii = new ImageIcon(getClass().getResource("reload.PNG")); 
	}

	void butSet2(){
		lg = new JLabel("TEAM SCORE");
		lg.setFont(new Font(pont, Font.PLAIN, 30));
		lt = new JLabel("       1       2       3       4     5");
		lt.setFont(new Font(pont, Font.PLAIN,20));
		g = new JButton(iii);
		g.setPreferredSize(new Dimension(270, 400));
		g.setBorderPainted(false);
		g.setContentAreaFilled(false);
		g.setFocusPainted(false);
		pg.add(lg);
		pg.add(g);
		pg.add(lt);
		cp.add(pg);
	}

	void setOXBtn(){
		bo = new JButton("O");
		bp = new JButton("P A S S");
		bx = new JButton("X");
		bR = new JButton(iiii);
		OX.add(bo); //쟁반 위에 반찬 올리깅
		OX.add(bp);
		OX.add(bx);
		OX.add(bR);
		bo.setFont(new Font(pont,Font.PLAIN,50));
		bp.setFont(new Font(pont,Font.PLAIN,50));
		bx.setFont(new Font(pont,Font.PLAIN,50));
		bo.setSize(100, 50); 
        bp.setSize(200, 50);
		bx.setSize(100, 50);
		bR.setSize(64, 64);
		bo.setLocation(260, 5); //위치 설정
        bp.setLocation(480, 5);
		bx.setLocation(790, 5);
		bR.setLocation(0, 5);
		bo.setBorderPainted(false); //테두리 색상 투명
		bp.setBorderPainted(false);
		bx.setBorderPainted(false);
		bR.setBorderPainted(false);
		bo.setContentAreaFilled(false); //버튼 안 색상 투명
		bp.setContentAreaFilled(false);
		bx.setContentAreaFilled(false);
		bR.setContentAreaFilled(false);
		bo.setFocusPainted(false); //버튼 눌렀을 때 생기는 테두리 사용안함
		bp.setFocusPainted(false);
		bx.setFocusPainted(false);
		bR.setFocusPainted(false);
		bo.addActionListener(this);
		bp.addActionListener(this);
		bx.addActionListener(this);
		bR.addActionListener(this);
	}
	void setUI(){
		setTitle("Test");
		setBackground(Color.white);
		setSize(1200, 800);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void setStartB(){
		startB = new JButton("S T A R T");
		p1.setLayout(flow);
		p1.add(startB);		
		startB.addActionListener(this);
		startB.addMouseListener(listener);
		startB.setPreferredSize(new Dimension(550, 350));
		startB.setBorderPainted(false); //요거 외곽선
		startB.setContentAreaFilled(false); //버튼 채우기
		startB.setFocusPainted(false); //선택됐을때 생기는 외곽선
		startB.setLocation(600,200);
		startB.setFont(new Font(pont,Font.PLAIN,80));
	}
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		JButton sb = (JButton)obj;
		if(obj == startB){
			cp.add(pt);
			butSet2();
			cp.remove(p1);
			cp = getContentPane();
			setQArea();
			revalidate();
			repaint();
		}else if(obj == bR){
			cp.removeAll();
			revalidate();
			repaint();
			init();
			
		}else if(obj == bOpen){
			showFC(FC_OPEN);
		}else if(obj == bo){
			System.out.println("O"); // 클릭 이벤트 잘 걸리는지 확인용
		}else if(obj == bp){
			System.out.println("Pass");
		}else if(obj == bx){
			System.out.println("x");
		}
	}
	void setQArea(){
		p = new JPanel();
		p.setBackground(Color.white);
		p.setLayout(flow);

		tp = new JTextPane();
		sp = new JScrollPane(tp);
		sp.getViewport().setBackground(Color.white);
		
		tp.setPreferredSize(new Dimension(560, 350));
		String open = "<html>O<br/>P<br/>E<br/>N</html>";
		bOpen = new JButton(open);
		bOpen.setBackground(color);
		bOpen.setFont(new Font(pont,Font.PLAIN,30));
		bOpen.setContentAreaFilled(false);
		bOpen.setBorderPainted(false);
		bOpen.setFocusPainted(false);
		bOpen.setPreferredSize(new Dimension(50,350));
		bOpen.addActionListener(this);
		bOpen.addMouseListener(listener);

		cp.add(p);
		p.add(bOpen);
		p.add(sp);
	}

	void showFC(int mode){
		JFileChooser jfc = new JFileChooser(fPath);
		FileNameExtensionFilter filter 
			= new FileNameExtensionFilter("파일열기(txt/java)", "txt", "java");
		jfc.addChoosableFileFilter(filter);

        int option = -1;
		if(mode == FC_OPEN){
			option = jfc.showOpenDialog(this);
		}else{
			option = jfc.showSaveDialog(this);	
		}
		if(option == JFileChooser.APPROVE_OPTION){
			File f = jfc.getSelectedFile();	
			if(mode == FC_OPEN){
				readF(f);
			}else{}
		}
	}

	void readF(File f){ 
		FileReader fr = null;
		BufferedReader br = null;
		try{
			String line = "";
			StringBuffer sb = new StringBuffer();
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			while((line = br.readLine()) != null){
				sb.append(line + "\n");	
			}
			String result = sb.toString();
			tp.setText(result);
		}catch(IOException ie){
		}finally{
			try{
				if(br != null) br.close();
				if(fr != null) fr.close();
			}catch(IOException ie){}
		}
	}

	void setTNS(){		
		pl1.setLayout(new FlowLayout(FlowLayout.LEFT,20,50));//위에서부터내려와
		pl1.setSize(350,100);
		pl1.setLocation(0,5);
		pl2.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));//위에서부터내려와
		pl2.setSize(350,100);
		pl2.setLocation(0,100);
		label1 = new JLabel("Team Name : ");
		label1.setFont(new Font(pont, Font.PLAIN, 30));
		tf1 = new JTextField(10);
		label2 = new JLabel("Team Score : ");
		label2.setFont(new Font(pont, Font.PLAIN, 30));
		tf2 = new JTextField(10);
		pl1.add(label1);
		pl1.add(tf1);
		pl2.add(label2);
		pl2.add(tf2);
		pl1.setBackground(Color.white);
		pl2.setBackground(Color.white);
		cp.add(pl1);
		cp.add(pl2);
	}

	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
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


