import java.io.*;
import java.util.Random;

class Lotto
{
	public static void main(String[] args) throws IOException{
		Listing list = new Listing();
		list.readF();

		Random r = new Random();
		int n = 20;
		int pNum = r.nextInt(n);

		String pName = list.v.get(pNum);
		System.out.println("¿À´ÃÀÇ ´çÃ·ÀÚ´Â " + pName + "¾¾ ÀÔ´Ï´Ù.");
	}
}
