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

//이벤트처리로 내역을 변경해야하는 멤버들은 R에 선언해서 다른곳에서도 끌어다 쓸것임.
public class MainFrame extends JFrame implements R{

	Container c = getContentPane();
	public MainFrame() {
		//메인컨테이너 설정
		
		setTitle("::: POS SYSTEM :::");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c.setBackground(new Color(246, 246, 246));
		c.setLayout(null);//컴포넌트들의 위치를 자유롭게 잡아주기 위해 레이이웃매니저 삭제

		// main라벨
		JLabel mainLabel = new JLabel(" ORDERING");
		mainLabel.setBackground(new Color(18, 102, 255));
		mainLabel.setBounds(50, 50, 500, 50);
		mainLabel.setForeground(Color.white);
		mainLabel.setOpaque(true);
		mainLabel.setFont(new Font("Arial", Font.BOLD, 20));
		c.add(mainLabel);

		// menu버튼을 담을 패널.
		JPanel menuPane = new JPanel(new GridLayout(1, 6, 3, 1));
		menuPane.setBounds(600, 50, 580, 70);

		//menu버튼배열. 버튼 클릭시 해당 버튼과 맞는 배열을 불러와서 하단 itemArr에 새로 담아줄것임
		JButton[] menuArr = { new JButton("Hot Coffe"), new JButton("Iced Coffe"), new JButton("Hot Beverage"),
				new JButton("Iced Beverage"), new JButton("Flatccino"), new JButton("Tea") };
		for (int i = 0; i < menuArr.length; i++) {

			menuArr[i].setBackground(new Color(92, 209, 229));
			menuArr[i].setBorderPainted(true);
			// 메뉴버튼을 누르면 itemArr의 버튼들이 해당 메뉴에 맞는 버튼들로 바뀜
			//ActionListener는 외부 클래스로 작성하고 싶었으나, 외부 클래스로 작성시 MainFrame안의 멤버들(특히 메소드)에 접근하기 불편하여 포기.
			menuArr[i].addActionListener(new MenuBtnActionListener());
			menuPane.add(menuArr[i]);
		}
		c.add(menuPane);

		
		// 검색창. 검색후 엔터입력하면 해당 글자가 들어간 메뉴들로 itemArr가 리셋된다.
		
		searchingField.setBounds(600, 130, 580, 50);
		//입력을 위해 클릭되면 창 비워주기.
		searchingField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchingField.setText("");
				
			}
		});
		searchingField.addActionListener(new SearchingFieldActionListener());
	
		c.add(searchingField);

		// 아이템리스트패널
		itemPane.setBounds(600, 200, 580, 500);

		for (int i = 0; i < itemArr.length; i++) {

			itemArr[i] = new JButton();

			itemPane.add(itemArr[i]);
		}
		c.add(itemPane);

		// TextArea
//		orderListTextArea.setBounds(50, 160, 500, 350);
//		c.add(orderListTextArea);
		
		columnIdentifiers.addElement("순서");
		columnIdentifiers.addElement("메뉴명");
		columnIdentifiers.addElement("수량");
		columnIdentifiers.addElement("가격");
		JTable table = new JTable(dm);
		
		table.addMouseListener(new MouseListener() {
		
			public void mouseReleased(MouseEvent e) {}

			public void mousePressed(MouseEvent e) {}

			public void mouseExited(MouseEvent e) {}

			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.out.println("클릭되었습니다.");
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
		

		//총 가격을 나타내는 TextField 위에 부착
		JLabel totalPriceLabel = new JLabel("  청구 가격 ");
		totalPriceLabel.setOpaque(true);
		totalPriceLabel.setBounds(50, 520, 500, 30);
		totalPriceLabel.setBackground(new Color(178, 235, 244));
		c.add(totalPriceLabel);

		//totalPriceField 세팅 후 부착
		totalPriceField.setForeground(Color.red);
		totalPriceField.setFont(new Font("Arial", Font.BOLD, 25));
		totalPriceField.setAlignmentX(RIGHT_ALIGNMENT);
		totalPriceField.setBounds(50, 560, 500, 50);
		c.add(totalPriceField);

		//지금까지 입력된 값을 취소할 패널과 버튼
		JPanel modifyingOrderListPane = new JPanel(new GridLayout(1, 2, 3, 3));
		modifyingOrderListPane.setBounds(50, 620, 500, 80);
		
		JButton resetQuantityBtn = new JButton("지 정 취 소");
		JButton resetBtn = new JButton("전  체  취  소");
		JButton plusBtn = new JButton("+");
		plusBtn.setFont(new Font("Arial", Font.BOLD, 20));
		JButton minusBtn = new JButton("-");
		minusBtn.setFont(new Font("Arial", Font.BOLD, 20));
		
		//하단 수정 버튼들에 
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
