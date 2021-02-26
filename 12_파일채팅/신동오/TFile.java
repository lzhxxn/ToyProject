import java.io.*;
import java.net.*;

class TFile extends Thread{
	Client cli;
	Server ser;
	int logic;
	TFile(Server ser){
		this.ser = ser;
		logic = 1;
	}
	TFile(Client cli){
		//pln("#####");
		this.cli = cli;
	}
	
	void recieveF(ServerSocket ss, String fname){
		//여기서 스트림을 만들고 파일전송 후 닫아준다
		//서버소켓.어셉트()
		Socket sf = null;
		InputStream is = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try{
			sf = ss.accept();
			is = sf.getInputStream();
			bis = new BufferedInputStream(is, 4096);
			fos = new FileOutputStream(fname);
			bos = new BufferedOutputStream(fos, 4096);
			byte bs[] = new byte[1024];
			int i = 0;
			long total = 0L;
			while( (i=bis.read(bs)) != -1){
				bos.write(bs,0,i);
				//pln("받는 중..."+ ( total+=i ) + "bytes");
			}
			bos.flush();
			pln("파일전송이 완료되었습니다"); //프린팅이 안돼
		}catch(IOException ie){
		}finally{
			try{
				bis.close();
				is.close();
				bos.close();
				fos.close();
				sf.close();
				ss.close();
			}catch(IOException ie){}
		}
	}
	public void run(){
		if(logic == 1){
			recieveF(ser.ss, ser.fname);
		}else{
			send(cli.ip, cli.port, cli.fname);
		}
	}
	void send(String ip, int port, String fname){
		Socket sf = null;
		OutputStream os =null;
		BufferedOutputStream bos = null;
		FileInputStream fis = null;
		BufferedInputStream bis =null;
		try{
			//pln(ip+" "+port);
			sf = new Socket(ip, port);
			os = sf.getOutputStream();
			bos = new BufferedOutputStream(os, 4096);
			fis = new FileInputStream(fname);
			bis = new BufferedInputStream(fis, 4096);
			byte[] bs = new byte[1024];
			int i = 0;
			long total = 0L;
			while( (i = bis.read(bs)) != -1){
				bos.write(bs,0,i);
				//pln("전송 중..."+ ( total+=i ) + "bytes");
			}
			bos.flush();
			pln("파일전송이 완료되었습니다");
		}catch(FileNotFoundException fne){
		}catch(IOException ie){
			try{
				if(bis!=null) bis.close();
				if(fis!=null) fis.close();
				if(bos!=null) bos.close();
				if(os!=null) os.close();
				if(sf !=null) sf.close();
			}catch(IOException iie){}
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
}