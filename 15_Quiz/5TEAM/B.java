import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class B extends JFrame implements ActionListener {
    //�������
    private BufferedImage pic;
    private JButton btn1, btn2;
    private JPanel imgPanel;
   
    //������
    public B() {
        setTitle("�̹��� ���� �׽�Ʈ");
        setSize(200, 330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        imgPanel = new ChangeImagePanel();
        try {
            pic = ImageIO.read(new File("Image/O.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("�̹��� ����!");
        }
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(btn1 = new JButton("pic1"));
        btn1.addActionListener(this);
        panel.add(btn2 = new JButton("pic2"));
        btn2.addActionListener(this);
       
        add(imgPanel, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }
   
    class ChangeImagePanel extends JPanel {
        public ChangeImagePanel() {
        }
       
        @Override
        public void paint(Graphics g) {
            g.drawImage(pic, 0, 0, null);
        }
       
        @Override
        public Dimension getPreferredSize() {
            if (pic == null) {
                return new Dimension(200, 300);
            } else {
                return new Dimension(pic.getWidth(), pic.getHeight());
            }
        }
    }
   
    //����޼ҵ�
    @Override
    public void actionPerformed(ActionEvent e) {
        String imgFile = "";
       
        if (e.getSource() == btn1) {
            imgFile = "X.png";
		}else {
            imgFile = "remove.png";
		}

       
        try {
            pic = ImageIO.read(new File("Image/"+ imgFile));
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            System.out.println("�̹��� ����!");
        }
       
        imgPanel.repaint();
    }
   
    public static void main(String[] args) {
        new B();
    }
}