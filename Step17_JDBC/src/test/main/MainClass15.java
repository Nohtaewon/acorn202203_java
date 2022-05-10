package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import test.util.DBConnect;

public class MainClass15 {
	public static void main(String[] args) {
		//삭제할 회원의 정보르 입력 받는다.
		Scanner scan=new Scanner(System.in);
		System.out.println("삭제할 회원 번호 입력:");
		int num=scan.nextInt();
		
		boolean isSuccess=delete(num);
		
		if(isSuccess) {
			System.out.println(num+" 번 회원을 삭제했습니다.");
		}else {
			System.out.println(num+" 번 회원은 존재하지 않습니다.");
		}
		
	}
	/*
	 * 인자로 전달된 번호에 해당하는 회원 정보를 삭제하고 작업의 성공여부를 리턴하는 메소드
	 * 
	 * 작업의 성공여부를 리턴하는 메소드로 만들어보세요
	 */
	public static boolean delete(int num) {
		//메소드가 한 작업의 성공 실패여부가 전달
		Connection conn=null;
		PreparedStatement pstmt=null;
		int updatedRowCount=0;
		try {
			//DBConnect 객체를 이용해서 Connection 객체의 참조값을 얻어온다.
			conn=new DBConnect().getConn();
			//실행할 미완성의 sql문
			String sql="DELETE FROM member"
					+ " WHERE num=?";//습관적으로 한 칸씩 뛰어라
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			//?에 값을 바인딩해서 미완성의 sql 문을 완성시킨다.
			pstmt.setInt(1, num);
			//sql 문 실행하고 수정된(추가, 수정, 삭제) row 의 갯수 리턴 받기
			updatedRowCount=pstmt.executeUpdate(); //0 or 1
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception e) {}
		}
		if(updatedRowCount>0) {
			//성공인 경우
			return true;
		}else {
			//실패인 경우
			return false;
		}
		
		
	}
}
