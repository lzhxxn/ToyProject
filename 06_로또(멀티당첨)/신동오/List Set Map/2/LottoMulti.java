import java.io.*;
import java.util.*;

//에러처리 없이 
class LottoMulti
{
	String fname = "우리반.txt";
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	FileReader fr;
	BufferedReader brFile;

	void readPath(){
		System.out.print("List file: ");
		try{
			String path = br.readLine();
			if(path != null) path = path.trim();
			if(path.length() != 0){
				fname = path;
			}
			fr = new FileReader(fname);
			brFile = new BufferedReader(fr);
			readFile();
		}catch(FileNotFoundException fe){
			System.out.println("file not existing");
			readPath();
		}catch(IOException ie){
			readPath();
		}
	}

	Hashtable<Integer,String> map = new Hashtable<Integer,String>();
	void readFile() throws IOException{
		int count =0;
		String line ="";
		while((line = brFile.readLine()) != null){
			map.put(count++, line);
		}
	}

	void showMap(){
		Enumeration<Integer> e = map.keys();
		while(e.hasMoreElements()){
			Integer key = e.nextElement();
			System.out.println(key+"  "+ map.get(key));
		}
	}

	Vector<Integer> v = new Vector<Integer>();
	void moveKey(){
		Enumeration<Integer> e = map.keys();
		while(e.hasMoreElements()){
			v.add(e.nextElement());
		}
	}
	
	Random r = new Random();
	TreeSet<Integer> set = new TreeSet<Integer>();

	void select(){
		int i = r.nextInt(v.size());
		int winnerKey = v.get(i);
		v.remove(i);
		set.add(winnerKey);
	}

	void showWinner(){
		Iterator<Integer> winnerKeys = set.iterator();
		while(winnerKeys.hasNext()){
			int winnerKey = winnerKeys.next();
			System.out.println(winnerKey+ " " + map.get(winnerKey));
		}
	}
	void winner() throws IOException{
		String winnerNumStr = "";
		System.out.print("the number of winner: ");
		try{
			winnerNumStr = br.readLine();
			winnerNumStr = winnerNumStr.trim();
			int winnerNum = Integer.parseInt(winnerNumStr);
			if(winnerNum<1 || winnerNum >20){
				System.out.println("Out of Range(1~20)");
				winner();
			}else{
				moveKey();
				for(int i=0; i<winnerNum; i++) select();
				showWinner();
			}
		}catch(NumberFormatException ne){
			winner();
		}
	}


	public static void main(String[] args) throws IOException{
		LottoMulti lm = new LottoMulti();
		lm.readPath();
		//lm.showMap();
		//lm.moveKey();
		//for(Integer i: lm.v) System.out.println(i);

		lm.winner();
	}
}
