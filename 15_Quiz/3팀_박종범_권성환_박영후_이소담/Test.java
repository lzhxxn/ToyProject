import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

class  Test extends JFrame //implements ActionListener
{
   Container cp;
   ImagePanel imgP; //Public class 선언
   String teamName;
   Color b = new Color(0xFFFFFF); // bg 컬러 추가

   Test(){
	  teamName = JOptionPane.showInputDialog("팀 이름을 입력해주세요~"); //OK버튼 클릭시 입력창에 입력한 값이 teamNum에 리턴됨, cancle이나 창을 끄면 Null
	  imgP = new ImagePanel(this); // 호출
      init();
   }
   void init(){
      setButton();
      setUI();
   }
   void setButton(){    
      cp = getContentPane();
	  cp.add(imgP);
           
   }
   void setUI(){
	  // SetBounds(x,y,폭,높이)
	  
	  //imgP.b1.setBounds(30,2,150,60); //스코어보드
	  //imgP.b2.setBounds(570,10,50,45); //음악재생
	  //imgP.b3.setBounds(320,5,45,45); //모래시계
	  //imgP.b4.setBounds(25,310,150,50); //오케이버튼
	  //imgP.b5.setBounds(520,310,150,50); //Pass
	  
		

	  imgP.b1.setBounds(10,0,100,60); //스코어보드
	  imgP.b2.setBounds(620,0,50,45); //음악재생
	  imgP.b3.setBounds(320,0,45,45); //모래시계
	  imgP.b4.setBounds(30,280,65,65); //오케이버튼
	  imgP.b5.setBounds(545,280,150,65); //Pass


	  imgP.quiz.setBounds(50,135,600,100);//퀴즈 글씨 위치
      setTitle("Team 3 Quiz Contest");
      setSize(700,400);
      //pack();
      setVisible(true);
      //setLocation(200, 100);
      setLocationRelativeTo(null);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  getContentPane().setBackground(b); // bg 컬러 추가
   }
   public static void main(String[] args) 
   {
      Test t = new Test();
   }
}