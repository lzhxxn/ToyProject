import java.io.*;
import java.util.Random;

class Lotto{
	public static void main(String[] args) throws IOException{
		Listing list = new Listing();
		list.readF();

		Random r = new Random();
		int n =20;
		int i = r.nextInt(n);
		
		System.out.println("�ζ� ��÷�ڴ� "+
			list.names[i] +"�Դϴ�.");
	}
}
