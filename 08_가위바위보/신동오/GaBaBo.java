import java.io.*;
import java.util.*;


class GaBaBo{
	BufferedReader brKey = new BufferedReader(new InputStreamReader(System.in));
	Random r = new Random();

	int com;
	int human;
	int comWin=0; int hWin=0;
	
	void inputGN(){ //플레이 수 입력받기
		int gameN = 0;
		System.out.print("플레이할 게임수를 입력하세요!: ");
		try{
			String line = brKey.readLine();
			if(line != null) line = line.trim();
			if(line.length() != 0) gameN = Integer.parseInt(line);
			if(gameN % 2 ==0){
				System.out.println("승부는 가려야죠, 홀수를 입력하세요!");
				inputGN();
			}
		
			playGame(gameN);			
		}catch(IOException ie){
		}catch(NumberFormatException ne){
			System.out.println("숫자를 입력하세요");
			inputGN();
		}
		//System.out.println(gameN); //판 수 확인
	}

	void playGame(int gameN){  // 승부가 결정날 때까지 반복한다
		final int W = (gameN/2) +1;
		do{						// 한판먼저!
			start();
			if( hWin == W ){
				System.out.println("스코어  "+hWin+" : "+comWin);
				System.out.println("YOU WIN");
				System.exit(0);
			}else if( comWin == W ) {
				System.out.println("스코어  "+hWin+" : "+comWin);
				System.out.println("YOU LOSE");
				System.exit(0);
			}
		}while(hWin!=W & comWin!=W);
	}
	

	void start(){ // 가위바위보 한판
		ready();
		game(human, com);
	}

	void ready(){ // 뭐 낼지 생각하기 (1)
		com = r.nextInt(3); //값저장

		String h = " ";
		System.out.print("가위바위보!: ");
		try{
			String line = brKey.readLine(); //사람한테입력받음
			if(line != null) line = line.trim();
			if(line.length() != 0) h = line;
			switch(h){ //스위치케이스문
			case "가위": human = 0; break;
			case "바위": human =1; break;
			case "보": human =2; break;
			default : System.out.println("가위바위보 중 하나를 입력하세요"); ready();
			}//디폴트로가게해서 다른거를내면 재실행.
		}catch(IOException ie){}
		//System.out.println(human+ " " + com); //승무패 확인
	}
	
	void game(int h, int c){ // 승부결정  (2)
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
	}		 //ready~game 한판 승부내기.

	public static void main(String[] args){
		GaBaBo a = new GaBaBo();		
		a.inputGN();
		//a.start(); //승무패확인
	}


	
}