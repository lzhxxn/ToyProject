import java.util.*;

class ThisT //Why? �и�
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
		new Ps(this).parse(); //(1) ���� �м� 

		Cc cc = new Cc();
		cc.setThisT(this);
		cc.cal(); //(2) ��� 

		new Gd(this).showGrade(); //(3) ���� ��
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
