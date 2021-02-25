import java.util.*;
import java.io.*;

class RanNum //정해준 수만큼 랜덤숫자 뽑는 객체
{
	//뽑을 숫자 개수 입력
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int input(int listNum) throws IOException{				//뽑을 인원 설정 메소드
		System.out.print("당첨자 수를 입력하세요: ");
		try{
			String line = br.readLine();
			line = line.trim();
			int i = Integer.parseInt(line);
			if(i<1 || i> listNum){
				System.out.println("범위값을 벗어났어요, 다시 입력하세요");
				return input(listNum);
			}
			return i;
		}catch(NumberFormatException ne){
			System.out.println("잘못 입력했어요, 다시 입력하세요");
		}
		return input(listNum);
	}

	//랜덤 숫자 뽑기
	Random r = new Random();
	TreeSet<Integer> tr = new TreeSet<Integer>();

	void pickNum(int totalNum, int listNum){		 //Set컬렉션에 데이터입력, 정해준 숫자만큼. 중복제거
		while(tr.size()<totalNum) tr.add(r.nextInt(listNum));
	}

	void showNum(){									//컬렉션에 저장된 숫자 확인
		for(Integer pickedNum: tr) System.out.println(pickedNum);
	}

}