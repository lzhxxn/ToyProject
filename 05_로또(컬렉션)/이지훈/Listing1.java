import java.io.*;
import java.util.*;

class Listing { //��� �о���� ��ü
	String fname = "�츮��.txt";
	BufferedReader br; // file ����
	FileReader fr;
	Vector<String>  v = new Vector<String>();

	void readF() throws IOException{ //���Ͽ��� ��� �о ���� �÷��ǿ� ����
		fr = new FileReader(fname);
		br = new BufferedReader(fr);
		String line = null;

		while((line = br.readLine()) != null) v.add(line);
	}
	void showNames(){
		for(String name: v) System.out.println(name);
	}
}