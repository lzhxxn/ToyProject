class D
{
	void m1(){
		/*System.out.print("* ");
		System.out.print("* ");
		System.out.print("* ");
		System.out.print("* ");
		System.out.println();
		System.out.print("* ");
		System.out.print("* ");
		System.out.print("* ");
		System.out.print("* ");*/
		
		for(int j=0; j<4; j++){
			for(int i=0; i<4; i++){
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	void m2(){
		for(int j=0; j<4; j++){
			for(int i=0; i<=j; i++){ // 0 0 -> 1 0, 1 1 -> 2 0, 2 1, 2 2 -> 3 0, 3 1, 3 2, 3 4
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	void m3(){
		for(int j=1; j<=4; j++){
			for(int i=4; i>0; i--){ // 1 4(공백), 1 3(공백), 1 2(공백), 1 1(*)
				if(j<i){
					System.out.print("  ");
				}else{
					System.out.print("* ");
				}
			}
			 System.out.println();
			}
	}
	void m4(){
		for(int j=0; j<=4; j++){
			for(int i=4; i>j; i--){ //0 4, 0 3, 0 2, 0 1 -> 1 4, 1 3, 1 2
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	void m5(){
		for(int j=0; j<4; j++){
			for(int i=0; i<4; i++){
				if(j<=i){
					System.out.print("* ");
				}else{
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		D d = new D();
		//d.m1(); 
		d.m2();
		System.out.println();
		d.m3();
		System.out.println();
		d.m4();
		System.out.println();
		d.m5();
	}
}

