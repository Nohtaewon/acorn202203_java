package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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

import test.dao.FoodDao;
import test.dto.FoodDto;


public class FoodFrame extends JFrame implements ActionListener, PropertyChangeListener{

   JTextField inputName, inputAddr;
   DefaultTableModel model;
   JTable table;
   FoodDao dao;
   
   public FoodFrame() {
      setLayout(new BorderLayout());
      
      JLabel label1=new JLabel("���� �̸�");
      inputName=new JTextField(10);
      
      JLabel label2=new JLabel("������");
      inputAddr=new JTextField(10);
      
      JButton saveBtn=new JButton("����");
      saveBtn.setBackground(Color.GREEN);
      saveBtn.setActionCommand("save");
      saveBtn.addActionListener(this);

      JButton deleteBtn=new JButton("����");
      deleteBtn.setBackground(Color.RED);
      deleteBtn.setActionCommand("delete");
      deleteBtn.addActionListener(this);
      //���� ��ư�߰�
      JButton randomBtn=new JButton("�� ������");
      randomBtn.setBackground(Color.LIGHT_GRAY);
      randomBtn.setToolTipText("�������� ���� �̸��� ���ɴϴ�.");
      randomBtn.setActionCommand("random");
      randomBtn.addActionListener(this);
      
      JPanel panel=new JPanel();
      panel.add(label1);
      panel.add(inputName);
      panel.add(label2);
      panel.add(inputAddr);
      panel.add(saveBtn);
      panel.add(deleteBtn);
      //�гο� ������ư �߰�
      panel.add(randomBtn);
      
      add(panel, BorderLayout.NORTH);
      
      table=new JTable();
      String[] colNames= {"��ȣ", "���� �̸�", "������"};
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
      table.setModel(model);
      JScrollPane scroll=new JScrollPane(table);
      add(scroll, BorderLayout.CENTER);
      
      displayFood();
      table.addPropertyChangeListener(this);
      
   }
   public void displayFood() {
	   model.setRowCount(0);
	   dao=new FoodDao();
	   List<FoodDto> list=dao.getList();
	   for(FoodDto dto:list) {
		   model.addRow(new Object[] {
			dto.getNum(), 
			dto.getName(),
			dto.getAddr()
		   });
	   }
   }
   public static void main(String[] args) {
      FoodFrame f=new FoodFrame();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setBounds(100, 100, 800, 600);
      f.setVisible(true);
      
   }
   @Override
	public void actionPerformed(ActionEvent e) {
	   String command = e.getActionCommand();
	   try {
		   if(command.equals("save")) {
			   FoodDto dto=new FoodDto();
			   dto.setName(inputName.getText());
			   dto.setAddr(inputAddr.getText());
			   dao.insert(dto);
			   inputName.setText("");
	           inputAddr.setText("");

		   }else if(command.equals("delete")) {
			   int[] rows=table.getSelectedRows();
			   if(rows.length==0) {//���ٸ� -1 ����
				   //���õ� row �� ���ٰ� �˷��ش�.
				   JOptionPane.showMessageDialog(this, "���õ� row �� �����ϴ�.","����",JOptionPane.ERROR_MESSAGE);
				   //�����Ӿ� �ؿ� �ڵ�� ����������
				   return;
			   }
			   
			   for(int tmp:rows) {
				 //2. ������ row �� ���� ù��° Į���� �ִ� ���ڸ� �о��
				   int num=(int)model.getValueAt(tmp, 0); // Object Ÿ���̶� int�� ĳ����
				   //3. MemberDao ��ü�� �̿��ؼ� DB���� ����
				   dao.delete(num);
			   } 

		   }else if(command.equals("random")) {
			   //������ ������ �� �˸�â�� ���ߵ� �� �ְ� ���̺��� �����
			   model.setRowCount(0);
			   //�˸�â�� �������� ���� row�� name�� �����´�.
			   JOptionPane.showMessageDialog(this, dao.getRandom(1).getName()+".. ��ðڽ��ϱ�?","¥��",JOptionPane.QUESTION_MESSAGE);
		   }
		   displayFood();
	   	}catch(Exception exe) {
			exe.printStackTrace();
		}
	   
	}
   @Override
   public void propertyChange(PropertyChangeEvent evt) {
	System.out.println("property change!");
	   System.out.println("property name:"+evt.getPropertyName());
	   
	   System.out.println("isEditing:"+table.isEditing());

	   if(evt.getPropertyName().equals("tableCellEditor")&& !table.isEditing()) {
		   int selectedIndex=table.getSelectedRow();
		   int num=(int)model.getValueAt(selectedIndex, 0);
		   String name=(String)model.getValueAt(selectedIndex, 1);
		   String addr=(String)model.getValueAt(selectedIndex, 2);
		   FoodDto dto=new FoodDto(num, name, addr);
		   new FoodDao().update(dto);
		   table.clearSelection();
	   }
   }
}