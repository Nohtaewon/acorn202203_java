package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass17 {
	public static void main(String[] args) {
		//수정할 회원 정보를 입력받아서
		Scanner scan=new Scanner(System.in);
		System.out.print("이름 입력:");
		String name=scan.nextLine();//개행기호를 기준으로 한줄을 읽음
		System.out.print("주소 입력:");
		String addr=scan.nextLine();
		System.out.print("번호 입력:");
		int num=scan.nextInt();
		//회원 정보를 MemberDto 객체에 담고
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		dto.setNum(num);
		//메소드를 호출하면서 전달해서 회원 정보를 추가 하고 성공여부를 리턴 받는다.
		boolean isSuccess=update(dto);
		if(isSuccess) {
			System.out.println(name+" 의 정보를 수정 했습니다.");
		}else {
			System.out.println(name+" 정보 수정 실패!");
		}
		
	}
	
	public static boolean update(MemberDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			//DBConnect 객체를 이용해서 Connection 객체의 참조값을 얻어온다.
			conn=new DBConnect().getConn();
			//실행할 미완성의 sql문
			String sql="UPDATE member"
					+ " SET name=?, addr=?"
					+ " WHERE num=?";//습관적으로 한 칸씩 뛰어라
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			//?에 값을 바인딩해서 미완성의 sql 문을 완성시킨다.
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
			//sql 문  실행하기
			flag=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(flag>0) {
			//성공인 경우
			return true;
		}else {
			//실패인 경우
			return false;
		}
	}
}
