import java.util.Random;
import java.io.*;

class Ran 
{
	Random r = new Random();
	int n = 20;

	void showNum(String names[]){
		int i = r.nextInt(n); //0 ~ (n-1)	
		System.out.println("´çÃ·ÀÚ: " + names[i]);
	}
	public static void main(String[] args) throws IOException 
	{
		Ran ran = new Ran();

		Listing list = new Listing();
		list.readF();
		//list.showNames();

		ran.showNum(list.names);
	}
}
