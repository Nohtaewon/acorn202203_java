package test.mypac;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/*
 * 1. JTextField �� ���ڿ��� �Է��ϰ� �߰� ��ư�� ������
 * �Է��� ���ڿ��� myFolder/memo.txt ���Ͽ� append �ǵ��� �غ�����
 * 
 * 2. �ҷ����� ��ư�� ������ myFolder/memo.txt ���Ͽ� �ִ� ��� ���ڿ���
 * 	  JTextArea �� ����ϵ��� �� ������..
 */
public class QuizMain2 extends JFrame implements ActionListener{
   //�ʵ�
   JTextField tf_msg;
   JTextArea area;
   FileWriter fw = null;
   FileReader fr=null;
   BufferedReader br=null;
   
   //������
   public QuizMain2() {
      setTitle("���� ������");
      setLayout(new BorderLayout());
      
      JPanel topPanel=new JPanel();
      //JTextField ��ü�� �������� �ʵ忡 ���� 
      tf_msg=new JTextField(10);
      
      JButton appendBtn=new JButton("�߰��ϱ�");
      JButton loadBtn=new JButton("�ҷ�����");
      appendBtn.setActionCommand("append");
      loadBtn.setActionCommand("load");
      appendBtn.addActionListener(this);
      loadBtn.addActionListener(this);
      
      topPanel.add(tf_msg);
      topPanel.add(appendBtn);
      topPanel.add(loadBtn);
      
      add(topPanel, BorderLayout.NORTH);
      topPanel.setBackground(Color.YELLOW);
      
      //JTextArea
      area=new JTextArea();
      //�������� ����� JTextArea  ��ġ�ϱ�
      add(area, BorderLayout.CENTER);
   
   }
   
   public static void main(String[] args) {
      QuizMain2 f=new QuizMain2();
      f.setBounds(100, 100, 500, 500);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
	   String command = e.getActionCommand();
	   String msg=tf_msg.getText();
	   try {
		   if(command.equals("append")) {
			   fw=new FileWriter("c:/acorn202203/myFolder/memo.txt", true);
			   fw.write("\r\n");
			   fw.write(msg);
			   fw.write("\r\n");
			   fw.flush();
			   System.out.println("���Ͽ� ���ڿ��� �����߽��ϴ�.");
		   }else if(command.equals("load")) {
			   fr=new FileReader("c:/acorn202203/myFolder/memo.txt");
			   br=new BufferedReader(fr);
			   while(true) {
				   String line=br.readLine();
				   if(line==null) {
					   break;
				   }
				   area.append(line);
				   area.append("\r\n");
			   }
			   
		   }
		}catch(Exception exe) {
				exe.printStackTrace();
		}finally {
				try {
					if(br!=null)br.close();
					if(fr!=null)fr.close();
					if(fw!=null)fw.close();
				}catch(Exception ex) {}
			}
		}
   }
   