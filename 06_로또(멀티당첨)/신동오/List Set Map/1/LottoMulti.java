/*
1.������ �д´�
2.�����Ѵ�(Map)
3.�����Ѵ�(������� > ��÷�ڸ��)

cf) �������� ����(��ȣ�� �Բ� ���)
*/

import java.io.*;
import java.util.*;

class LottoMulti
{
	String fname = "�츮��.txt";
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	FileReader fr;
	BufferedReader brFile;

	void readPath(){
		System.out.print("����Ʈ����(�⺻ : �츮��.txt): ");
		try{
			String path = br.readLine();
			if(path != null) path = path.trim();
			if(path.length() != 0){
				fname = path;
			}else{
				readPath();
			}

			fr = new FileReader(fname);
			brFile = new BufferedReader(fr);
			readFile();
		}catch(FileNotFoundException fe){
			System.out.println("file not existing");
			readPath();
		}catch(IOException ie){
			readPath();
		}
	}
	
	Hashtable<Integer, String> map = new Hashtable<Integer,String>();

	void readFile(){
		try{
			int count = 0;
			String line = "";
			while ((line = brFile.readLine()) != null){
				map.put(count++, line);
			}
		}catch(IOException ie){
		}

	}
	
	void showMap(){
		Enumeration<Integer> e = map.keys();
		while(e.hasMoreElements()){
			Integer key = e.nextElement();
			System.out.println(key+ "  " + map.get(key));
		}
	}
	
	int cntWinner;
	void readWinnerCnt(){
		System.out.print("��÷�� ��: ");
		String cntWinnerStr = "";
		try{
			cntWinnerStr = br.readLine();
		}catch(IOException ie){}
		if(cntWinnerStr != null) cntWinnerStr = cntWinnerStr.trim();
		if(cntWinnerStr.length() == 0){
			readWinnerCnt();
		}else{
			try{
				cntWinner = Integer.parseInt(cntWinnerStr);
				if(cntWinner<0 || cntWinner>map.size()){
					System.out.println("out of range");
					readWinnerCnt();
				}else{
					moveKeys();
					for(int i=0; i<cntWinner; i++) select();
					showWinner();
				}
			}catch(NumberFormatException ne){
				readWinnerCnt();
			}
		}
	}
	
	Vector<Integer> v = new Vector<Integer>();
	void moveKeys(){
		Enumeration<Integer> e = map.keys();
		while(e.hasMoreElements()){
			v.add(e.nextElement());
		}
	}
	
	Random r = new Random();
	TreeSet<Integer> s = new TreeSet<Integer>();
	void select(){
		int i = r.nextInt(v.size());
		int winnerKey = v.get(i);
		v.remove(i);
		s.add(winnerKey);
	}
	void showWinner(){
		Iterator<Integer> winnerKeys = s.iterator();
		while(winnerKeys.hasNext()){
			int winnerKey = winnerKeys.next();
			System.out.println(winnerKey+ " " + map.get(winnerKey));
		}
	}

	public static void main(String[] args){
		LottoMulti lotto = new LottoMulti();
		lotto.readPath();	//1�����о Map�� ����.
		//lotto.showMap();	//1-1Map Ȯ��
		lotto.readWinnerCnt();
	}
}
