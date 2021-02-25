import java.io.*;
import java.util.*;

class Listing { //명단 읽어오는 객체
	String fname = "우리반.txt";
	BufferedReader br; // file 연결
	FileReader fr;
	Vector<String>  v = new Vector<String>();

	void readF() throws IOException{ //파일에서 명단 읽어서 벡터 컬렉션에 저장
		fr = new FileReader(fname);
		br = new BufferedReader(fr);
		String line = null;

		while((line = br.readLine()) != null) v.add(line);
	}
	void showNames(){
		for(String name: v) System.out.println(name);
	}
}