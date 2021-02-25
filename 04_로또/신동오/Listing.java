import java.io.*;

class Listing {
	String fname = "우리반.txt";
	BufferedReader br;
	FileReader fr;
	String names[] = new String[20];

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
	void showNames(){
        for(int i=0; i<names.length; i++){
			System.out.println("names["+i+"]: " + names[i]); 
		}
	}
}
