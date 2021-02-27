package projectApp.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;



//ActionListenerMethod�� ��ӹ޾�, ActionListenerMethod�ȿ� �ִ� �޼ҵ���� ���� R�� �ִ� ��ϵ��� �����Ѵ�.
//ActionListenerMethod�� �̹� interface R�� �޾����Ƿ� �ߺ�ǥ���� �ʿ� ����.
public class SearchingFieldActionListener extends ActionListenerMethod implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// ����ڷκ��� JTextField�� ���� ���ڿ��� �Է¹�����, �� ���ڿ��� ���Ե� �޴��� ã����.
		JTextField t = (JTextField) e.getSource();
		String menuName = t.getText();
		System.out.println(menuName);
		searchingField.setText("(�˻��� �޴� �̸��� �Է��ϼ���)");
		// ����� ���ڿ��� �� �޴��� ã���ִ� �޼ҵ�
		searchMenu(menuName);
	}

}
