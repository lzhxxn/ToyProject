import java.io.*;
import java.util.*;

class Gababo {
	BufferedReader brkey = new BufferedReader(new InputStreamReader(System.in));
	Random r = new Random();
	int gNum, winN, loseN, user;
	Gababo(){
		getGameNum();
	}
	void getGameNum(){
		String input = "";
		P.p("    ( �⺻ 3ȸ ) ���ϴ� ���� Ƚ���� �Է��ϼ���. : ");
		try{
			input = brkey.readLine();
		}catch(IOException ie){ }
		if(input != null) input = input.trim();
		if(input.length() == 0){
			P.p("�ٽ� �Է����ּ���.");
			getGameNum(); 
		}
		try{
			gNum = Integer.parseInt(input);
			repeatGame();
		}catch(NumberFormatException ne){
			P.pln("< �߸��� �Է� > ���ϴ� ���� Ƚ���� ���ڷ� �Է����ּ���.");
			getGameNum();
		}finally{
			try{
			 if(brkey != null) brkey.close();
			 }catch(IOException ie){ }
		}
	}
	void play(){
		String users = "";
		P.p("    (�������ּ���)   ����  /  ����  /  ��   : ");
		try{
			users = brkey.readLine();
			if(users != null) users = users.trim();
			if(users.length()==0) play();
			if(users.equals("����")){
				user = 0; result();
			}
			else if(users.equals("����")){
				user = 1; result();
			}
			else if(users.equals("��")){
				user = 2; result();
			}
			else play();
		}catch(IOException ie){ }
	}
	void result(){
		int com = r.nextInt(3);
		if( (user==0 && com==2) || (user==1 && com==0) || (user==2 && com==1) ){
			P.pln("        >> ��� :  �����մϴ�! �̰���ϴ�!"); 
			winN++;
		} else if ( (user==0 && com==1) || (user==1 && com==2) || (user==2 && com==0) ) {
			P.pln("         >> ��� :  �ƽ��׿�! �����ϴ�.."); 
			loseN++;
		} else if ( user == com ) {
			P.pln("         >> ��� :  ���׿�! �� �� �� �غ����?"); 
			play();
		}
	}
	void repeatGame(){
		for(int i=0; i<gNum; i++) {
			play();
		}
	}
	public static void main(String[] args){
		Gababo g = new Gababo();
		P.pln("");
		P.pln("      ----------     ������ �������ϴ�.    ----------");
		P.pln("");
		P.pln("  > > >     ��  "+g.gNum+" ���� ���� ��, "+g.winN+" �� �̱��, "+g.loseN+" �� �����ϴ�.");
		if(((g.winN/g.gNum)*100)>80) P.pln("  > > >   �����մϴ�. ����� ���ú��� ������������ ���Դϴ�.");
	}
}