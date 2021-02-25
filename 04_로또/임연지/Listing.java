import java.io.*;
import java.util.Random; 

class Listing {
	String fname = "�츮��.txt"; //����� �ִ� �ؽ�Ʈ ���� �̸�
	BufferedReader br; // �о���� ���
	FileReader fr; // ������ �д� ���
	String names[] = new String[20]; //name�̶�� �̸��� String �迭 ����. 20�� ��
	Random r = new Random(); //���� ����ϰ� �ҷ���

	void readF() throws IOException { //������ �д� �޼ҵ�
		fr = new FileReader (fname); //���ϳ����� ������ ��Ƽ�, �����̸��� ������ �ҷ���
		br = new BufferedReader(fr); //�׷��� �ҷ��� ���ϳ����� br�� ������??
		String line = null; //�ϴ� line�� �������.
		int i = 0; //�迭�� �ѹ��� �� i�� �ʱ�ȭ> �ε����� 0���� ��ȣ �Ű����� �ϹǷ�
		while((line = br.readLine()) != null){ //������ �������µ� null �� �ƴѵ���
			names[i++] = line; //names �迭(i��°����)��, line�� �־��.
		}
	}

	void showNames(){ //�̸��� ������ �޼ҵ� ����
		int n=20; //�����ϰ� ���� ����ũ��
		int a = r.nextInt(n); //�������� n�� �ȿ��� ù��° int�� ���ڰ� ����
		int b = r.nextInt(n); //�������� n�� �ȿ��� �ι�° int�� ���ڰ� ����
		int c = r.nextInt(n); //�������� n�� �ȿ��� ����° int�� ���ڰ� ����
		System.out.println("ù��° ��ǥ�� : "+names[a]);
		System.out.println("�ι�° ��ǥ�� : "+names[b]);
		System.out.println("���� ���͵� ��ǥ�� : "+names[c]);
	}
		
	public static void main(String[] args) throws IOException {
		Listing list = new Listing(); //list��� ������ ������Ŭ������ ��ü ���� ����.
		list.readF(); //���� �д� �޼ҵ�
		list.showNames(); // �̸� ��Ÿ���� �޼ҵ�
	}
}