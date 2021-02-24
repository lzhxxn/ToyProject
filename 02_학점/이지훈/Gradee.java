import java.io.*;

class Grade
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int kor, eng, math, sci;
	Grade(){
        kor = input("국어");
        eng = input("영어");
        math = input("수학");
        sci = input("과학");

       int total = kor + eng + math + sci;
        int avg = total/4;
		if (avg > 89){
			System.out.print("학점: A");
		}else if (avg > 79){
			System.out.print("학점: B");
		}else if (avg > 69){
			System.out.print("학점: C");
		}else if (avg > 59){
			System.out.print("학점: D");
		}else {
			System.out.print("학점: F");
		}
        System.out.println(" (총점: " +total+ ", 평균: " +avg+ ")");
		}

    int input(String subject){
        System.out.print(subject+": ");
	
        try{
            String line = br.readLine();
            line = line.trim();
            int jumsu = Integer.parseInt(line);
            if(jumsu<0 || jumsu > 100){
                System.out.println("잘못된 입력입니다. 재입력바랍니다.");
                input(subject);
                return -1;
            }else{
                return jumsu;
            }
        }catch(IOException ie){
        }catch(NumberFormatException ne){
            System.out.println("잘못된 입력입니다. 재입력바랍니다.");
            input(subject);
        }
        return -1;
		
    }
    public static void main(String[] args) {
		 new Grade();
	}  
}