package four.quiz;

import java.io.*;
import java.util.*;

class QBack{
	Vector<String> filteredList = new Vector<String>();
	String fname = "txtFile/filtered.txt";
	QBack(){
		inputQ();
	}
	void inputQ(){    //����.txt���� �÷������� �Է¹ޱ� >> ������ ���۵� ��(��ŸƮ��ư�̳�,����)
		FileReader fr = null;
		BufferedReader br = null;
		String line = null;
		try{
			fr = new FileReader(fname);
			br = new BufferedReader(fr);
			while((line = br.readLine()) != null){
				if(line != null) line = line.trim();
				if(line.length() != 0){
					filteredList.add(line);
				}
			}
		}catch(FileNotFoundException fe){
		}catch(IOException ie){
		}
	}
	
	void removeQ(){}	//������ ������ ��, �����÷��ǿ��� ������ �����ϴ� �޼ҵ� >> �����ڵ鷯���� ������.
	
	void saveFilteredFile(){		//������ ��������Ʈ�� �ٽ� ����
		FileWriter fw = null;
		PrintWriter pw = null;
		try{
			fw = new FileWriter(fname);
			pw = new PrintWriter(fw, true);

			for(String item: filteredList){
				pw.print(item+"\n");
				//System.out.print(item);
			}
		}catch(IOException ie){
		}finally{
			try{
				if(pw != null) pw.close();
				if(fw != null) fw.close();
			}catch(IOException ie){}
		}
	}
	
	void scoreRead(){} //���ھ�忡 ����ǥ�� >> �ٸ�����������

}
