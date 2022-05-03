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
	JTextField inputMsg; //��ü�ȿ����� ���ڴ� private/ �� �� public /�Ⱥ��̸� ���� ��Ű���ȿ���
	JButton btn;
	//������
	public MyFrame(String title) {
		super(title);
		//���̾ƿ� ����
		setLayout(new FlowLayout());
		//������ JTextField ��ü�� �������� �ʵ忡 �����ϱ�
		inputMsg=new JTextField(10); //���������� ����� �����ھȿ����� �� ������
		//�׷��� ��𿡼��� �� �� �ְ� �ʵ带 �����ؼ� ������
		btn = new JButton("��������");
		//��ư�߰�
		add(inputMsg);
		add(btn);
		//��ư�� �������� ������ ��ü ����ϱ�
		btn.addActionListener(this);
	}
	//�ʵ�
//	static JFrame gura;
	
	public static void main(String[] args) {//static ����
		JFrame f=new MyFrame("���� ������");//�������� ���� �ҷ����� this ������
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 500, 500);
		f.setVisible(true);
		
//		MyFrame.gura=f;
	}
	@Override
	public void actionPerformed(ActionEvent e) {//������ �ٸ����� heap����
		//1. JTextField �� �Է��� ���ڿ��� �о�ͼ� / ���� this�� �ʵ� ����ų�� ��������
		String msg=this.inputMsg.getText();
		//2. �˸�â�� ����
		JOptionPane.showMessageDialog(this, msg); //���� ���� �ִ� �������� ������
		//MyFrame�� ��ü ����������  new MyFrame �� �� /MyFrame.gura
	}
}
