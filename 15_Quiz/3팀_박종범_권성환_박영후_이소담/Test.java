import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

class  Test extends JFrame //implements ActionListener
{
   Container cp;
   ImagePanel imgP; //Public class ����
   String teamName;
   Color b = new Color(0xFFFFFF); // bg �÷� �߰�

   Test(){
	  teamName = JOptionPane.showInputDialog("�� �̸��� �Է����ּ���~"); //OK��ư Ŭ���� �Է�â�� �Է��� ���� teamNum�� ���ϵ�, cancle�̳� â�� ���� Null
	  imgP = new ImagePanel(this); // ȣ��
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
	  // SetBounds(x,y,��,����)
	  
	  //imgP.b1.setBounds(30,2,150,60); //���ھ��
	  //imgP.b2.setBounds(570,10,50,45); //�������
	  //imgP.b3.setBounds(320,5,45,45); //�𷡽ð�
	  //imgP.b4.setBounds(25,310,150,50); //�����̹�ư
	  //imgP.b5.setBounds(520,310,150,50); //Pass
	  
		

	  imgP.b1.setBounds(10,0,100,60); //���ھ��
	  imgP.b2.setBounds(620,0,50,45); //�������
	  imgP.b3.setBounds(320,0,45,45); //�𷡽ð�
	  imgP.b4.setBounds(30,280,65,65); //�����̹�ư
	  imgP.b5.setBounds(545,280,150,65); //Pass


	  imgP.quiz.setBounds(50,135,600,100);//���� �۾� ��ġ
      setTitle("Team 3 Quiz Contest");
      setSize(700,400);
      //pack();
      setVisible(true);
      //setLocation(200, 100);
      setLocationRelativeTo(null);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  getContentPane().setBackground(b); // bg �÷� �߰�
   }
   public static void main(String[] args) 
   {
      Test t = new Test();
   }
}