package projectApp.model;

import java.util.ArrayList;

public class CoffeeMenu {

	public String name;
	public int price;
	public int quantity;
	public int no;

	public CoffeeMenu(String name, int price, int quantity, int no) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.no = no;
	}

	@Override
	public String toString() {
		return name + "\t" + String.valueOf(price);
	}

	public CoffeeMenu() {

	}

	public CoffeeMenu(String name, int price) {
		this.name = name;
		this.price = price;
	}
	//메뉴 목록은 미리 배열에 담아놔준다.
	public static ArrayList<CoffeeMenu> HotCoffee = new ArrayList<>();
	public static ArrayList<CoffeeMenu> IcedCoffee = new ArrayList<>();
	public static ArrayList<CoffeeMenu> HotBeverage = new ArrayList<>();
	public static ArrayList<CoffeeMenu> IcedBeverage = new ArrayList<>();
	public static ArrayList<CoffeeMenu> flatccino = new ArrayList<>();
	public static ArrayList<CoffeeMenu> tea = new ArrayList<>();

	static {

		HotCoffee.add(new CoffeeMenu("H아메리카노R", 3200));
		HotCoffee.add(new CoffeeMenu("H카페라떼", 3200));
		HotCoffee.add(new CoffeeMenu("H카페모카R", 3200));
		HotCoffee.add(new CoffeeMenu("H카푸치노R", 3200));
		HotCoffee.add(new CoffeeMenu("에스프레소S", 3200));
		HotCoffee.add(new CoffeeMenu("H피콜로", 3200));
		HotCoffee.add(new CoffeeMenu("H연유라떼", 3200));
		HotCoffee.add(new CoffeeMenu("H플랫화이트R", 3200));
		HotCoffee.add(new CoffeeMenu("H아메리카노L", 4200));
		HotCoffee.add(new CoffeeMenu("H카페라떼L", 4200));
		HotCoffee.add(new CoffeeMenu("H카페모카L", 4200));
		HotCoffee.add(new CoffeeMenu("H카푸치노L", 4200));
		HotCoffee.add(new CoffeeMenu("에스프레소D", 4200));

		HotCoffee.add(new CoffeeMenu("H플랫화이트L", 4200));
	}

	static {

		IcedCoffee.add(new CoffeeMenu("I아메리카노R", 3200));
		IcedCoffee.add(new CoffeeMenu("I카페라떼R", 3700));
		IcedCoffee.add(new CoffeeMenu("I카페모카R", 3600));
		IcedCoffee.add(new CoffeeMenu("I카푸치노R", 3700));
		IcedCoffee.add(new CoffeeMenu("I피콜로R", 3500));
		IcedCoffee.add(new CoffeeMenu("I연유라떼R", 3900));
		IcedCoffee.add(new CoffeeMenu("I플랫화이트R", 4700));
		IcedCoffee.add(new CoffeeMenu("I아메리카노R", 4200));
		IcedCoffee.add(new CoffeeMenu("I카페라떼R", 4700));
		IcedCoffee.add(new CoffeeMenu("I카페모카R", 4600));
		IcedCoffee.add(new CoffeeMenu("I카푸치노R", 4700));
		IcedCoffee.add(new CoffeeMenu("I피콜로", 4500));
		IcedCoffee.add(new CoffeeMenu("I연유라떼L", 4900));
		IcedCoffee.add(new CoffeeMenu("I플랫화이트R", 4700));
		IcedCoffee.add(new CoffeeMenu("I콜드브루아메리카노", 3200));
		IcedCoffee.add(new CoffeeMenu("I콜드브루라떼", 3200));
		IcedCoffee.add(new CoffeeMenu("I콜드브루디카페인아메리카노", 3200));
		IcedCoffee.add(new CoffeeMenu("I콜드브루디카페인 라떼", 3200));
	}
	static {

		HotBeverage.add(new CoffeeMenu("토피넛라떼", 4000));
		HotBeverage.add(new CoffeeMenu("흑당라떼", 3500));
		HotBeverage.add(new CoffeeMenu("이곡라떼", 3200));
		HotBeverage.add(new CoffeeMenu("녹차라떼", 3200));
		HotBeverage.add(new CoffeeMenu("초콜렛", 3500));
		HotBeverage.add(new CoffeeMenu("화이트초콜렛", 3500));
		HotBeverage.add(new CoffeeMenu("고구마라떼", 4000));
		HotBeverage.add(new CoffeeMenu("민트초콜렛", 3800));

	}
	static {

		IcedBeverage.add(new CoffeeMenu("I토피넛라떼", 4000));
		IcedBeverage.add(new CoffeeMenu("I흑당라떼", 3500));
		IcedBeverage.add(new CoffeeMenu("I이곡라떼", 3200));
		IcedBeverage.add(new CoffeeMenu("I녹차라떼", 3200));
		IcedBeverage.add(new CoffeeMenu("I초콜렛", 3500));
		IcedBeverage.add(new CoffeeMenu("I화이트초콜렛", 3500));
		IcedBeverage.add(new CoffeeMenu("I고구마라떼", 4000));
		IcedBeverage.add(new CoffeeMenu("I민트초콜렛", 3800));
		IcedBeverage.add(new CoffeeMenu("I아이스티", 3800));
		IcedBeverage.add(new CoffeeMenu("I오리진쉐이크", 3800));
		IcedBeverage.add(new CoffeeMenu("I딸기쉐이크", 3800));
		IcedBeverage.add(new CoffeeMenu("I쿠키쉐이크", 3800));
		IcedBeverage.add(new CoffeeMenu("I레몬에이드", 3800));
		IcedBeverage.add(new CoffeeMenu("I자몽에이드", 3800));
		IcedBeverage.add(new CoffeeMenu("I청포도에이드", 3800));
		IcedBeverage.add(new CoffeeMenu("I홍시주스", 3800));
		IcedBeverage.add(new CoffeeMenu("I키위주스", 3800));
		IcedBeverage.add(new CoffeeMenu("I딸기주스", 3800));

	}

	static {

		flatccino.add(new CoffeeMenu("꿀복숭아플렛치노", 4000));
		flatccino.add(new CoffeeMenu("초콜렛칩플렛치노", 3500));
		flatccino.add(new CoffeeMenu("민트초코렛칩플렛치노", 3200));
		flatccino.add(new CoffeeMenu("요거트플렛치노", 3200));
		flatccino.add(new CoffeeMenu("딸기요거트플렛치노", 3500));
		flatccino.add(new CoffeeMenu("블루베리플렛치노", 3500));
		flatccino.add(new CoffeeMenu("녹차플렛치노", 4000));
		flatccino.add(new CoffeeMenu("모카플렛치노", 3800));
		flatccino.add(new CoffeeMenu("카라멜플렛치노", 3800));
		flatccino.add(new CoffeeMenu("커피플렛치노", 3800));
		flatccino.add(new CoffeeMenu("망고플렛치노", 3800));
		flatccino.add(new CoffeeMenu("자몽플렛치노", 3800));

	}
	static {

		tea.add(new CoffeeMenu("밀크티", 3200));
		tea.add(new CoffeeMenu("작설차", 2800));
		tea.add(new CoffeeMenu("얼그레이", 2800));
		tea.add(new CoffeeMenu("로스자스민", 2800));
		tea.add(new CoffeeMenu("캐모마일", 2800));
		tea.add(new CoffeeMenu("다즐링", 2800));
		tea.add(new CoffeeMenu("페퍼민트", 2800));
		tea.add(new CoffeeMenu("케모마일", 2800));

	}

}
