package projectApp.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//ActionListenerMethod�� ��ӹ޾�, ActionListenerMethod�ȿ� �ִ� �޼ҵ���� ���� R�� �ִ� ��ϵ��� �����Ѵ�.
//ActionListenerMethod�� �̹� interface R�� �޾����Ƿ� �ߺ�ǥ���� �ʿ� ����.
public class ResetBtnActionListener extends ActionListenerMethod implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		//���̺� ����ֱ�
		for(int i=dm.getRowCount();i>0;i--){
			dm.removeRow(0);
		}
		list.removeAll(list);
		q=0; //������ �ʱ�ȭ
		totalPriceField.setText("");

	}

}
