import java.util.*;
import java.io.*;

class Listing{
	String fname = "¿ì¸®¹Ý.txt";
	BufferedReader br;
	FileReader fr;
	Vector<String> v = new Vector<String>();

	void readF() throws IOException {
		fr = new FileReader(fname);
		br = new BufferedReader(fr);
		String line = null;
		
		while((line = br.readLine()) != null) v.add(line);
	}

	void showNames(){
		for(String name: v) System.out.println(name);
	}
}
