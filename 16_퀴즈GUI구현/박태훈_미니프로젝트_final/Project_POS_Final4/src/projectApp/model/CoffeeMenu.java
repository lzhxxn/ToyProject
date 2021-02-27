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
	//�޴� ����� �̸� �迭�� ��Ƴ��ش�.
	public static ArrayList<CoffeeMenu> HotCoffee = new ArrayList<>();
	public static ArrayList<CoffeeMenu> IcedCoffee = new ArrayList<>();
	public static ArrayList<CoffeeMenu> HotBeverage = new ArrayList<>();
	public static ArrayList<CoffeeMenu> IcedBeverage = new ArrayList<>();
	public static ArrayList<CoffeeMenu> flatccino = new ArrayList<>();
	public static ArrayList<CoffeeMenu> tea = new ArrayList<>();

	static {

		HotCoffee.add(new CoffeeMenu("H�Ƹ޸�ī��R", 3200));
		HotCoffee.add(new CoffeeMenu("Hī���", 3200));
		HotCoffee.add(new CoffeeMenu("Hī���īR", 3200));
		HotCoffee.add(new CoffeeMenu("HīǪġ��R", 3200));
		HotCoffee.add(new CoffeeMenu("����������S", 3200));
		HotCoffee.add(new CoffeeMenu("H���ݷ�", 3200));
		HotCoffee.add(new CoffeeMenu("H������", 3200));
		HotCoffee.add(new CoffeeMenu("H�÷�ȭ��ƮR", 3200));
		HotCoffee.add(new CoffeeMenu("H�Ƹ޸�ī��L", 4200));
		HotCoffee.add(new CoffeeMenu("Hī���L", 4200));
		HotCoffee.add(new CoffeeMenu("Hī���īL", 4200));
		HotCoffee.add(new CoffeeMenu("HīǪġ��L", 4200));
		HotCoffee.add(new CoffeeMenu("����������D", 4200));

		HotCoffee.add(new CoffeeMenu("H�÷�ȭ��ƮL", 4200));
	}

	static {

		IcedCoffee.add(new CoffeeMenu("I�Ƹ޸�ī��R", 3200));
		IcedCoffee.add(new CoffeeMenu("Iī���R", 3700));
		IcedCoffee.add(new CoffeeMenu("Iī���īR", 3600));
		IcedCoffee.add(new CoffeeMenu("IīǪġ��R", 3700));
		IcedCoffee.add(new CoffeeMenu("I���ݷ�R", 3500));
		IcedCoffee.add(new CoffeeMenu("I������R", 3900));
		IcedCoffee.add(new CoffeeMenu("I�÷�ȭ��ƮR", 4700));
		IcedCoffee.add(new CoffeeMenu("I�Ƹ޸�ī��R", 4200));
		IcedCoffee.add(new CoffeeMenu("Iī���R", 4700));
		IcedCoffee.add(new CoffeeMenu("Iī���īR", 4600));
		IcedCoffee.add(new CoffeeMenu("IīǪġ��R", 4700));
		IcedCoffee.add(new CoffeeMenu("I���ݷ�", 4500));
		IcedCoffee.add(new CoffeeMenu("I������L", 4900));
		IcedCoffee.add(new CoffeeMenu("I�÷�ȭ��ƮR", 4700));
		IcedCoffee.add(new CoffeeMenu("I�ݵ���Ƹ޸�ī��", 3200));
		IcedCoffee.add(new CoffeeMenu("I�ݵ����", 3200));
		IcedCoffee.add(new CoffeeMenu("I�ݵ����ī���ξƸ޸�ī��", 3200));
		IcedCoffee.add(new CoffeeMenu("I�ݵ����ī���� ��", 3200));
	}
	static {

		HotBeverage.add(new CoffeeMenu("���ǳӶ�", 4000));
		HotBeverage.add(new CoffeeMenu("����", 3500));
		HotBeverage.add(new CoffeeMenu("�̰��", 3200));
		HotBeverage.add(new CoffeeMenu("������", 3200));
		HotBeverage.add(new CoffeeMenu("���ݷ�", 3500));
		HotBeverage.add(new CoffeeMenu("ȭ��Ʈ���ݷ�", 3500));
		HotBeverage.add(new CoffeeMenu("������", 4000));
		HotBeverage.add(new CoffeeMenu("��Ʈ���ݷ�", 3800));

	}
	static {

		IcedBeverage.add(new CoffeeMenu("I���ǳӶ�", 4000));
		IcedBeverage.add(new CoffeeMenu("I����", 3500));
		IcedBeverage.add(new CoffeeMenu("I�̰��", 3200));
		IcedBeverage.add(new CoffeeMenu("I������", 3200));
		IcedBeverage.add(new CoffeeMenu("I���ݷ�", 3500));
		IcedBeverage.add(new CoffeeMenu("Iȭ��Ʈ���ݷ�", 3500));
		IcedBeverage.add(new CoffeeMenu("I������", 4000));
		IcedBeverage.add(new CoffeeMenu("I��Ʈ���ݷ�", 3800));
		IcedBeverage.add(new CoffeeMenu("I���̽�Ƽ", 3800));
		IcedBeverage.add(new CoffeeMenu("I����������ũ", 3800));
		IcedBeverage.add(new CoffeeMenu("I���⽦��ũ", 3800));
		IcedBeverage.add(new CoffeeMenu("I��Ű����ũ", 3800));
		IcedBeverage.add(new CoffeeMenu("I�����̵�", 3800));
		IcedBeverage.add(new CoffeeMenu("I�ڸ����̵�", 3800));
		IcedBeverage.add(new CoffeeMenu("Iû�������̵�", 3800));
		IcedBeverage.add(new CoffeeMenu("Iȫ���ֽ�", 3800));
		IcedBeverage.add(new CoffeeMenu("IŰ���ֽ�", 3800));
		IcedBeverage.add(new CoffeeMenu("I�����ֽ�", 3800));

	}

	static {

		flatccino.add(new CoffeeMenu("�ܺ������÷�ġ��", 4000));
		flatccino.add(new CoffeeMenu("���ݷ�Ĩ�÷�ġ��", 3500));
		flatccino.add(new CoffeeMenu("��Ʈ���ڷ�Ĩ�÷�ġ��", 3200));
		flatccino.add(new CoffeeMenu("���Ʈ�÷�ġ��", 3200));
		flatccino.add(new CoffeeMenu("������Ʈ�÷�ġ��", 3500));
		flatccino.add(new CoffeeMenu("��纣���÷�ġ��", 3500));
		flatccino.add(new CoffeeMenu("�����÷�ġ��", 4000));
		flatccino.add(new CoffeeMenu("��ī�÷�ġ��", 3800));
		flatccino.add(new CoffeeMenu("ī����÷�ġ��", 3800));
		flatccino.add(new CoffeeMenu("Ŀ���÷�ġ��", 3800));
		flatccino.add(new CoffeeMenu("�����÷�ġ��", 3800));
		flatccino.add(new CoffeeMenu("�ڸ��÷�ġ��", 3800));

	}
	static {

		tea.add(new CoffeeMenu("��ũƼ", 3200));
		tea.add(new CoffeeMenu("�ۼ���", 2800));
		tea.add(new CoffeeMenu("��׷���", 2800));
		tea.add(new CoffeeMenu("�ν��ڽ���", 2800));
		tea.add(new CoffeeMenu("ĳ����", 2800));
		tea.add(new CoffeeMenu("����", 2800));
		tea.add(new CoffeeMenu("���۹�Ʈ", 2800));
		tea.add(new CoffeeMenu("�ɸ���", 2800));

	}

}
