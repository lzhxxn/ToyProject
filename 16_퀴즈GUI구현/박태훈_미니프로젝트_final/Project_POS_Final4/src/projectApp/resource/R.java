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
	

	//�޴��� �´� ������ ��ư���� ���� ��ư�迭. 
	public JButton itemArr[] = new JButton[20];
	//������ ��ư�� ���� �г�
	public JPanel itemPane = new JPanel(new GridLayout(5, 4, 5, 5));
	//Ŭ���� ��ư���� ����� �����ִ� TextArea�ʵ�
	public JTextArea orderListTextArea = new JTextArea(20, 1);
	//û�� �ݾ��� �����ִ� TextField
	public JTextField totalPriceField = new JTextField();
	//��ư�� Ŭ���Ǹ� Ŭ���� �����۵��� ������ ���� �迭
	ArrayList<CoffeeMenu> list = new ArrayList<>();
	JTextField searchingField = new JTextField("(�˻��� �޴� �̸��� �Է��ϼ���)");
	
	Vector dataVector = new Vector();
	//Vector columnIdentifiers = new Vector();
	Vector<String> columnIdentifiers = new Vector<>();

	DefaultTableModel dm = new DefaultTableModel(dataVector,columnIdentifiers);
	
	
	
}
