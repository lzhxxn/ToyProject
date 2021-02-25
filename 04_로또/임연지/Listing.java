import java.io.*;
import java.util.Random; 

class Listing {
	String fname = "우리반.txt"; //명단이 있는 텍스트 파일 이름
	BufferedReader br; // 읽어오는 기능
	FileReader fr; // 파일을 읽는 기능
	String names[] = new String[20]; //name이라는 이름의 String 배열 만듦. 20개 방
	Random r = new Random(); //랜덤 사용하게 불러옴

	void readF() throws IOException { //파일을 읽는 메소드
		fr = new FileReader (fname); //파일네임을 변수에 담아서, 변수이름의 파일을 불러옴
		br = new BufferedReader(fr); //그렇게 불러온 파일내용을 br로 가져옴??
		String line = null; //일단 line은 비어있음.
		int i = 0; //배열의 넘버가 될 i를 초기화> 인덱스가 0부터 번호 매겨져야 하므로
		while((line = br.readLine()) != null){ //라인이 읽혀지는데 null 이 아닌동안
			names[i++] = line; //names 배열(i번째부터)에, line을 넣어라.
		}
	}

	void showNames(){ //이름을 보여줄 메소드 만듦
		int n=20; //랜덤하게 뽑힐 숫자크기
		int a = r.nextInt(n); //랜덤으로 n값 안에서 첫번째 int형 숫자가 뽑힘
		int b = r.nextInt(n); //랜덤으로 n값 안에서 두번째 int형 숫자가 뽑힘
		int c = r.nextInt(n); //랜덤으로 n값 안에서 세번째 int형 숫자가 뽑힘
		System.out.println("첫번째 발표자 : "+names[a]);
		System.out.println("두번째 발표자 : "+names[b]);
		System.out.println("복습 스터디 발표자 : "+names[c]);
	}
		
	public static void main(String[] args) throws IOException {
		Listing list = new Listing(); //list라는 변수에 리스팅클래스의 객체 만들어서 담음.
		list.readF(); //파일 읽는 메소드
		list.showNames(); // 이름 나타내는 메소드
	}
}