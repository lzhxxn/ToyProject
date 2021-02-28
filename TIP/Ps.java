class Ps 
{
	ThisT t;
	Ps(ThisT t){
		this.t = t;
	}
	void parse(){
		try{
			for(String item: t.args){
				int i = Integer.parseInt(item);
				t.v.add(i);
			}
		}catch(NumberFormatException ne){
		}
	}
}
