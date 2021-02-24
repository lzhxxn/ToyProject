class Star 
{
	void m1(){
		System.out.print("* ");
		System.out.print("* ");
		System.out.print("* ");
		System.out.print("* ");
		System.out.println("");
        System.out.print("* ");
		System.out.print("* ");
		System.out.print("* ");
		System.out.print("* ");
		System.out.println("");
		System.out.print("* ");
		System.out.print("* ");
		System.out.print("* ");
		System.out.print("* ");
		System.out.println("");
		System.out.print("* ");
		System.out.print("* ");
		System.out.print("* ");
		System.out.print("* ");
		System.out.print("");

		System.out.println("");
	}
	void m2(){ 
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++)
				System.out.print("* ");
			System.out.println();
		}
	}
	void m3(){
		for(int i=0; i<4; i++){
			for(int j=0; j<=i; j++)
				System.out.print("* ");
			System.out.println("");
		}
	}
    void m4(){
		for(int i=4; i>0; i--){
			for(int j=1; j<i; j++)
				System.out.print(" ");
			for(int k=0; k<=(4-i); k++)
				System.out.print("* ");
			System.out.println("");
		}
	}
	void m5(){
		for(int i=4; i>0; i--){
			for(int j=0; j<i; j++)
				System.out.print("* ");
			System.out.println("");
		}
	}
	void m6(){
		for(int i=1; i<=4; i++){
			for(int j=1; j<i; j++)
				System.out.print("  ");
			for(int k=0; k<=(4-i); k++)
				System.out.print("* ");
			System.out.println("");
		}
	}
	public static void main(String[] args) 
	{
		Star s= new Star();
		s.m1();
		System.out.println("");
		s.m2();
		System.out.println("");
		s.m3();
		System.out.println("");
		s.m4();
		System.out.println("");
		s.m5();
		System.out.println("");
		s.m6();
	}
}
