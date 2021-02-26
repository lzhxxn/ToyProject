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

	void getSelect(){// inadd���ϱ�
		P.p("  >  1 : ���Ϻ���   /   2 : �����߶󳻱� : ");
		try{
			String line = brkey.readLine();
			if(line!=null) line.trim();
			int select = Integer.parseInt(line);
			if(select==1){
				copy();
			}else if(select==2){
				cut();
			}else {
				P.pln("1, 2 �߿��� �Է����ּ���.");
				getSelect();
			}
		}catch(IOException ie){
		}
	}

	void copy(){
		selectFile();
		P.pln("���� ���� �Ϸ�!");
	}

	void cut(){
		selectFile();
		f.delete();
		P.pln("���� �߶󳻱� �Ϸ�!");
	}
	void selectFile(){ //
		String inAdd="";
		P.p(" ������ ������ �巡�����ּ���. ");
		try{
			inAdd = brkey.readLine();
			getName(inAdd);
		}catch(IOException ie){ }
	}

	void getName(String inAdd){// ����'�̸���' ���ϱ�.
		String fname="";
		int idx = inAdd.lastIndexOf("\\");
		String addfile = inAdd;
		fname = inAdd.substring(idx+1);
		P.pln("�����̸� : "+fname);
		copyAndWrite(inAdd, fname);
	}

	void copyAndWrite(String inAdd, String fname){
		String outAdd="";
		P.p("������ ������ ��ġ�� �˷��ּ���. : ");
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