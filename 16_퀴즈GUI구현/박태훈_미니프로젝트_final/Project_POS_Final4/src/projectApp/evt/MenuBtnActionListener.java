package projectApp.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JButton;

import projectApp.model.CoffeeMenu;
import projectApp.resource.R;

//ActionListenerMethod을 상속받아, ActionListenerMethod안에 있는 메소드들을 통해 R에 있는 목록들을 수정한다.
//ActionListenerMethod가 이미 interface R을 받았으므로 중복표기할 필요 없음.
public class MenuBtnActionListener extends ActionListenerMethod implements ActionListener{
	// MenuArr의 메뉴 버튼들이 클릭되면 itemArr의 버튼들을 바꿔줄 ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn.getText().equals("Hot Coffe")) {
			// Hot Coffee메뉴가 클릭 됐을때
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
			// Iced Coffee메뉴가 클릭됐을때
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
			// Hot Beverage 메뉴가 클릭됐을때
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
			// Iced Beverage 메뉴버튼이 클릭됐을때
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
			// Flatccino 메뉴버튼이 클릭됐을때
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

			// Tea 메뉴 버튼이 클릭됐을때
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
