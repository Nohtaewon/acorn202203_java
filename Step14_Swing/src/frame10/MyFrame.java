package frame10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*
 * hint
 * 
 * - 문자열을 숫자로 바꾸는 방법
 * double num1=Double.parseDouble("숫자형태의 문자열");
 */
public class MyFrame extends JFrame implements ActionListener{
	JButton plusBtn;
	JButton minusBtn;
	JButton multiBtn;
	JButton divideBtn;
	JTextField tf_num1;
	JTextField tf_num2;
	JLabel label_result;
	
	//생성자
	public MyFrame(String title) {
		super(title);
		//BorderLayout 으로 사용
		setLayout(new BorderLayout());
		
	      //JPanel
	      JPanel topPanel=new JPanel();
	      topPanel.setBackground(Color.YELLOW);
	      //Panel 을 북쪽에 배치하기 
	      add(topPanel, BorderLayout.NORTH);
	      
	      //JTextField 객체를 만들에서 JPanel 에 추가하기 
	      tf_num1=new JTextField(10);
	      topPanel.add(tf_num1);
	      //기능 버튼 객체를 만들어서 JPanel 에 추가하기
	      plusBtn=new JButton("+");
	      minusBtn=new JButton("-");
	      multiBtn=new JButton("*");
	      divideBtn=new JButton("/");
	      topPanel.add(plusBtn);
	      topPanel.add(minusBtn);
	      topPanel.add(multiBtn);
	      topPanel.add(divideBtn);
	      //두번째 JTextField  만들어서 페널에 추가 하기 
	      tf_num2=new JTextField(10);
	      topPanel.add(tf_num2);
	      //JLabel
	      JLabel label1=new JLabel("=");
	      label_result=new JLabel("0");
	      //페널에 레이블 추가하기
	      topPanel.add(label1);
	      topPanel.add(label_result);
	    
	      plusBtn.addActionListener(this);
	      minusBtn.addActionListener(this);
	      multiBtn.addActionListener(this);
	      divideBtn.addActionListener(this);

	}
	
	
	public static void main(String[] args) {
		JFrame f=new MyFrame("나의 프레임");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 500, 500);
		f.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//입력한 문자열을 읽어와서
		String msg1=tf_num1.getText();
		String msg2=tf_num2.getText();
		//숫자로 바꾸기

		try {
			//숫자로 바꾸기
			double num1=Double.parseDouble(msg1);
			double num2=Double.parseDouble(msg2);//Exception 이 일어날 수 있는 곳
			Object o=e.getSource();
			if(o==plusBtn) {
				double result=num1+num2;
				label_result.setText(Double.toString(result));
			}else if(o==minusBtn) {
				double result=num1-num2;
				label_result.setText(Double.toString(result));
			}else if(o==multiBtn) {
				double result=num1*num2;
				label_result.setText(Double.toString(result));
			}else if(o==divideBtn) {
				double result=num1/num2;
				label_result.setText(Double.toString(result));
			}
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
			JOptionPane.showMessageDialog(this, "숫자 형식으로 입력해라");
		} catch (ArithmeticException ae) {
			ae.printStackTrace();
		}
	}

}
