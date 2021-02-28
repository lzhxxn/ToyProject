import java.util.*;

class ThisT //Why? 분리
{
	String[] args;
    Vector<Integer> v  = new Vector<Integer>();
	int sum;
	int avg;

	ThisT(String[] args){
		if(args.length != 3){
			pln("3과목의 점수를 입력해야 합니다.");
			return;
		}
		this.args = args;
		new Ps(this).parse(); //(1) 점수 분석 

		Cc cc = new Cc();
		cc.setThisT(this);
		cc.cal(); //(2) 계산 

		new Gd(this).showGrade(); //(3) 학점 평가
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
