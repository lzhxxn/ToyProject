import java.util.*;
import java.io.*;

class RanNum //������ ����ŭ �������� �̴� ��ü
{
	//���� ���� ���� �Է�
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int input(int listNum) throws IOException{				//���� �ο� ���� �޼ҵ�
		System.out.print("��÷�� ���� �Է��ϼ���: ");
		try{
			String line = br.readLine();
			line = line.trim();
			int i = Integer.parseInt(line);
			if(i<1 || i> listNum){
				System.out.println("�������� ������, �ٽ� �Է��ϼ���");
				return input(listNum);
			}
			return i;
		}catch(NumberFormatException ne){
			System.out.println("�߸� �Է��߾��, �ٽ� �Է��ϼ���");
		}
		return input(listNum);
	}

	//���� ���� �̱�
	Random r = new Random();
	TreeSet<Integer> tr = new TreeSet<Integer>();

	void pickNum(int totalNum, int listNum){		 //Set�÷��ǿ� �������Է�, ������ ���ڸ�ŭ. �ߺ�����
		while(tr.size()<totalNum) tr.add(r.nextInt(listNum));
	}

	void showNum(){									//�÷��ǿ� ����� ���� Ȯ��
		for(Integer pickedNum: tr) System.out.println(pickedNum);
	}

}