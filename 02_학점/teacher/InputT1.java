class InputT1 
{
	public static void main(String[] args) 
	{
		if(args.length != 4){
			System.out.println("4개의 데이터를 입력해주세요");
		}else{
			System.out.println("args[0]: " + args[0]);
			System.out.println("args[1]: " + args[1]);
			System.out.println("args[2]: " + args[2]);
			System.out.println("args[3]: " + args[3]);
		}
	}
}
