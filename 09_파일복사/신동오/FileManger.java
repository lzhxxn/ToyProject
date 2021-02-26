import java.io.*;
/*
1.복사하기메소드
	- 파일>FIS,  FOS<파일
2.잘라내기메소드
3.경로입력메소드
	-원본파일경로와 파일이름
	-복사할 경로와 이름
4.기능선택
	-선택메소드
	-프로그램 로직(메소드 연결하기)
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

	void cutFile(){ // 다시 만들자. 임시파일에 저장하고 원본 지우고 붙여넣기
		copyFile();
		System.out.println(orgFile.delete());
	}

	public static void main(String[] args){
		FileManager fm = new FileManager();
		fm.selectFunc();
	}
}