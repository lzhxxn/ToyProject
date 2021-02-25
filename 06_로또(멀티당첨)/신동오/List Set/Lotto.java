import java.io.*;
import java.util.*;

class Lotto{
	public static void main(String[] args) throws IOException
	{
		Listing list = new Listing();			//����� �о� List�÷��ǿ� �Է�
		list.readF();
		int listNum = list.v.size();
		//list.showName();

		RanNum rn = new RanNum();				
		int totalNum = rn.input(listNum);		//���� �ο� ����
		rn.pickNum(totalNum, listNum);			//������ ����ŭ �������� �̱�, Set�÷��ǿ� ����.
		//rn.showNum();

		Iterator<Integer> iter = rn.tr.iterator();
		int i=-1;
		while(iter.hasNext()){					//Set�÷��ǿ� ����� �����ѹ��� List�÷��� �ε����� �־� ���� �̸��� ���
			i = iter.next();
			String pickedName = list.v.get(i);
			System.out.println("  -"+(i+1) +": "+ pickedName);
		}
	}
}
