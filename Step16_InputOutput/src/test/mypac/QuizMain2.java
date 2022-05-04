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
 * 1. JTextField 에 문자열을 입력하고 추가 버튼을 누르면
 * 입력한 문자열이 myFolder/memo.txt 파일에 append 되도록 해보세요
 * 
 * 2. 불러오기 버튼을 누르면 myFolder/memo.txt 파일에 있는 모든 문자열을
 * 	  JTextArea 에 출력하도록 해 보세요..
 */
public class QuizMain2 extends JFrame implements ActionListener{
   //필드
   JTextField tf_msg;
   JTextArea area;
   FileWriter fw = null;
   FileReader fr=null;
   BufferedReader br=null;
   
   //생성자
   public QuizMain2() {
      setTitle("나의 프레임");
      setLayout(new BorderLayout());
      
      JPanel topPanel=new JPanel();
      //JTextField 객체의 참조값을 필드에 저장 
      tf_msg=new JTextField(10);
      
      JButton appendBtn=new JButton("추가하기");
      JButton loadBtn=new JButton("불러오기");
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
      //프레임의 가운데에 JTextArea  배치하기
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
			   System.out.println("파일에 문자열을 저장했습니다.");
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
   