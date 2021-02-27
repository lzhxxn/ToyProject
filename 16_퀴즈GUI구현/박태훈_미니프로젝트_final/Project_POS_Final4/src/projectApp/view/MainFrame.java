package projectApp.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import projectApp.evt.DeleteMenuTextFieldActionListener;
import projectApp.evt.MenuBtnActionListener;
import projectApp.evt.MinusBtnActionListener;
import projectApp.evt.PlusBtnActionListener;
import projectApp.evt.ResetBtnActionListener;
import projectApp.evt.SearchingFieldActionListener;


import projectApp.resource.R;

//�̺�Ʈó���� ������ �����ؾ��ϴ� ������� R�� �����ؼ� �ٸ��������� ����� ������.
public class MainFrame extends JFrame implements R{

	Container c = getContentPane();
	public MainFrame() {
		//���������̳� ����
		
		setTitle("::: POS SYSTEM :::");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c.setBackground(new Color(246, 246, 246));
		c.setLayout(null);//������Ʈ���� ��ġ�� �����Ӱ� ����ֱ� ���� �����̿��Ŵ��� ����

		// main��
		JLabel mainLabel = new JLabel(" ORDERING");
		mainLabel.setBackground(new Color(18, 102, 255));
		mainLabel.setBounds(50, 50, 500, 50);
		mainLabel.setForeground(Color.white);
		mainLabel.setOpaque(true);
		mainLabel.setFont(new Font("Arial", Font.BOLD, 20));
		c.add(mainLabel);

		// menu��ư�� ���� �г�.
		JPanel menuPane = new JPanel(new GridLayout(1, 6, 3, 1));
		menuPane.setBounds(600, 50, 580, 70);

		//menu��ư�迭. ��ư Ŭ���� �ش� ��ư�� �´� �迭�� �ҷ��ͼ� �ϴ� itemArr�� ���� ����ٰ���
		JButton[] menuArr = { new JButton("Hot Coffe"), new JButton("Iced Coffe"), new JButton("Hot Beverage"),
				new JButton("Iced Beverage"), new JButton("Flatccino"), new JButton("Tea") };
		for (int i = 0; i < menuArr.length; i++) {

			menuArr[i].setBackground(new Color(92, 209, 229));
			menuArr[i].setBorderPainted(true);
			// �޴���ư�� ������ itemArr�� ��ư���� �ش� �޴��� �´� ��ư��� �ٲ�
			//ActionListener�� �ܺ� Ŭ������ �ۼ��ϰ� �;�����, �ܺ� Ŭ������ �ۼ��� MainFrame���� �����(Ư�� �޼ҵ�)�� �����ϱ� �����Ͽ� ����.
			menuArr[i].addActionListener(new MenuBtnActionListener());
			menuPane.add(menuArr[i]);
		}
		c.add(menuPane);

		
		// �˻�â. �˻��� �����Է��ϸ� �ش� ���ڰ� �� �޴���� itemArr�� ���µȴ�.
		
		searchingField.setBounds(600, 130, 580, 50);
		//�Է��� ���� Ŭ���Ǹ� â ����ֱ�.
		searchingField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchingField.setText("");
				
			}
		});
		searchingField.addActionListener(new SearchingFieldActionListener());
	
		c.add(searchingField);

		// �����۸���Ʈ�г�
		itemPane.setBounds(600, 200, 580, 500);

		for (int i = 0; i < itemArr.length; i++) {

			itemArr[i] = new JButton();

			itemPane.add(itemArr[i]);
		}
		c.add(itemPane);

		// TextArea
//		orderListTextArea.setBounds(50, 160, 500, 350);
//		c.add(orderListTextArea);
		
		columnIdentifiers.addElement("����");
		columnIdentifiers.addElement("�޴���");
		columnIdentifiers.addElement("����");
		columnIdentifiers.addElement("����");
		JTable table = new JTable(dm);
		
		table.addMouseListener(new MouseListener() {
		
			public void mouseReleased(MouseEvent e) {}

			public void mousePressed(MouseEvent e) {}

			public void mouseExited(MouseEvent e) {}

			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.out.println("Ŭ���Ǿ����ϴ�.");
//				System.out.println(table.getSelectedRow());
//				System.out.println(dm.getValueAt(table.getSelectedRow(), 1));
				String selectedMenuName =(String)dm.getValueAt(table.getSelectedRow(), 1);
				DeleteMenuTextFieldActionListener l  =new DeleteMenuTextFieldActionListener();
				l.menuName =selectedMenuName;
			}
		});;

		JScrollPane scrollPane = new JScrollPane(table);
		
		scrollPane.setBounds(50, 110, 500, 400);
		
		c.add(scrollPane);
		

		//�� ������ ��Ÿ���� TextField ���� ����
		JLabel totalPriceLabel = new JLabel("  û�� ���� ");
		totalPriceLabel.setOpaque(true);
		totalPriceLabel.setBounds(50, 520, 500, 30);
		totalPriceLabel.setBackground(new Color(178, 235, 244));
		c.add(totalPriceLabel);

		//totalPriceField ���� �� ����
		totalPriceField.setForeground(Color.red);
		totalPriceField.setFont(new Font("Arial", Font.BOLD, 25));
		totalPriceField.setAlignmentX(RIGHT_ALIGNMENT);
		totalPriceField.setBounds(50, 560, 500, 50);
		c.add(totalPriceField);

		//���ݱ��� �Էµ� ���� ����� �гΰ� ��ư
		JPanel modifyingOrderListPane = new JPanel(new GridLayout(1, 2, 3, 3));
		modifyingOrderListPane.setBounds(50, 620, 500, 80);
		
		JButton resetQuantityBtn = new JButton("�� �� �� ��");
		JButton resetBtn = new JButton("��  ü  ��  ��");
		JButton plusBtn = new JButton("+");
		plusBtn.setFont(new Font("Arial", Font.BOLD, 20));
		JButton minusBtn = new JButton("-");
		minusBtn.setFont(new Font("Arial", Font.BOLD, 20));
		
		//�ϴ� ���� ��ư�鿡 
		resetBtn.addActionListener(new ResetBtnActionListener());
		resetQuantityBtn.addActionListener(new DeleteMenuTextFieldActionListener());
		plusBtn.addActionListener(new PlusBtnActionListener());
		minusBtn.addActionListener(new MinusBtnActionListener());
		
		modifyingOrderListPane.add(resetQuantityBtn);
		modifyingOrderListPane.add(resetBtn);
		modifyingOrderListPane.add(plusBtn);
		modifyingOrderListPane.add(minusBtn);
		
		
		c.add(modifyingOrderListPane);

		setSize(1280, 940);

	}


}
