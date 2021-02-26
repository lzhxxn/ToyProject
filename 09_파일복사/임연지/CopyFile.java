import java.io.*;

class CopyFile {
	BufferedReader brkey = new BufferedReader(new InputStreamReader(System.in));
	FileInputStream fis;
	BufferedInputStream bis;
	FileOutputStream fos;
	BufferedOutputStream bos;
	File f;

	CopyFile(){
		getSelect();
	}

	void getSelect(){// inadd구하기
		P.p("  >  1 : 파일복사   /   2 : 파일잘라내기 : ");
		try{
			String line = brkey.readLine();
			if(line!=null) line.trim();
			int select = Integer.parseInt(line);
			if(select==1){
				copy();
			}else if(select==2){
				cut();
			}else {
				P.pln("1, 2 중에서 입력해주세요.");
				getSelect();
			}
		}catch(IOException ie){
		}
	}

	void copy(){
		selectFile();
		P.pln("파일 복사 완료!");
	}

	void cut(){
		selectFile();
		f.delete();
		P.pln("파일 잘라내기 완료!");
	}
	void selectFile(){ //
		String inAdd="";
		P.p(" 복사할 파일을 드래그해주세요. ");
		try{
			inAdd = brkey.readLine();
			getName(inAdd);
		}catch(IOException ie){ }
	}

	void getName(String inAdd){// 파일'이름만' 구하기.
		String fname="";
		int idx = inAdd.lastIndexOf("\\");
		String addfile = inAdd;
		fname = inAdd.substring(idx+1);
		P.pln("파일이름 : "+fname);
		copyAndWrite(inAdd, fname);
	}

	void copyAndWrite(String inAdd, String fname){
		String outAdd="";
		P.p("파일을 복사할 위치를 알려주세요. : ");
		try{
			outAdd = brkey.readLine();
			fis = new FileInputStream(inAdd);
			bis = new BufferedInputStream(fis, 2048);
			fos = new FileOutputStream(outAdd+"\\"+fname);
			bos = new BufferedOutputStream(fos, 2048);
			f = new File(inAdd); 

			byte bs[] = new byte[512];
			int file = 0;
			while((file=bis.read(bs))!=-1){
				bos.write(bs,0,file);
			}
			bos.flush();
		}catch(FileNotFoundException fe){
			selectFile();
		}catch(IOException ie){
		}finally{
			try{
				if(bis!=null) bis.close();
				if(bos!=null) bos.close();
				if(fis!=null) fis.close();
				if(fos!=null) fos.close();
			}catch(IOException ie){}
		}
	}

	public static void main(String[] args){
		CopyFile cf = new CopyFile();
	}
}