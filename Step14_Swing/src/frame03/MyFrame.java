package frame03;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	//������
	public MyFrame(String title) {
		super(title);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(2, 2));
		
		JButton btn1=new JButton("��ư1");
		add(btn1);//�����ӿ� btn1 �߰� �ϱ�
		
		JButton btn2=new JButton("��ư2");
		add(btn2);
		
		JButton btn3=new JButton("��ư3");
		add(btn3);
		
		JButton btn4=new JButton("��ư4");
		add(btn4);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame("���� ������");
	}
}