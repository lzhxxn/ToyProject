package projectApp.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import projectApp.model.CoffeeMenu;

public class DeleteMenuTextFieldActionListener extends AbstactModifyingBtns implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < list.size(); i++) {
			if (menuName.equals(list.get(i).name)) {
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
		
		reWriteJTextField();
		
		int sum=0;
		for(int i=0;i<dm.getRowCount();i++){
		sum+=(int)dm.getValueAt(i, 3);
		}
		totalPriceField.setText(String.valueOf(sum));
		
		
	}
	


}
