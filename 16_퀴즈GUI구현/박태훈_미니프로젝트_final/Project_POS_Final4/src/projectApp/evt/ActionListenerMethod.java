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

//AcitonListener들에서 사용할 메소드를 정의해둔 부모클래스
public abstract class ActionListenerMethod implements R {
	//객체생성시 순번으로 넣어줄 변수. static으로 선언해서 상속받은 다른클래스에서도 값을 변경해가며 쓸 수 있게 한다.
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
		int p = 0; // 값을 찾을때마다 이 변수값을 늘려준다. 배열의 인덱스로 활용함과 동시에 검색결과가 있는지도 확인
		// 전체 메뉴을 검색하기 위해, 기존 메뉴 배열들을 다시한번 배열에 담아준다.
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

		// p가 늘어나지 않았다면 검색결과가 없었던것.
		if (p == 0) {

			JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");
		}
		try {
			// 검색을 통해 얻은 배열을 버튼으로 바꿔서 출력할것.
			changeBtn(menuArr);
		} catch (Exception error) {

		}

	}

	public void changeBtn(String[] menuArr) {

		// 매번 버튼이 누를때마다 기존에 있던 값은 사라져야함으로 초기화.
		itemPane.removeAll();
		// 빈버튼을 만들어준다.(추가할 버튼이 총 버튼갯수보다 적어서 빈 버튼 공간이 생기면 안이쁘므로)
		for (int i = 0; i < itemArr.length; i++) {

			itemArr[i] = new JButton();
			itemPane.add(itemArr[i]);
		}
		// 검색, 메뉴클릭으로 만들어진 배열을 버튼으로 만들어준다.
		for (int i = 0; i < menuArr.length; i++) {
			JButton newButton = new JButton(menuArr[i].toString());
			newButton.addActionListener(new ActionListener() {
				// 만들어진 버튼에 ActionListener추가. 클릭되면 가격이 배열에 저장되고 출력되게 할것임
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
					// TextArea에 값을 적어넣을 메소드를 만든다.
					orderListTextAreaSet(menuName, price);

				}
			});

			itemPane.add(newButton, i);
			itemPane.remove(20);
			itemPane.validate();
		}

	}

	public void reWriteJTextField(){
		//JTable을 다 비워준다.
		for(int i=dm.getRowCount();i>0;i--){
			dm.removeRow(0);
		}
		
		//JTable을 다시 작성한다.
		for(int i=0; i<list.size();i++){
			dm.addRow(getVector(i));
			
		}
	}

	// TextArea에 값을 적어넣을 메소드를 만든다.버튼이 클릭되면 실행되는 메소드
	public void orderListTextAreaSet(String name, int price) {

		int quantity = 1;

		// 버튼이 클릭되면 새로운 배열에 Model 객체를 형성해서 넣어준다.

		list.add(new CoffeeMenu(name, price, quantity, q++));
		

		
		
		// 중복검사. 기존에 있는 메뉴면(name이 같으면) 수량만 늘려준다. 이미 추가 된 상태임으로 검사후 수량을 변경해주고
		// 삭제한다.
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).name.equals(list.get(j).name)) {
					list.set(i, new CoffeeMenu(list.get(i).name, list.get(i).price, list.get(i).quantity + 1,
							list.get(i).no));
					// 삭제하고 ++해준 순서를 원상태로 돌려놓는다.
					list.remove(j);
					q--;

				}
			}

		}
		// TextArea를 초기화 한후 값을 넣어준다. 중복 검사후 새로고침된 값을 넣어야 하기 때문에, 매번 초기화한 후 새로 값을
		// 넣어준다.
		orderListTextArea.setText("");
		for (int i = 0; i < list.size(); i++) {
			orderListTextArea.append(list.get(i).no + 1 + "\t" + list.get(i).name + "\t\t" + list.get(i).quantity
					+ "\t\t" + list.get(i).price * list.get(i).quantity + "\n");
		}
		
	

		reWriteJTextField();

		

		// 주문목록 배열에서 갯수와 가격을 곱한 총 가격을 구할 변수 선언 후 값을 누적시킨다.
		int sum = 0;
		for (int i = 0; i < list.size(); i++)
			sum += list.get(i).quantity * list.get(i).price;
		totalPriceField.setText(String.valueOf(sum));

	}

}
