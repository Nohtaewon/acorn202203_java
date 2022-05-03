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
	JTextField inputMsg; //객체안에서만 쓰겠다 private/ 다 써 public /안붙이면 같은 패키지안에서
	JButton btn;
	//생성자
	public MyFrame(String title) {
		super(title);
		//레이아웃 설정
		setLayout(new FlowLayout());
		//생성한 JTextField 객체의 참조값을 필드에 저장하기
		inputMsg=new JTextField(10); //지역변수로 만들면 생성자안에서만 쓸 수있음
		//그래서 어디에서든 쓸 수 있게 필드를 선언해서 가져옴
		btn = new JButton("눌러보셈");
		//버튼추가
		add(inputMsg);
		add(btn);
		//버튼을 눌렀을때 감시할 객체 등록하기
		btn.addActionListener(this);
	}
	//필드
//	static JFrame gura;
	
	public static void main(String[] args) {//static 영역
		JFrame f=new MyFrame("나의 프레임");//참조값에 점찍어서 불러야함 this 사용못함
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 500, 500);
		f.setVisible(true);
		
//		MyFrame.gura=f;
	}
	@Override
	public void actionPerformed(ActionEvent e) {//위에와 다른영역 heap영역
		//1. JTextField 에 입력한 문자열을 읽어와서 / 여기 this는 필드 가리킬때 생략가능
		String msg=this.inputMsg.getText();
		//2. 알림창에 띄우기
		JOptionPane.showMessageDialog(this, msg); //내가 속해 있는 프레임의 참조값
		//MyFrame의 객체 생성했을때  new MyFrame 할 때 /MyFrame.gura
	}
}
