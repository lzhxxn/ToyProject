package projectApp.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;



//ActionListenerMethod을 상속받아, ActionListenerMethod안에 있는 메소드들을 통해 R에 있는 목록들을 수정한다.
//ActionListenerMethod가 이미 interface R을 받았으므로 중복표기할 필요 없음.
public class SearchingFieldActionListener extends ActionListenerMethod implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// 사용자로부터 JTextField를 통해 문자열을 입력받으면, 그 문자열이 포함된 메뉴를 찾을것.
		JTextField t = (JTextField) e.getSource();
		String menuName = t.getText();
		System.out.println(menuName);
		searchingField.setText("(검색할 메뉴 이름을 입력하세요)");
		// 사용자 문자열이 들어간 메뉴를 찾아주는 메소드
		searchMenu(menuName);
	}

}
