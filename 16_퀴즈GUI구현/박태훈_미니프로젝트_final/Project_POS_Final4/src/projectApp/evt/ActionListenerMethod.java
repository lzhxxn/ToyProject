package projectApp.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import projectApp.model.CoffeeMenu;
import projectApp.resource.R;

//AcitonListener�鿡�� ����� �޼ҵ带 �����ص� �θ�Ŭ����
public abstract class ActionListenerMethod implements R {
	//��ü������ �������� �־��� ����. static���� �����ؼ� ��ӹ��� �ٸ�Ŭ���������� ���� �����ذ��� �� �� �ְ� �Ѵ�.
	static int q = 0;
	
	public Vector<Object> getVector(int listIdx) {
	
		Vector<Object> v = new Vector<>();
		v.add(list.get(listIdx).no+1);
		v.add(list.get(listIdx).name);
		v.add(list.get(listIdx).quantity);
		v.add(list.get(listIdx).price*list.get(listIdx).quantity);
		
		return v;
	}
	
	public void searchMenu(String menuName) {

		String[] menuArr = new String[20];
		int p = 0; // ���� ã�������� �� �������� �÷��ش�. �迭�� �ε����� Ȱ���԰� ���ÿ� �˻������ �ִ����� Ȯ��
		// ��ü �޴��� �˻��ϱ� ����, ���� �޴� �迭���� �ٽ��ѹ� �迭�� ����ش�.
		ArrayList<ArrayList<CoffeeMenu>> CoffeeMenuArrs = new ArrayList<>();
		CoffeeMenuArrs.add(CoffeeMenu.HotCoffee);
		CoffeeMenuArrs.add(CoffeeMenu.IcedCoffee);
		CoffeeMenuArrs.add(CoffeeMenu.HotBeverage);
		CoffeeMenuArrs.add(CoffeeMenu.IcedBeverage);
		CoffeeMenuArrs.add(CoffeeMenu.flatccino);
		CoffeeMenuArrs.add(CoffeeMenu.tea);

		for (int i = 0; i < CoffeeMenuArrs.size(); i++) {
			for (int j = 0; j < CoffeeMenuArrs.get(i).size(); j++) {
				if (CoffeeMenuArrs.get(i).get(j).name.contains(menuName)) {
					menuArr[p++] = CoffeeMenuArrs.get(i).get(j).toString();
				}
			}
		}

		// p�� �þ�� �ʾҴٸ� �˻������ ��������.
		if (p == 0) {

			JOptionPane.showMessageDialog(null, "�˻������ �����ϴ�.");
		}
		try {
			// �˻��� ���� ���� �迭�� ��ư���� �ٲ㼭 ����Ұ�.
			changeBtn(menuArr);
		} catch (Exception error) {

		}

	}

	public void changeBtn(String[] menuArr) {

		// �Ź� ��ư�� ���������� ������ �ִ� ���� ������������� �ʱ�ȭ.
		itemPane.removeAll();
		// ���ư�� ������ش�.(�߰��� ��ư�� �� ��ư�������� ��� �� ��ư ������ ����� ���̻ڹǷ�)
		for (int i = 0; i < itemArr.length; i++) {

			itemArr[i] = new JButton();
			itemPane.add(itemArr[i]);
		}
		// �˻�, �޴�Ŭ������ ������� �迭�� ��ư���� ������ش�.
		for (int i = 0; i < menuArr.length; i++) {
			JButton newButton = new JButton(menuArr[i].toString());
			newButton.addActionListener(new ActionListener() {
				// ������� ��ư�� ActionListener�߰�. Ŭ���Ǹ� ������ �迭�� ����ǰ� ��µǰ� �Ұ���
				@Override
				public void actionPerformed(ActionEvent e) {

					JButton btn = (JButton) e.getSource();
					StringTokenizer st = new StringTokenizer(btn.getText(), " \t");
					String menuName = "";
					int price = 0;
					while (st.hasMoreTokens()) {
						menuName = st.nextToken();
						price = Integer.valueOf(st.nextToken());

					}
					// TextArea�� ���� ������� �޼ҵ带 �����.
					orderListTextAreaSet(menuName, price);

				}
			});

			itemPane.add(newButton, i);
			itemPane.remove(20);
			itemPane.validate();
		}

	}

	public void reWriteJTextField(){
		//JTable�� �� ����ش�.
		for(int i=dm.getRowCount();i>0;i--){
			dm.removeRow(0);
		}
		
		//JTable�� �ٽ� �ۼ��Ѵ�.
		for(int i=0; i<list.size();i++){
			dm.addRow(getVector(i));
			
		}
	}

	// TextArea�� ���� ������� �޼ҵ带 �����.��ư�� Ŭ���Ǹ� ����Ǵ� �޼ҵ�
	public void orderListTextAreaSet(String name, int price) {

		int quantity = 1;

		// ��ư�� Ŭ���Ǹ� ���ο� �迭�� Model ��ü�� �����ؼ� �־��ش�.

		list.add(new CoffeeMenu(name, price, quantity, q++));
		

		
		
		// �ߺ��˻�. ������ �ִ� �޴���(name�� ������) ������ �÷��ش�. �̹� �߰� �� ���������� �˻��� ������ �������ְ�
		// �����Ѵ�.
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).name.equals(list.get(j).name)) {
					list.set(i, new CoffeeMenu(list.get(i).name, list.get(i).price, list.get(i).quantity + 1,
							list.get(i).no));
					// �����ϰ� ++���� ������ �����·� �������´�.
					list.remove(j);
					q--;

				}
			}

		}
		// TextArea�� �ʱ�ȭ ���� ���� �־��ش�. �ߺ� �˻��� ���ΰ�ħ�� ���� �־�� �ϱ� ������, �Ź� �ʱ�ȭ�� �� ���� ����
		// �־��ش�.
		orderListTextArea.setText("");
		for (int i = 0; i < list.size(); i++) {
			orderListTextArea.append(list.get(i).no + 1 + "\t" + list.get(i).name + "\t\t" + list.get(i).quantity
					+ "\t\t" + list.get(i).price * list.get(i).quantity + "\n");
		}
		
	

		reWriteJTextField();

		

		// �ֹ���� �迭���� ������ ������ ���� �� ������ ���� ���� ���� �� ���� ������Ų��.
		int sum = 0;
		for (int i = 0; i < list.size(); i++)
			sum += list.get(i).quantity * list.get(i).price;
		totalPriceField.setText(String.valueOf(sum));

	}

}
