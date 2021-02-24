class OperT 
{
	int i = 5;
	int j = 2;
	
	void m(){ // + , - , * , / , %  
		int r1 = i + j;
		System.out.println("r1: " + r1);
		int r2 = i - j;
        System.out.println("r2: " + r2);
		int r3 = i * j;
        System.out.println("r3: " + r3);
		int r4 = i / j;
        System.out.println("r4: " + r4);
		int r5 = i % j;
        System.out.println("r5: " + r5);

		double d1 = i;
		double d2 = j;
		double r6 = d1 / d2;
        System.out.println("r6: " + r6);
	}
	public static void main(String[] args) 
	{
		OperT ot = new OperT();
		ot.m();
	}
}
