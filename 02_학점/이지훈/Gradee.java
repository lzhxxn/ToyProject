import java.io.*;

class Grade
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int kor, eng, math, sci;
	Grade(){
        kor = input("����");
        eng = input("����");
        math = input("����");
        sci = input("����");

       int total = kor + eng + math + sci;
        int avg = total/4;
		if (avg > 89){
			System.out.print("����: A");
		}else if (avg > 79){
			System.out.print("����: B");
		}else if (avg > 69){
			System.out.print("����: C");
		}else if (avg > 59){
			System.out.print("����: D");
		}else {
			System.out.print("����: F");
		}
        System.out.println(" (����: " +total+ ", ���: " +avg+ ")");
		}

    int input(String subject){
        System.out.print(subject+": ");
	
        try{
            String line = br.readLine();
            line = line.trim();
            int jumsu = Integer.parseInt(line);
            if(jumsu<0 || jumsu > 100){
                System.out.println("�߸��� �Է��Դϴ�. ���Է¹ٶ��ϴ�.");
                input(subject);
                return -1;
            }else{
                return jumsu;
            }
        }catch(IOException ie){
        }catch(NumberFormatException ne){
            System.out.println("�߸��� �Է��Դϴ�. ���Է¹ٶ��ϴ�.");
            input(subject);
        }
        return -1;
		
    }
    public static void main(String[] args) {
		 new Grade();
	}  
}