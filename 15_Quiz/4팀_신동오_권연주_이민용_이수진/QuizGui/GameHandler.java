import java.awt.event.*;
import javax.swing.*;

class GameHandler implements ActionListener{
	Game g;
	GameHandler(Game g){
		this.g = g;
	}
	
	int qBnumber = 0; // �н��ϰų� ���� ���� ī��Ʈ
	public void actionPerformed(ActionEvent e){			//�迭>>�÷��� #1
		Object obj = e.getSource();
		//System.out.println(qBnumber);
		if(qBnumber == 20){
			//������ �� �������� ���
			//Ÿ�̸ӵ� ���߰�,������ ����ǵ��� �Ѵ�. 
			//������ �÷������� �ٲٸ�, ������ �޶����Ƿ� ����
			if(obj == g.bSB & g.timeI ==0) new Score();
			if(obj == g.bRe & g.timeI ==0){
				new MS();
				g.dispose();
			}
			if(obj == g.bExit & g.timeI ==0) System.exit(-1);
		}else if(obj == g.bSB & g.timeI ==0){
			new Score();
		}else if(obj == g.bPass & g.timeI != 0){ //pass
			g.pC.remove(g.qB[qBnumber]);//��������:��ư�� ������� �гο��� ��������
			g.revalidate();
			qBnumber +=1;
		}else if(obj == g.bRe & g.timeI ==0){
			new MS();
			g.dispose();						//â ��ü�� ����°�
		}else if(obj == g.bExit & g.timeI ==0){
			System.exit(-1);
		}else if(obj == g.qB[qBnumber] & g.timeI!=0){ //����
			g.pC.remove(g.qB[qBnumber]);						//�гο��� ��������
			g.revalidate();
			qBnumber +=1;
			g.scoreI +=1;
			g.scoreS = Integer.toString(g.scoreI);
			g.laScore.setText("<html>Score<br>"+g.scoreS+"</html>");
		}
	}
}
