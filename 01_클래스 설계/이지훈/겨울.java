class 겨울 { //클래스
	public static void main(String[] args) { //메인 메소드
		할머니 주인 = new 할머니(); //생성자호출
		System.out.print("나이가 " + 주인.나이+"세인 할머니가 ");
        주인.분양한다(); //메소드 호출
		System.out.print("첫번째 강아지의 종은 " + 주인.개1.종+ "이고, "); //멤버변수호출
        System.out.println("두번째 강아지의 종은 " + 주인.개2.종+ "이다."); //멤버변수호출
		System.out.println();

		이웃 웃 = new 이웃(); //생성자호출
		강아지 개 = 웃.분양한다(주인.개1); 
		System.out.println(웃.이름+"이는 강아지(종:"+개.종+")을 분양하고, "+웃.돈+"원이 남았습니다."); //멤버변수호출
		System.out.print("포메라니안의 이름은 " + 주인.개1.name+ "이고, ");
		System.out.println("매우 " + 주인.개1.shape+ " 강아지이다. ");
        System.out.print("겨울이는 "+ 웃.이름+"이를 "); //멤버변수호출
		개.기쁘게만든다();  //메소드호출
	}
}
