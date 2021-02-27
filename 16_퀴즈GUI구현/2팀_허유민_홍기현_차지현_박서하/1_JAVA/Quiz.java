import java.io.*;
import java.util.*;

class Quiz{
	StartBtn1 sb1;
	Random r = new Random();

	Quiz(StartBtn1 sb1){
		this.sb1 = sb1;
		setQ();
	}

	void setQ(){
		try{
			FileReader fr;
			BufferedReader fbr;
			String line = "";
			fr = new FileReader("./quiz.txt");
			fbr = new BufferedReader(fr);
			while((line = fbr.readLine()) != null){
				if(line!=null) line = line.trim();
				if(line.length()!=0){
					sb1.Qlist.add(line);
				}
			}
			sb1.Qnum = r.nextInt(sb1.Qlist.size());

		}catch(FileNotFoundException ie){
			pln("퀴즈 목록이 존재하지 않아요.");
		}catch(IOException ie){
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
}
