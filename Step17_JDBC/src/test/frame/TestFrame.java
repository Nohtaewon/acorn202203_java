package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.MemberDao;
import test.dto.MemberDto;
/*
 *1. ���õ� row �ε����� �о�´�.
 *	int selectedIndex=table.getSelectedRow();
 *
 *2. ���õ� row �� ù��°(0��°) Į���� ���ڸ� �о�´�(������ ȸ���� ��ȣ)
 *	int num=(int)model.getValueAt(selectedIndex, 0);
 */
public class TestFrame extends JFrame implements ActionListener{
   //�ʵ�
   JTextField inputName, inputAddr;
   DefaultTableModel model;
   JTable table;
   MemberDao dao;
   
   //������
   public TestFrame() {
      setLayout(new BorderLayout());
      
      JLabel label1=new JLabel("�̸�");
      inputName=new JTextField(10);
      
      JLabel label2=new JLabel("�ּ�");
      inputAddr=new JTextField(10);
      
      JButton saveBtn=new JButton("����");
      saveBtn.setActionCommand("save");
      saveBtn.addActionListener(this);
      //���� ��ư �߰�
      JButton deleteBtn=new JButton("����");
      deleteBtn.setActionCommand("delete");
      deleteBtn.addActionListener(this);
      
      JPanel panel=new JPanel();
      panel.add(label1);
      panel.add(inputName);
      panel.add(label2);
      panel.add(inputAddr);
      panel.add(saveBtn);
      panel.add(deleteBtn);
      
      add(panel, BorderLayout.NORTH);
      
      //ǥ �������� ������ ����ϱ� ���� JTable(UI)
      table=new JTable();
      //Į������ String[] �� ������� �غ�
      String[] colNames= {"��ȣ", "�̸�", "�ּ�"};
      //���̺� ����� ������ ������ �ִ� �� ��ü (Į����, row ����) data
      model=new DefaultTableModel(colNames, 0);
      //���� ���̺� �����Ѵ�.
      table.setModel(model);
      //��ũ���� ���� �ϵ��� ���̺��� JScrollPane �� ���Ѵ�.
      JScrollPane scroll=new JScrollPane(table);
      //JScrollPane  �� �������� ����� ��ġ�ϱ� 
      add(scroll, BorderLayout.CENTER);
      
      displayMember();
   }
   //���̺� ������ ����ϴ� �޼ҵ�
   public void displayMember() {
	   dao=new MemberDao();
	   List<MemberDto> list=dao.getList();
	   for(MemberDto dto:list) {
		   model.addRow(new Object[] {
			dto.getNum(), 
			dto.getName(),
			dto.getAddr()
		   });
	   }
	   //model.setRowCount(0); ���̺� ��µ� ������ reset
	   //table.getSelectedRow(); ������Ŀ���� �ο츦 int�� ����
	   
   }
   //main  �޼ҵ�
   public static void main(String[] args) {
      TestFrame f=new TestFrame();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setBounds(100, 100, 800, 500);
      f.setVisible(true);
   }
   @Override
	public void actionPerformed(ActionEvent e) {
	   String command = e.getActionCommand();
	   try {
		   if(command.equals("save")) {
			   MemberDto dto=new MemberDto();
			   dto.setName(inputName.getText());
			   dto.setAddr(inputAddr.getText());
			   dao.insert(dto);
			   model.setRowCount(0);
			   
		   }else if(command.equals("delete")) {
			   int selectedIndex=table.getSelectedRow();
			   int num=(int)model.getValueAt(selectedIndex, 0);
			   dao.delete(num);
			   model.setRowCount(0);
			   
		   }
		   displayMember();
	   	}catch(Exception exe) {
			exe.printStackTrace();
		}
	   
	}
	
}
