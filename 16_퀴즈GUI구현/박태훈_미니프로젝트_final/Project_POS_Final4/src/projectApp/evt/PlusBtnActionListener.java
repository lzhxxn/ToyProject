package projectApp.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projectApp.model.CoffeeMenu;

public class PlusBtnActionListener extends AbstactModifyingBtns implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("�÷��� ��ư�� ���ǽ����.,");
		System.out.println(menuName);
		for (int i = 0; i < list.size(); i++) {
			if (menuName.equals(list.get(i).name)) {
				System.out.println("�̸��� ������ ã�ҽ��ϴ�.");

					list.set(i, new CoffeeMenu(list.get(i).name, list.get(i).price,
							list.get(i).quantity+1, list.get(i).no));
					
					
				
				
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
