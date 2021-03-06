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
      
      JLabel label1=new JLabel("음식 이름");
      inputName=new JTextField(10);
      
      JLabel label2=new JLabel("음식점");
      inputAddr=new JTextField(10);
      
      JButton saveBtn=new JButton("저장");
      saveBtn.setBackground(Color.GREEN);
      saveBtn.setActionCommand("save");
      saveBtn.addActionListener(this);

      JButton deleteBtn=new JButton("삭제");
      deleteBtn.setBackground(Color.RED);
      deleteBtn.setActionCommand("delete");
      deleteBtn.addActionListener(this);
      //랜덤 버튼추가
      JButton randomBtn=new JButton("뭐 먹을래");
      randomBtn.setBackground(Color.LIGHT_GRAY);
      randomBtn.setToolTipText("랜덤으로 음식 이름이 나옵니다.");
      randomBtn.setActionCommand("random");
      randomBtn.addActionListener(this);
      
      JPanel panel=new JPanel();
      panel.add(label1);
      panel.add(inputName);
      panel.add(label2);
      panel.add(inputAddr);
      panel.add(saveBtn);
      panel.add(deleteBtn);
      //패널에 랜덤버튼 추가
      panel.add(randomBtn);
      
      add(panel, BorderLayout.NORTH);
      
      table=new JTable();
      String[] colNames= {"번호", "음식 이름", "음식점"};
      model=new DefaultTableModel(colNames, 0) {
          @Override
          public boolean isCellEditable(int row, int column) {
             System.out.println(row+" | "+column);
             
             if(column==0) {
                return false;
             }else {
                return true; 
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
			   if(rows.length==0) {
				   JOptionPane.showMessageDialog(this, "선택된 row 가 없습니다.","오류",JOptionPane.ERROR_MESSAGE);
				   return;
			   }
			   
			   for(int tmp:rows) {
				   int num=(int)model.getValueAt(tmp, 0);
				   dao.delete(num);
			   } 

		   }else if(command.equals("random")) {
			   model.setRowCount(0);
			   JOptionPane.showMessageDialog(this, dao.getRandom(1).getName()+" !!!","짜잔",JOptionPane.QUESTION_MESSAGE);
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