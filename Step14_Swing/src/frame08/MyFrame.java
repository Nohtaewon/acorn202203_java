package frame08;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * JTextField ��ü�� �޼ҵ带 �� Ȱ���ؼ� 
 * �޼����� �Է��ϰ� �������� ��ư�� ������
 * �Է��� �޼����� �˸�â�� ��µǵ��� ���α׷��� �� ������
 */
public class MyFrame extends JFrame implements ActionListener{
	//�ʵ�
	JTextField inputMsg;
	JButton btn;
	//������
	public MyFrame(String title) {
		super(title);
		//���̾ƿ� ����
		setLayout(new FlowLayout());
		inputMsg=new JTextField(10);
		btn = new JButton("��������");
		//��ư�߰�
		add(inputMsg);
		add(btn);
		//��ư�� �������� 
		btn.addActionListener(this);
	}
	public static void main(String[] args) {
		JFrame f=new MyFrame("���� ������");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 500, 500);//a
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, inputMsg.getText());	
	}
}
