import java.io.*;
import java.util.Random;

class Lotto
{
	

	public static void main(String[] args) throws IOException
	{
		Listing list = new Listing();
		list.readF();
		
		Random r= new Random();
		int n = 20;
		int pickedNum = r.nextInt(n);
		
		String pickedName = list.v.get(pickedNum);
		System.out.println("¿À´Ã ´çÃ·ÀÚ´Â "+ pickedName +"¾¾ÀÔ´Ï´Ù.");

	}
}
