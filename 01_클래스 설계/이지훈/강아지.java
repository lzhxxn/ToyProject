class 강아지 { //클래스선언
	String 종; //맴버변수1 속성 객체특성
	String name = "겨울";
	String shape = "귀여운";

	강아지(){ //생성자
		종 = "포메라니안";
	}
	강아지(String 종){
		this.종 = 종;
	}
	void 기쁘게만든다(){ //메소드
		System.out.println("매우 기쁘게 만든다");
	}
}

class 할머니{ //클래스
	int 나이; //멤버변수
	강아지 개1,개2;

	할머니(){ //생성자
		나이 = 60;
	}
	void 분양한다(){ //메소드
		개1 = new 강아지();
		개2 = new 강아지("비숑");
		System.out.println("강아지 2마리를 분양한다");
	}
}

class 이웃 { //클래스
	int 돈 = 1100000; //멤버변수1
	String 이름 = "지훈"; //멤버변수2

	강아지 분양한다(강아지 개){ //메소드 리턴(?)
		돈 = 돈 - 1000000;

		return 개;
	}
}