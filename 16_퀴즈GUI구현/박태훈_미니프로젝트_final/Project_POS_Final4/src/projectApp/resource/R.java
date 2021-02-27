package projectApp.resource;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import projectApp.model.CoffeeMenu;

public interface R {
	

	//메뉴에 맞는 아이템 버튼들을 넣을 버튼배열. 
	public JButton itemArr[] = new JButton[20];
	//아이템 버튼을 담을 패널
	public JPanel itemPane = new JPanel(new GridLayout(5, 4, 5, 5));
	//클릭된 버튼들의 목록을 보여주는 TextArea필드
	public JTextArea orderListTextArea = new JTextArea(20, 1);
	//청구 금액을 보여주는 TextField
	public JTextField totalPriceField = new JTextField();
	//버튼이 클릭되면 클릭된 아이템들의 정보를 담을 배열
	ArrayList<CoffeeMenu> list = new ArrayList<>();
	JTextField searchingField = new JTextField("(검색할 메뉴 이름을 입력하세요)");
	
	Vector dataVector = new Vector();
	//Vector columnIdentifiers = new Vector();
	Vector<String> columnIdentifiers = new Vector<>();

	DefaultTableModel dm = new DefaultTableModel(dataVector,columnIdentifiers);
	
	
	
}
