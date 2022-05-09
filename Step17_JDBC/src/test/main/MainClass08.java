package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import test.mypac.Member;
import test.util.DBConnect;

public class MainClass08 {
	public static void main(String[] args) {
		//추가할 회원의 정보
		String name="주뎅이";
		String addr="봉천동";
		//HashMap 객체를 생성해서
		Map<String, String> m= new HashMap<>();
		//추가할 회원정보를 담는다.
		m.put("name", name);
		m.put("addr", addr);
		
		//메소드 호출하면서 참조값을 전달
		insert(m);
	}
	
	//회원 한명의 정보를 추가하는 메소드
	public static void insert(Map<String, String> map) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//DBConnect 객체를 이용해서 Connection 객체의 참조값을 얻어온다.
			conn=new DBConnect().getConn();
			//실행할 미완성의 sql문
			String sql="INSERT INTO member"
					+ " (num,name,addr)"
					+ " VALUES(member_seq.nextval,?,?)";//습관적으로 한 칸씩 뛰어라
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			//?에 값을 바인딩해서 미완성의 sql 문을 완성시킨다.
			pstmt.setString(1, map.get("name"));
			pstmt.setString(2, map.get("addr"));
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
