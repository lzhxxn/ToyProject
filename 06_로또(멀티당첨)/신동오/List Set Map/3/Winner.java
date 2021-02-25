class Winner{
	Vector<Integer> v = new Vector<Integer>();

	void moveKeys(Hashtable map){
		Enumeration<Integer> e = map.keys();
		while(e.hasMoreElements()){
			v.add(e.nextElement());
		}
	}

	Random r = new Random();
	TreeSet<Integer> s = new TreeSet<Integer>();
	
	void select(){
		int i = r.nextInt(v.size());
		int winnerKey = v.get(i);
		v.remove(i);
		s.add(winnerKey);
	}

	void showWinner(){
		Iterator<Integer> winnerKeys = s.iterator();
		while(winnerKeys.hasNext()){
			int winnerKey = winnerKeys.next();
			System.out.println(winnerKey + "   " + map.get(winnerKey));
		}
	}

	void runtime(){}

}
