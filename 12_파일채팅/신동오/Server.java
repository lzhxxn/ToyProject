import java.io.*;
import java.net.*;

class Server extends Thread{
	ServerSocket ss;
	Socket s;
	int port = 5555;
	String fname = "jdk-15_windows-x64_bin.exe";
	
	BufferedReader brK = new BufferedReader(new InputStreamReader(System.in));
	
	Server(){
		try{
			ss = new ServerSocket(port);
			pln("사용자 접속을 대기중입니다");	
			s = ss.accept();
			pln("사용자가 접속했습니다.");
			start();
			speak();			
		}catch(IOException ie){
		}
	}
	
	void listen(){
		String line = null;
		InputStream is = null;
		DataInputStream dis = null;
		try{
			is = s.getInputStream();
			dis = new DataInputStream(is);
			while(true){
				line = dis.readUTF();
				if(line != null) line = line.trim();
				if(line.equals("#")){
					new TFile(this).start();
				}else{
					pln(line);
				}
			}
		}catch(IOException ie){
		}finally{
			try{
				if(dis!=null) dis.close();
				if(is !=null) is.close();
			}catch(IOException ie){}
		}
	}
	void speak(){
		String line = null;
		OutputStream os = null;
		DataOutputStream dos = null;
		try{
			os = s.getOutputStream();
			dos = new DataOutputStream(os);
			pln("클라이언트와의 대화를 시작합니다");
			while((line = brK.readLine()) != null){
				dos.writeUTF("Server>> "+line);
			}
		}catch(IOException ie){
			pln("클라이언트가 접속을 종료하였습니다");
		}finally{
			try{
				if(dos != null) dos.close();
				if(os != null) os.close();
			}catch(IOException ie){}
		}

	}
	public void run(){
		listen();
	}
	
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}

	public static void main(String[] args){
		new Server();
	}

}