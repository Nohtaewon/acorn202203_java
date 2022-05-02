package frame08;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * JTextField 객체의 메소드를 잘 활용해서 
 * 메세지를 입력하고 눌러보셈 버튼을 누르면
 * 입력한 메세지가 알림창에 출력되도록 프로그래밍 해 보세요
 */
public class MyFrame extends JFrame implements ActionListener{
	//필드
	JTextField inputMsg;
	JButton btn;
	//생성자
	public MyFrame(String title) {
		super(title);
		//레이아웃 설정
		setLayout(new FlowLayout());
		inputMsg=new JTextField(10);
		btn = new JButton("눌러보셈");
		//버튼추가
		add(inputMsg);
		add(btn);
		//버튼을 눌렀을때 
		btn.addActionListener(this);
	}
	public static void main(String[] args) {
		JFrame f=new MyFrame("나의 프레임");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 500, 500);//a
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, inputMsg.getText());	
	}
}
