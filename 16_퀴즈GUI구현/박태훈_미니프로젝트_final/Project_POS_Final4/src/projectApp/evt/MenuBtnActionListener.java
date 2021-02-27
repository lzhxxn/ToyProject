package projectApp.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JButton;

import projectApp.model.CoffeeMenu;
import projectApp.resource.R;

//ActionListenerMethod�� ��ӹ޾�, ActionListenerMethod�ȿ� �ִ� �޼ҵ���� ���� R�� �ִ� ��ϵ��� �����Ѵ�.
//ActionListenerMethod�� �̹� interface R�� �޾����Ƿ� �ߺ�ǥ���� �ʿ� ����.
public class MenuBtnActionListener extends ActionListenerMethod implements ActionListener{
	// MenuArr�� �޴� ��ư���� Ŭ���Ǹ� itemArr�� ��ư���� �ٲ��� ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn.getText().equals("Hot Coffe")) {
			// Hot Coffee�޴��� Ŭ�� ������
			String[] menuArr = new String[20];

			for (int i = 0; i < CoffeeMenu.HotCoffee.size(); i++) {
				menuArr[i] = CoffeeMenu.HotCoffee.get(i).toString();
				System.out.println(CoffeeMenu.HotCoffee.get(i).toString());
			}
			try {
				changeBtn(menuArr);
			} catch (Exception error) {

			}
		} else if (btn.getText().equals("Iced Coffe")) {
			// Iced Coffee�޴��� Ŭ��������
			String[] menuArr = new String[20];

			for (int i = 0; i < CoffeeMenu.IcedCoffee.size(); i++) {
				menuArr[i] = CoffeeMenu.IcedCoffee.get(i).toString();
				System.out.println(CoffeeMenu.IcedCoffee.get(i).toString());
			}
			try {
				changeBtn(menuArr);
			} catch (Exception error) {

			}

		} else if (btn.getText().equals("Hot Beverage")) {
			// Hot Beverage �޴��� Ŭ��������
			String[] menuArr = new String[20];

			for (int i = 0; i < CoffeeMenu.HotBeverage.size(); i++) {
				menuArr[i] = CoffeeMenu.HotBeverage.get(i).toString();
				System.out.println(CoffeeMenu.HotBeverage.get(i).toString());
			}
			try {
				changeBtn(menuArr);
			} catch (Exception error) {

			}
		} else if (btn.getText().equals("Iced Beverage")) {
			// Iced Beverage �޴���ư�� Ŭ��������
			String[] menuArr = new String[20];

			for (int i = 0; i < CoffeeMenu.IcedBeverage.size(); i++) {
				menuArr[i] = CoffeeMenu.IcedBeverage.get(i).toString();
				System.out.println(CoffeeMenu.IcedBeverage.get(i).toString());
			}
			try {
				changeBtn(menuArr);
			} catch (Exception error) {

			}
		} else if (btn.getText().equals("Flatccino")) {
			// Flatccino �޴���ư�� Ŭ��������
			String[] menuArr = new String[20];

			for (int i = 0; i < CoffeeMenu.flatccino.size(); i++) {
				menuArr[i] = CoffeeMenu.flatccino.get(i).toString();
				System.out.println(CoffeeMenu.flatccino.get(i).toString());
			}
			try {
				changeBtn(menuArr);
			} catch (Exception error) {

			}
		} else if (btn.getText().equals("Tea")) {

			// Tea �޴� ��ư�� Ŭ��������
			String[] menuArr = new String[20];
			for (int i = 0; i < CoffeeMenu.tea.size(); i++) {
				menuArr[i] = CoffeeMenu.tea.get(i).toString();
				System.out.println(CoffeeMenu.tea.get(i).toString());
			}
			try {
				changeBtn(menuArr);
			} catch (Exception error) {

			}
		}

	}
	
}
