class Gd 
{
	ThisT t;
	Gd(ThisT t){
		this.t = t;
	}
	void showGrade(){
		switch(t.avg/10){
			case 10:
			case 9: t.pln("학점 A"); break;
			case 8: t.pln("학점 B"); break;
			case 7: t.pln("학점 C"); break;
			case 6: t.pln("학점 D"); break;
			default: t.pln("학점 F");
		}
	}
}
