class Gd 
{
	ThisT t;
	Gd(ThisT t){
		this.t = t;
	}
	void showGrade(){
		switch(t.avg/10){
			case 10:
			case 9: t.pln("���� A"); break;
			case 8: t.pln("���� B"); break;
			case 7: t.pln("���� C"); break;
			case 6: t.pln("���� D"); break;
			default: t.pln("���� F");
		}
	}
}
