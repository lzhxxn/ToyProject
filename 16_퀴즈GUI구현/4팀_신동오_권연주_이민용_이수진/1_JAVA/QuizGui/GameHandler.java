package four.quiz;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;


class GameHandler implements ActionListener{
	Game g;
	QBack qback;
	int size;
	GameHandler(Game g, QBack qback){
		this.g = g;
		this.qback = qback;
		size = g.vqB.size();
	}
	
	int qBnumber = 0; // �н��ϰų� ���� ���� ī��Ʈ
	
	

	public void actionPerformed(ActionEvent e){			//�迭>>�÷��� #1
		
		Object obj = e.getSource();
		if(obj==g.bM){
			if(g.clip.isRunning()==false){//���� �ȳ�����
				g.clip.start();
				g.bM.setIcon(g.selectedIcon);
			}else if(g.clip.isRunning()==true){
				g.clip.stop();
				g.bM.setIcon(g.normalIcon3);
			
			}
		}

		if(g.vqB.size() == 0){
			System.out.println("RRR");
			//������ �� �������� ���
			//Ÿ�̸ӵ� ���߰�,������ ����ǵ��� �Ѵ�. 
			//������ �÷������� �ٲٸ�, ������ �޶����Ƿ� ����
			if(obj == g.bSB) new Score();
			if(obj == g.bRe){
				//�� �ش��ϴ� �޼���â �����
				System.out.println("������ �� ���������!");
			}
			if(obj == g.bExit) System.exit(-1);
		}

		JButton qbutton = g.vqB.get(qBnumber);
		if(g.timeI == 0){
			
			if(obj == g.bSB){
				new Score();
			}else if(obj == g.bRe){
				new MS();
				g.dispose();						//â ��ü�� ����°�
			}else if(obj == g.bExit){
				System.exit(-1);
			}
		}else if(g.timeI <= g.TIME_START) {
			if(obj == g.bPass){ //pass
				g.pC.remove(qbutton);//��������:��ư�� ������� �гο��� ��������
				g.revalidate();
				qBnumber +=1;
			}else if(obj == qbutton){ //����
				String correct = qbutton.getText();
				//System.out.println(correct);
				int remove = qback.filteredList.indexOf(correct);
				//System.out.println(remove);
				qback.filteredList.remove(remove);
				//System.out.println(qback.filteredList.size());
				
				g.pC.remove(qbutton);						//�гο��� ��������
				g.revalidate();
			//���� ��ư�� ��Ʈ���� ���� ���������� ��Ҹ� �����ؾ��Ѵ�?
				qBnumber +=1;
				g.scoreI +=1;
				g.scoreS = Integer.toString(g.scoreI);
				g.laScore.setText("<html>Score<br>"+g.scoreS+"</html>");
			}
		}
		
	}
}
