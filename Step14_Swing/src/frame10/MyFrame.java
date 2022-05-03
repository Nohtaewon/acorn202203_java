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
 * - ���ڿ��� ���ڷ� �ٲٴ� ���
 * double num1=Double.parseDouble("���������� ���ڿ�");
 */
public class MyFrame extends JFrame implements ActionListener{
	JButton plusBtn;
	JButton minusBtn;
	JButton multiBtn;
	JButton divideBtn;
	JTextField tf_num1;
	JTextField tf_num2;
	JLabel label_result;
	
	//������
	public MyFrame(String title) {
		super(title);
		//BorderLayout ���� ���
		setLayout(new BorderLayout());
		
	      //JPanel
	      JPanel topPanel=new JPanel();
	      topPanel.setBackground(Color.YELLOW);
	      //Panel �� ���ʿ� ��ġ�ϱ� 
	      add(topPanel, BorderLayout.NORTH);
	      
	      //JTextField ��ü�� ���鿡�� JPanel �� �߰��ϱ� 
	      tf_num1=new JTextField(10);
	      topPanel.add(tf_num1);
	      //��� ��ư ��ü�� ���� JPanel �� �߰��ϱ�
	      plusBtn=new JButton("+");
	      minusBtn=new JButton("-");
	      multiBtn=new JButton("*");
	      divideBtn=new JButton("/");
	      topPanel.add(plusBtn);
	      topPanel.add(minusBtn);
	      topPanel.add(multiBtn);
	      topPanel.add(divideBtn);
	      //�ι�° JTextField  ���� ��ο� �߰� �ϱ� 
	      tf_num2=new JTextField(10);
	      topPanel.add(tf_num2);
	      //JLabel
	      JLabel label1=new JLabel("=");
	      label_result=new JLabel("0");
	      //��ο� ���̺� �߰��ϱ�
	      topPanel.add(label1);
	      topPanel.add(label_result);
	    
	      plusBtn.addActionListener(this);
	      minusBtn.addActionListener(this);
	      multiBtn.addActionListener(this);
	      divideBtn.addActionListener(this);

	}
	
	
	public static void main(String[] args) {
		JFrame f=new MyFrame("���� ������");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 500, 500);
		f.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//�Է��� ���ڿ��� �о�ͼ�
		String msg1=tf_num1.getText();
		String msg2=tf_num2.getText();
		//���ڷ� �ٲٱ�

		try {
			//���ڷ� �ٲٱ�
			double num1=Double.parseDouble(msg1);
			double num2=Double.parseDouble(msg2);//Exception �� �Ͼ �� �ִ� ��
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
			JOptionPane.showMessageDialog(this, "���� �������� �Է��ض�");
		} catch (ArithmeticException ae) {
			ae.printStackTrace();
		}
	}

}
