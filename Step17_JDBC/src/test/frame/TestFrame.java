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
 *1. 선택된 row 인덱스를 읽어온다.
 *	int selectedIndex=table.getSelectedRow();
 *
 *2. 선택된 row 의 첫번째(0번째) 칼럼의 숫자를 읽어온다(삭제할 회원의 번호)
 *	int num=(int)model.getValueAt(selectedIndex, 0);
 */
public class TestFrame extends JFrame implements ActionListener{
   //필드
   JTextField inputName, inputAddr;
   DefaultTableModel model;
   JTable table;
   MemberDao dao;
   
   //생성자
   public TestFrame() {
      setLayout(new BorderLayout());
      
      JLabel label1=new JLabel("이름");
      inputName=new JTextField(10);
      
      JLabel label2=new JLabel("주소");
      inputAddr=new JTextField(10);
      
      JButton saveBtn=new JButton("저장");
      saveBtn.setActionCommand("save");
      saveBtn.addActionListener(this);
      //삭제 버튼 추가
      JButton deleteBtn=new JButton("삭제");
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
      
      //표 형식으로 정보를 출력하기 위한 JTable(UI)
      table=new JTable();
      //칼럼명을 String[] 에 순서대로 준비
      String[] colNames= {"번호", "이름", "주소"};
      //테이블에 출력할 정보를 가지고 있는 모델 객체 (칼럼명, row 갯수) data
      model=new DefaultTableModel(colNames, 0);
      //모델을 테이블에 연결한다.
      table.setModel(model);
      //스크롤이 가능 하도록 테이블을 JScrollPane 에 감싼다.
      JScrollPane scroll=new JScrollPane(table);
      //JScrollPane  을 프레임의 가운데에 배치하기 
      add(scroll, BorderLayout.CENTER);
      
      displayMember();
   }
   //테이블에 데이터 출력하는 메소드
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
	   //model.setRowCount(0); 테이블에 출력된 데이터 reset
	   //table.getSelectedRow(); 현재포커스된 로우를 int로 리턴
	   
   }
   //main  메소드
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
