import java.util.*;

class Tip1 
{
	final int GA = 0; //����
    final int BA = 1; //����
    final int BO = 2; //��

	int win;
	int lose;
	int draw;

	int num = 3;
	String com;
	Random r = new Random();

	void getN(){ // 3 * 3 = 9���� 
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
			(win+lose+draw) + "�� " + win+"�� ");
	}
	public static void main(String[] args) 
	{
		Tip1 t = new Tip1();
		t.getN();
	}
}
