class Cc 
{
	ThisT t;
	void setThisT(ThisT t){
		this.t = t;
	}
	void cal(){
		for(int i: t.v){
			t.sum += i;
		}
		t.pln("ÃÑÁ¡: " + t.sum);
		t.avg = t.sum/t.v.size();
		t.pln("Æò±Õ: " + t.avg);
	}
}
