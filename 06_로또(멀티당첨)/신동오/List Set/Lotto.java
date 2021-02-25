import java.io.*;
import java.util.*;

class Lotto{
	public static void main(String[] args) throws IOException
	{
		Listing list = new Listing();			//명단을 읽어 List컬렉션에 입력
		list.readF();
		int listNum = list.v.size();
		//list.showName();

		RanNum rn = new RanNum();				
		int totalNum = rn.input(listNum);		//뽑을 인원 설정
		rn.pickNum(totalNum, listNum);			//설정한 수만큼 랜덤숫자 뽑기, Set컬렉션에 저장.
		//rn.showNum();

		Iterator<Integer> iter = rn.tr.iterator();
		int i=-1;
		while(iter.hasNext()){					//Set컬렉션에 저장된 랜덤넘버를 List컬렉션 인덱스로 넣어 뽑힌 이름을 출력
			i = iter.next();
			String pickedName = list.v.get(i);
			System.out.println("  -"+(i+1) +": "+ pickedName);
		}
	}
}
