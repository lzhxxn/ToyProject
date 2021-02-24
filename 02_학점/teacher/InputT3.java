import java.util.*;

class InputT3 
{
	Scanner sc = new Scanner(System.in);
	void input(String subject){
		System.out.print(subject+": ");
		int jumsu = sc.nextInt();
		if(jumsu<0 || jumsu > 100){
			System.out.println("유효한 점수 아닙니다.. 다시 입력해주세요");
			input(subject);
		}else{
			System.out.println("jumsu: " + (jumsu+1));
		}
	}
	public static void main(String[] args) 
	{
		new InputT3().input("국어");
	}
}
