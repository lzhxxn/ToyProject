class Listing
{
	FileReader = fr;
	BufferedReader = brFile;
	Hashtable<Integer,String> map = new Hashtable<Integer,String>();

	void read(BufferedReader br){
		System.out.print("Input listfile name: ");
		String path = br.readLine();
		path = path.trim();
		fr = new FileReader(path);
		brFile = new BufferedReader(fr);
		
		String line = "", int count = 0;
		while((line = brfile.nextLine()) == null){
			map.put(count++, brFile.readLine());
		} 
	}
}
