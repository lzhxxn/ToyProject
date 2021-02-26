import java.io.*;
import java.util.*;

class Winner {
	BufferedReader brFile;
	File dir = new File(Setting.dirScore);
	Hashtable<String, Integer> scoreMap = new Hashtable<String, Integer>();

    void showFileList() throws IOException {
		String childs[] = dir.list();
		for(String child: childs){
			brFile = new BufferedReader(new FileReader(Setting.dirScore+"/"+child));
			
			String line = null;
			int sum = 0;
			while((line = brFile.readLine()) != null){		
				//P.pln("ÆÀ¹øÈ£ÆÄÀÏ: " + child + ", Á¡¼ö: " + line);
				if(line != null) line = line.trim();
				if(line.length() != 0){
					int jumsu = Integer.parseInt(line);
					sum = sum + jumsu;
				}
			}
			scoreMap.put(getChildNoExt(child), sum);
			//P.pln("ÆÀ¹øÈ£ÆÄÀÏ: " + child + ", ÃÑÁ¡: " + sum);

			brFile.close();
		}

		showResult();
	}
	String getChildNoExt(String child){
		int idx = child.lastIndexOf(".");
	
		return child.substring(0, idx); 
	}
	void showResult(){
		Set<String> keys = scoreMap.keySet();
		for(String key: keys){
			P.pln(key + "ÆÀ>> ÃÑÁ¡: " + scoreMap.get(key));
		}
	}
	public static void main(String[] args) throws IOException {
		Winner w = new Winner();
		w.showFileList();
	}
}
