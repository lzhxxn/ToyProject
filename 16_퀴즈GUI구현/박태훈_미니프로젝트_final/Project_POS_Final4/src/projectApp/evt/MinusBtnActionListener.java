package projectApp.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projectApp.model.CoffeeMenu;

public class MinusBtnActionListener extends AbstactModifyingBtns implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("마이너스 버튼이 눌렸습니다.");

		
		System.out.println(menuName);
		for (int i = 0; i < list.size(); i++) {
			if (menuName.equals(list.get(i).name)) {
				System.out.println("이름이 같은걸 찾았습니다.");

					list.set(i, new CoffeeMenu(list.get(i).name, list.get(i).price,
							list.get(i).quantity-1, list.get(i).no));
					if(list.get(i).quantity==0){
						list.remove(i);
						q--;
						//순번을 바꿔주기.
						int number =0;
						for(int j=0; j<list.size();j++){
							list.set(j, new CoffeeMenu(list.get(j).name, list.get(j).price,
									list.get(j).quantity, number++));
							
						}
						
					}
					
				
				
			}

		}
		
		reWriteJTextField();

		int sum = 0;
		for (int i = 0; i < dm.getRowCount(); i++) {
			sum += (int) dm.getValueAt(i, 3);
		}
		totalPriceField.setText(String.valueOf(sum));

	}

}
