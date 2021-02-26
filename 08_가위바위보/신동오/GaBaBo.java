import java.io.*;
import java.util.*;


class GaBaBo{
	BufferedReader brKey = new BufferedReader(new InputStreamReader(System.in));
	Random r = new Random();

	int com;
	int human;
	int comWin=0; int hWin=0;
	
	void inputGN(){ //�÷��� �� �Է¹ޱ�
		int gameN = 0;
		System.out.print("�÷����� ���Ӽ��� �Է��ϼ���!: ");
		try{
			String line = brKey.readLine();
			if(line != null) line = line.trim();
			if(line.length() != 0) gameN = Integer.parseInt(line);
			if(gameN % 2 ==0){
				System.out.println("�ºδ� ��������, Ȧ���� �Է��ϼ���!");
				inputGN();
			}
		
			playGame(gameN);			
		}catch(IOException ie){
		}catch(NumberFormatException ne){
			System.out.println("���ڸ� �Է��ϼ���");
			inputGN();
		}
		//System.out.println(gameN); //�� �� Ȯ��
	}

	void playGame(int gameN){  // �ºΰ� ������ ������ �ݺ��Ѵ�
		final int W = (gameN/2) +1;
		do{						// ���Ǹ���!
			start();
			if( hWin == W ){
				System.out.println("���ھ�  "+hWin+" : "+comWin);
				System.out.println("YOU WIN");
				System.exit(0);
			}else if( comWin == W ) {
				System.out.println("���ھ�  "+hWin+" : "+comWin);
				System.out.println("YOU LOSE");
				System.exit(0);
			}
		}while(hWin!=W & comWin!=W);
	}
	

	void start(){ // ���������� ����
		ready();
		game(human, com);
	}

	void ready(){ // �� ���� �����ϱ� (1)
		com = r.nextInt(3); //������

		String h = " ";
		System.out.print("����������!: ");
		try{
			String line = brKey.readLine(); //��������Է¹���
			if(line != null) line = line.trim();
			if(line.length() != 0) h = line;
			switch(h){ //����ġ���̽���
			case "����": human = 0; break;
			case "����": human =1; break;
			case "��": human =2; break;
			default : System.out.println("���������� �� �ϳ��� �Է��ϼ���"); ready();
			}//����Ʈ�ΰ����ؼ� �ٸ��Ÿ����� �����.
		}catch(IOException ie){}
		//System.out.println(human+ " " + com); //�¹��� Ȯ��
	}
	
	void game(int h, int c){ // �ºΰ���  (2)
		if(h==0 && c==2){
			System.out.println("Win");
			hWin++;
		}else if(h==2 && c==0){
			System.out.println("Lose");
			comWin++;
		}else if(h<c){
			System.out.println("Lose");
			comWin++;
		}else if(h>c){
			System.out.println("Win");
			hWin++;
		}else if(h==c){
			System.out.println("draw");
		}
	}		 //ready~game ���� �ºγ���.

	public static void main(String[] args){
		GaBaBo a = new GaBaBo();		
		a.inputGN();
		//a.start(); //�¹���Ȯ��
	}


	
}