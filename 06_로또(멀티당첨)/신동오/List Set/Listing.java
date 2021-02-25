import java.io.*;
import java.util.*;

class Listing{ //명단 읽어오는 객체
	String fname = "우리반.txt";
	BufferedReader br, brFile;
	FileReader fr;
	Vector<String> v = new Vector<String>();

///////////////
	String input() {
		brFile = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("파일명을 입력하세요.(기본'우리반.txt'): ");
		try{
			String file = brFile.readLine();
			if(file != null) file = file.trim();
			if(file.length() != 0) return file;
		}catch(IOException ie){
		}
		return fname;
	}
//////////////

	void readF() throws IOException{ //파일에서 명단읽어서 벡터컬렉션에 저장
		fname = input();
		fr = new FileReader(fname);
		br = new BufferedReader(fr);
		String line = null;
		while((line = br.readLine()) != null) v.add(line);
	}

	void showName(){
		for(String name: v) System.out.println(name);
	}	
}

