import java.io.*;
import java.net.*;

class Client extends Thread{
	Socket s;
	String ip = "192.168.0.133";
	int port = 5555;
	String fname = "C:\\SDO\\Download\\jdk-15_windows-x64_bin.exe";
	
	BufferedReader brK = new BufferedReader(new InputStreamReader(System.in));
	
	Client(){
		try{
			s = new Socket(ip, port);
			start();
			speak();
			//send();
		}catch(UnknownHostException uhe){
			pln("목표한 주소를 찾을 수 없습니다");
		}catch(IOException ie){
			pln("목표한 주소를 찾을 수 없습니다");
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
				pln(line);
			}
		}catch(IOException ie){
			pln("서버가 종료되었습니다");
		}finally{
			try{
				if(dis != null) dis.close();
				if(is != null) is.close();
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
			pln("서버와의 대화를 시작합니다");
			while( (line = brK.readLine()) != null){
				if(line != null) line = line.trim();
				String[] p = line.split(":");
				if(p[0].equals("file")){
					dos.writeUTF("#");
					new TFile(this).start();
				}else{
					dos.writeUTF("Client>> "+line);
					dos.flush();
				}
			}
		}catch(IOException ie){
		}finally{
			try{
				if( dos != null) dos.close();
				if( os != null) os.close();
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
		new Client();
	}


}
