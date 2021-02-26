import java.io.*;
import java.util.*;

class Q{
	TreeSet<String> tempSet = new TreeSet<String>();
	Vector<String> filteredList = new Vector<String>();
	Random r = new Random();
	BufferedReader brKey = new BufferedReader(new InputStreamReader(System.in));
	int teamNum;
	int score;
	QTimer timer;

	void init(){
		readOriginal();
	}
	void readOriginal(){
		FileReader fr = null;
		BufferedReader br = null;
		File f = null;
		String line = "";
		try
		{
			fr = new FileReader(Setting.ORIGINAL);
			br = new BufferedReader(fr);
			while((line = br.readLine()) != null){
				if(line != null) line = line.trim();
				if(line.length() != 0){
					//P.pln(line);
					tempSet.add(line);
				}
			}
			saveStartFile();
		}catch (FileNotFoundException fe){
			P.pln(Setting.ORIGINAL+"파일 없음");
		}catch(IOException ie){
		}finally{
			try
			{
				if(br != null) br.close();
				if(fr != null) fr.close();
			}catch (IOException ie){}
			f = new File(Setting.ORIGINAL);
			f.renameTo(new File(Setting.ORIGINAL_BACK));
		}
	}
	void saveStartFile(){
		FileWriter fw = null;
		PrintWriter pw = null;
		try
		{
			fw = new FileWriter(Setting.FILTERED);
			pw = new PrintWriter(fw, true);
			for(String item: tempSet){
				pw.println(item);
			}
			P.pln(Setting.FILTERED+"에 저장 완료");
		}catch (IOException ie){
		}finally{
			try
			{
				if(pw != null) pw.close();
				if(fw != null) fw.close();
			}catch (IOException ie){
			}
		}
	}
	void start(){
		FileReader fr = null;
		BufferedReader br = null;
		String line = null;
		try
		{
			fr = new FileReader(Setting.FILTERED);
			br = new BufferedReader(fr);
			while((line = br.readLine()) != null){
				if(line != null) line = line.trim();
				if(line.length() != 0){
					filteredList.add(line);
				}
			}
			inputTeamNum();
		}catch (FileNotFoundException fe){
		}catch(IOException ie){
		}
	}
	void inputTeamNum(){
		P.p("팀번호: ");
		try
		{
			String line = brKey.readLine();
			if(line != null) line = line.trim();
			teamNum = Integer.parseInt(line);

			timer = new QTimer(this);
			timer.start();

			showQ();
		}catch (IOException ie){
		}catch(NumberFormatException ne){
			inputTeamNum();
		}
	}
	void showQ() throws IOException{
		while(true){
			int size = filteredList.size();
			if(size>0){
				int i = r.nextInt(size);
				P.pln(filteredList.get(i));
				String line = brKey.readLine();
				if(line != null) line = line.trim();
				if(line.equalsIgnoreCase("O")){
					score++;
					filteredList.remove(i);
				}
			}else{
				P.pln("문제 끝");
				//timer.recordScore();
				timer.saveFilteredList();
				System.exit(-1);
			}
		}
	}
	public static void main(String[] args){
		Q q = new Q();
		q.init();
		q.start();
	}
	
}
