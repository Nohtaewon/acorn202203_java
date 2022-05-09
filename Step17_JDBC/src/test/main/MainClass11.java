package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.util.DBConnect;

public class MainClass11 {
	public static void main(String[] args) {
		//삭제할 회원의 번호라고 하자
		int num=4;
		MainClass11.delete(num);//같은 클래스안에 스태틱멤버기에 생략가능 스태틱빼면 안됨
	}
	
	public static void delete(int num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
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
			
			//sql 문  실행하기
			pstmt.executeUpdate();
			System.out.println("회원 정보를 저장했습니다.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
	}
}
