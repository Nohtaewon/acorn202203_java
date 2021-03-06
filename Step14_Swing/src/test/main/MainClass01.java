package test.main;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainClass01 {
	public static void main(String[] args) {
		JFrame f=new JFrame("Hello Frame");
		//초기 위치와 크기 지정
		f.setBounds(100, 100, 500, 500);
		//프레임을 닫았을 때 자동으로 프로세스 종료 되도록
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//레이아웃 매니저를 사용 하지 않도록 설정
		f.setLayout(null);
		//버튼 객체 생성해서
		JButton btn =new JButton("눌러보셈");
		//표시될 위치와 크기를 지정 후
		btn.setBounds(10, 10, 100, 40);
		//프레임에 추가하기
		f.add(btn);
		//프레임이 보이도록 한다.
		f.setVisible(true);
	}
}
