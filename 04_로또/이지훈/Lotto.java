import java.io.*;
import java.util.Random;

class Listing {
	String fname = "우리반.txt";
	BufferedReader br;
	FileReader fr;
	String names[] = new String[20];
	Random r = new Random();

	void readF() throws IOException {
		fr = new FileReader(fname);
		br = new BufferedReader(fr);
		String line = null;
		int i = 0; 
		while((line = br.readLine()) != null){
			names[i++] = line;
		}
		//System.out.println("배열에 이름 옮기기 완료!");
	}
	void showNum(){
		int n = 20;
		int j = r.nextInt(n);
		int i = r.nextInt(n); //0 ~ (n-1)	
		System.out.println("names["+i+"]: " + names[i]);
		System.out.println("names["+j+"]: " + names[j]);
	}
	
	public static void main(String[] args) throws IOException {
		Listing list = new Listing();
		list.readF();
		list.showNum();
	}
}
