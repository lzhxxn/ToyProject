package projectApp.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//ActionListenerMethod을 상속받아, ActionListenerMethod안에 있는 메소드들을 통해 R에 있는 목록들을 수정한다.
//ActionListenerMethod가 이미 interface R을 받았으므로 중복표기할 필요 없음.
public class ResetBtnActionListener extends ActionListenerMethod implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		//테이블 비워주기
		for(int i=dm.getRowCount();i>0;i--){
			dm.removeRow(0);
		}
		list.removeAll(list);
		q=0; //순서도 초기화
		totalPriceField.setText("");

	}

}
