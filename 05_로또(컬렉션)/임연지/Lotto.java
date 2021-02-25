import java.io.*;
import java.util.*; 


class Lotto {
	Vector<String> v = new Vector<String>();
	String fname = "우리반.txt";
	BufferedReader br;
	BufferedReader brKey = new BufferedReader(new InputStreamReader(System.in));
	FileReader fr;
	Random r = new Random();
	int count;

	Lotto() throws IOException { 
		System.out.print("뽑을 인원 : ");
		String countStr = br.key.readLine();
		if(countStr != null) countStr = countStr.trim();
		count = Integer.parseInt(countStr);

		fr = new FileReader (fname);
		br = new BufferedReader(fr);
		String line = null;

		while((line = br.readLine()) != null){
			String str =  line;
			v.add(line);
		}
	}

	void showNames(){
		int n1 = r.nextInt(v.size());
		String item = v.get(n1);
		System.out.println("발표자 : "+v.get(n1));
		v.remove(n1);
	}

	public static void main(String[] args) throws IOException {
		Lotto list = new Lotto();
		System.out.println("< 당첨자 >");
		for(int i=0; i<list.count; i++){
			list.showNames();
		}
	}
}