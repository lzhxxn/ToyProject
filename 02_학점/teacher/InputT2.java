import java.io.*;

class InputT2 
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int kor, eng, math, science;
	InputT2(){
		kor = input("국어");
		eng = input("영어");
		math = input("수학");
		science = input("과학");

		int total = kor + eng + math + science;
		int avg = total/4;
		System.out.println("총점: "+total+ ", 평균: " +avg);
	}
	
	int input(String subject){
		System.out.print(subject+": ");
		
		try{
			String line = br.readLine();
			line = line.trim();
			int jumsu = Integer.parseInt(line);
			if(jumsu<0 || jumsu>100){
				system.out.println("유효한 점수가 아닙니다..다시 입력해주세요");
				input(subject);
				return -1;
			}else{
                return jumsu;
			}

		}catch(IOException ie){
		}catch(NumberFormatException ne){
			System.out.println("잘못된 입력정보예요.. 다시 입력해주세요");
			input(subject);
		}
		return -1;
	}
	public static void main(String[] args) {
		//new InputT2();

        int jumsu = new InputT2().input("자바");
		if(jumsu != -1 )
			System.out.println("입력점수: " + jumsu);
	}
}
