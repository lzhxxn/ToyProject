import java.util.*;

class Tip1 
{
	final int GA = 0; //가위
    final int BA = 1; //바위
    final int BO = 2; //보

	int win;
	int lose;
	int draw;

	int num = 3;
	String com;
	Random r = new Random();

	void getN(){ // 3 * 3 = 9가지 
		int c = r.nextInt(num); //0, 1, 2
		switch(c){
			case GA: 
			   switch(m){
				   case GA: draw++; break;
				   case BA: win++; break;  
				   case BO: lose++; break;
			   }
			   break;
			case BA:
               switch(m){
				   case GA: draw++; break;
				   case BA: win++; break;  
				   case BO: lose++; break;
			   }
			   break;
			case BO: 
			   switch(m){
				   case GA: draw++; break;
				   case BA: win++; break;  
				   case BO: lose++; break;
			   }
			   break;
		}
		System.out.println(
			(win+lose+draw) + "전 " + win+"승 ");
	}
	public static void main(String[] args) 
	{
		Tip1 t = new Tip1();
		t.getN();
	}
}
