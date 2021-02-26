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
		P.p("    ( 기본 3회 ) 원하는 게임 횟수를 입력하세요. : ");
		try{
			input = brkey.readLine();
		}catch(IOException ie){ }
		if(input != null) input = input.trim();
		if(input.length() == 0){
			P.p("다시 입력해주세요.");
			getGameNum(); 
		}
		try{
			gNum = Integer.parseInt(input);
			repeatGame();
		}catch(NumberFormatException ne){
			P.pln("< 잘못된 입력 > 원하는 게임 횟수를 숫자로 입력해주세요.");
			getGameNum();
		}finally{
			try{
			 if(brkey != null) brkey.close();
			 }catch(IOException ie){ }
		}
	}
	void play(){
		String users = "";
		P.p("    (선택해주세요)   가위  /  바위  /  보   : ");
		try{
			users = brkey.readLine();
			if(users != null) users = users.trim();
			if(users.length()==0) play();
			if(users.equals("가위")){
				user = 0; result();
			}
			else if(users.equals("바위")){
				user = 1; result();
			}
			else if(users.equals("보")){
				user = 2; result();
			}
			else play();
		}catch(IOException ie){ }
	}
	void result(){
		int com = r.nextInt(3);
		if( (user==0 && com==2) || (user==1 && com==0) || (user==2 && com==1) ){
			P.pln("        >> 결과 :  축하합니다! 이겼습니다!"); 
			winN++;
		} else if ( (user==0 && com==1) || (user==1 && com==2) || (user==2 && com==0) ) {
			P.pln("         >> 결과 :  아쉽네요! 졌습니다.."); 
			loseN++;
		} else if ( user == com ) {
			P.pln("         >> 결과 :  비겼네요! 한 번 더 해볼까요?"); 
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
		P.pln("      ----------     게임이 끝났습니다.    ----------");
		P.pln("");
		P.pln("  > > >     총  "+g.gNum+" 번의 게임 중, "+g.winN+" 번 이기고, "+g.loseN+" 번 졌습니다.");
		if(((g.winN/g.gNum)*100)>80) P.pln("  > > >   축하합니다. 당신은 오늘부터 가위바위보의 신입니다.");
	}
}