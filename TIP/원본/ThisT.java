import java.util.*;

class ThisT //Why? 
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
		parse(); //(1) 점수 분석 
		cal(); //(2) 계산 
		showGrade(); //(3) 학점 평가
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
		pln("총점: " + sum);
		avg = sum/v.size();
		pln("평균: " + avg);
	}
	void showGrade(){
		switch(avg/10){
			case 10:
			case 9: pln("학점 A"); break;
			case 8: pln("학점 B"); break;
			case 7: pln("학점 C"); break;
			case 6: pln("학점 D"); break;
			default: pln("학점 F");
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
