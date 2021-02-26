import java.io.*;
import java.util.*;

class Tip 
{
	BufferedReader brKey = new BufferedReader(new InputStreamReader(System.in));
	void input(){
		System.out.print("복사할파일: ");
		String path = "";
		try{
			path = brKey.readLine();
			m1(path);
			//m2(path);
		}catch(IOException ie){}
	}
	void m1(String path){
		int idx = path.lastIndexOf("\\");
		String fname = path.substring(idx+1);

		pln("파일이름: " +fname);
	}
	void m2(String path){
		StringTokenizer st = new StringTokenizer(path, "\\");
		String token = "";
		while(st.hasMoreTokens()) token = st.nextToken();	

		pln("파일이름: " + token);
	}
	void p(String str){
		System.out.print(str);
	}
    void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		Tip t = new Tip();
		t.input();
	}
}
