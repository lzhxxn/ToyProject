import java.io.*;
/*
1.�����ϱ�޼ҵ�
	- ����>FIS,  FOS<����
2.�߶󳻱�޼ҵ�
3.����Է¸޼ҵ�
	-�������ϰ�ο� �����̸�
	-������ ��ο� �̸�
4.��ɼ���
	-���ø޼ҵ�
	-���α׷� ����(�޼ҵ� �����ϱ�)
*/
class FileManager
{
	File orgFile;
	File cpyFile;
	BufferedReader brKey = new BufferedReader(new InputStreamReader(System.in));
	
	
	void ready(int i){
		switch(i){
			case 1: inputPathOrg(); copyFile(); break;
			case 2: inputPathOrg(); cutFile(); break;
			default: System.out.println("input 1 or 2"); selectFunc();
		}
	}
	
	void selectFunc(){
		System.out.print("Select([1]Copy [2]Cut): ");
		String line ="";
		try{		
			if( (line = brKey.readLine()) != null) line = line.trim();
			if( line.length() != 0){
				int i = Integer.parseInt(line);
				ready(i);
			}
		}catch(NumberFormatException ne){
			ready(-1);
		}catch(IOException ie){}
	}

	void inputPathOrg(){
		System.out.print("Input File to use: ");
		String line ="";
		String pathOrg="";	
		String fileName = "";
		try{
			line = brKey.readLine();
			if( line != null) line = line.trim();
			if( line.length() !=0){
				pathOrg = line;
				pathOrg = pathOrg.replaceAll("\"",""); //System.out.println(pathOrg);
				orgFile = new File(pathOrg);
				int i = pathOrg.lastIndexOf("\\");
				fileName = pathOrg.substring(i+1); //System.out.println(fileName);
				
				inputPathCpy(fileName);
			}else{
				inputPathOrg();
			}
		}catch(IOException ie){}

	}
	
	void inputPathCpy(String fileName){
		System.out.print("Input path to copy on: ");
		String line=""; 
		String pathCpy="";
		try{
			if((line = brKey.readLine()) != null) line = line.trim();
			if(line.length() != 0){
				pathCpy = line;
				cpyFile = new File(pathCpy, fileName);
				
				if(cpyFile.toString().equalsIgnoreCase(orgFile.toString())){
					System.out.println("Wrong path to copy on, re-input");
					inputPathCpy(fileName);
				}
				
				if(cpyFile.exists()){
					String line2="";
					System.out.print("File of same name exists on path, continue?(y/n):");
					if((line2 = brKey.readLine())!= null) line2= line2.trim();
					if(line2.length() !=0){
						switch(line2){
							case "n": System.out.println("Exit"); System.exit(0);
							case "N": System.out.println("Exit"); System.exit(0);
							default:;
						}
					}
				}
			}else{
				inputPathCpy(fileName);
			}
		}catch(IOException ie){}
	}

	void copyFile(){		
		try{
			FileInputStream fis = new FileInputStream(orgFile);
			FileOutputStream fos = new FileOutputStream(cpyFile);
						
			byte b[] = new byte[512];
			int i = 0;
			while( (i=fis.read(b)) != -1){
				fos.write(b,0,i);
			}
			System.out.println("copy complete");
			if(fis != null) fis.close();
			if(fos != null) fos.close();
		}catch(FileNotFoundException fe){
			System.out.println("Wrong file path");
			inputPathOrg();
		}catch(IOException ie){
		}
	}

	void cutFile(){ // �ٽ� ������. �ӽ����Ͽ� �����ϰ� ���� ����� �ٿ��ֱ�
		copyFile();
		System.out.println(orgFile.delete());
	}

	public static void main(String[] args){
		FileManager fm = new FileManager();
		fm.selectFunc();
	}
}