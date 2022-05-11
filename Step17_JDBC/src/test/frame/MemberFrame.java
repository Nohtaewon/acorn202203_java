package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class MemberFrame extends JFrame implements ActionListener, PropertyChangeListener{
   //�ʵ�
   JTextField inputName, inputAddr;
   DefaultTableModel model;
   JTable table;
   MemberDao dao;
   
   //������ �غ��Ұ� ������ �����
   public MemberFrame() {
      setLayout(new BorderLayout());
      
      JLabel label1=new JLabel("�̸�");
      inputName=new JTextField(10);
      
      JLabel label2=new JLabel("�ּ�");
      inputAddr=new JTextField(10);
      
      JButton saveBtn=new JButton("����");
      saveBtn.setActionCommand("save");
      saveBtn.addActionListener(this);//��ư�� �������� ����
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
      
      add(panel, BorderLayout.NORTH);//JFrame �� �޼ҵ�
      
      //ǥ �������� ������ ����ϱ� ���� JTable(UI)
      table=new JTable();
      //Į������ String[] �� ������� �غ�
      String[] colNames= {"��ȣ", "�̸�", "�ּ�"};
      //���̺� ����� ������ ������ �ִ� �� ��ü (Į����, row ����) data
      model=new DefaultTableModel(colNames, 0) {
          @Override
          public boolean isCellEditable(int row, int column) {
             System.out.println(row+" | "+column);
             
             if(column==0) { // 0��° Į���� 
                return false; //���� �Ұ��ϰ� false �� ������ �ش�.
             }else { //�ٸ� ���� 
                return true; //��� ���� �����ϰ� true �� ������ �ش�. 
             }
          }
       };
      //���� ���̺� �����Ѵ�.
      table.setModel(model);
      //��ũ���� ���� �ϵ��� ���̺��� JScrollPane �� ���Ѵ�.
      JScrollPane scroll=new JScrollPane(table);
      //JScrollPane  �� �������� ����� ��ġ�ϱ� 
      add(scroll, BorderLayout.CENTER);
      
      displayMember();
      //���̺� ���� �ٲ������ ������ ������ ���
      table.addPropertyChangeListener(this);
   }
   //���̺� ������ ����ϴ� �޼ҵ�
   public void displayMember() {
	   model.setRowCount(0);
	   //���� DB�� ����� ������
	   dao=new MemberDao();
	   List<MemberDto> list=dao.getList();
	   for(MemberDto dto:list) {
		   //MemberDto ��ü�� �ִ� ȸ�������� �̿��ؼ� Object �迭�� �����.
		   Object[] row= {dto.getNum(), dto.getName(), dto.getAddr()};
		   model.addRow(row);
	   }
	   //model.setRowCount(0); ���̺� ��µ� ������ reset
	   //table.getSelectedRow(); ������Ŀ���� �ο츦 int�� ����
	   
   }
   //main  �޼ҵ�
   public static void main(String[] args) {
      MemberFrame f=new MemberFrame();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setBounds(100, 100, 800, 500);
      f.setVisible(true);
   }
   @Override
	public void actionPerformed(ActionEvent e) {
	   //������ ��ư�� action command ���� �о�ͼ�
	   String command = e.getActionCommand();
	   //�б��Ѵ�
	   try {
		   if(command.equals("save")) {
			   //1. �Է��� �̸���, �ּҸ� �о�´�.
			   String name=inputName.getText();
			   String addr=inputAddr.getText();
			   //2. �о�� �̸��� �ּҸ� MemberDto ��ü�� �����ؼ� ��´�
			   MemberDto dto=new MemberDto();
			   dto.setName(name);
			   dto.setAddr(addr);
			   //3. MemberDao ��ü�� �̿��ؼ� DB�� �������Ѵ�.
			   dao.insert(dto);
			   //4. refresh!
			   displayMember();
			   
		   }else if(command.equals("delete")) {
			   //1. ������ row �� �ִ���, �ִٸ� � row �� �����ߴ��� �˾Ƴ���
			   //int selectedIndex=table.getSelectedRow();
			   int[] rows=table.getSelectedRows();
			   if(rows.length==0) {//���ٸ� -1 ����
				   //���õ� row �� ���ٰ� �˷��ش�.
				   JOptionPane.showMessageDialog(this, "���õ� row �� �����ϴ�.");
				   //�����Ӿ� �ؿ� �ڵ�� ����������
				   return;
			   }
			   
			   for(int tmp:rows) {
				 //2. ������ row �� ���� ù��° Į���� �ִ� ���ڸ� �о��
				   int num=(int)model.getValueAt(tmp, 0); // Object Ÿ���̶� int�� ĳ����
				   //3. MemberDao ��ü�� �̿��ؼ� DB���� ����
				   dao.delete(num);
			   }   
			   //4. refresh!
			   displayMember();
		   }
	   	}catch(Exception exe) {
			exe.printStackTrace();
		}
	   
	}
   @Override
   public void propertyChange(PropertyChangeEvent evt) {
	   System.out.println("property change!");
	   System.out.println("property name:"+evt.getPropertyName());
	   
	   System.out.println("isEditing:"+table.isEditing());
	   /*
	    * property name �� "tableCellEditor" �̰�
	    * table �� �������� �ƴҶ�
	    * ���� ��Ŀ���� �ִ� ���� ������ ��� �о�ͼ� DB �� ���� �ݿ��ϱ�
	    */
	   
	   if(evt.getPropertyName().equals("tableCellEditor")&& !table.isEditing()) {
		   //���� ��Ŀ���� �ִ� row �� ������ DB�� ���� �ݿ��Ѵ�.
		   //��ȭ�� ���� �о�ͼ� DB �� �ݿ��Ѵ�. 
           //������ Į���� �ִ� row  ��ü�� ���� �о�´�. 
           int selectedIndex=table.getSelectedRow();
           int num=(int)model.getValueAt(selectedIndex, 0);
           String name=(String)model.getValueAt(selectedIndex, 1);
           String addr=(String)model.getValueAt(selectedIndex, 2);
           //������ ȸ���� ������ MemberDto ��ü�� ��� 
           MemberDto dto=new MemberDto(num, name, addr);
           //DB�� �����ϱ� 
           new MemberDao().update(dto);
           //���õ� ��Ŀ�� clear 
           table.clearSelection();
	   }
   }
	
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
