import java.util.*;

class ThisT //Why? 
{
	String[] args;
    Vector<Integer> v  = new Vector<Integer>();
	int sum;
	int avg;

	ThisT(String[] args){
		if(args.length != 3){
			pln("3������ ������ �Է��ؾ� �մϴ�.");
			return;
		}
		this.args = args;
		parse(); //(1) ���� �м� 
		cal(); //(2) ��� 
		showGrade(); //(3) ���� ��
	}
	void parse(){
		try{
			for(String item: args){
				int i = Integer.parseInt(item);
				v.add(i);
			}
		}catch(NumberFormatException ne){
		}
	}
	void cal(){
		for(int i: v){
			sum += i;
		}
		pln("����: " + sum);
		avg = sum/v.size();
		pln("���: " + avg);
	}
	void showGrade(){
		switch(avg/10){
			case 10:
			case 9: pln("���� A"); break;
			case 8: pln("���� B"); break;
			case 7: pln("���� C"); break;
			case 6: pln("���� D"); break;
			default: pln("���� F");
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
	public static void main(String[] args) {
		new ThisT(args);
	}
}
