import java.io.*;
import java.util.*;

class Listing{ //��� �о���� ��ü
	String fname = "�츮��.txt";
	BufferedReader br, brFile;
	FileReader fr;
	Vector<String> v = new Vector<String>();

///////////////
	String input() {
		brFile = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("���ϸ��� �Է��ϼ���.(�⺻'�츮��.txt'): ");
		try{
			String file = brFile.readLine();
			if(file != null) file = file.trim();
			if(file.length() != 0) return file;
		}catch(IOException ie){
		}
		return fname;
	}
//////////////

	void readF() throws IOException{ //���Ͽ��� ����о �����÷��ǿ� ����
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

