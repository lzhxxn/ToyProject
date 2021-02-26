import java.io.*;
import java.util.*;

class Q{
	

	TreeSet<String> startSet = new TreeSet<String>();

	void readOriginal() throws IOException{
		FileReader fr = null;
		BufferedReader br = null;
		File f =null;
		String line = "";
		try{
			fr = new FileReader(Setting.ORIGINAL);
			br = new BufferedReader(fr);
			while( (line = br.readLine()) != null){
				if(line != null) line = line.trim();
				if(line.length() !=0){
					System.out.println(line);
					startSet.add(line);
				}
			}

			saveStartFile();
		}catch(FileNotFoundException fe){
			System.out.println("Can't find file "+Setting.ORIGINAL);

		}finally{
			if(br != null) br.close();
			if(fr != null) fr.close();
			
			f = new File(Setting.ORIGINAL);
			f.renameTo(new File(Setting.ORIGINAL_BACK));
		}
	}
	
	void saveStartFile() throws IOException{
		FileWriter fw = null;
		PrintWriter pw = null;
		
		fw = new FileWriter(Setting.START);
		pw = new PrintWriter(fw, true);
		for(String item: startSet) pw.println(item);
		System.out.println("save the list in "+ Setting.START);

	}
	
	public static void main(String[] args) throws IOException{
		Q q = new Q();
		q.readOriginal();
	}


}
