package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass12 {
	public static void main(String[] args) {
		//메소드가 리턴해주는 전체 회원의 목록을 main 메소드 안에서 사용하고 싶다면?
		List<MemberDto> list=getList();//메소드를 호출해서 전체 회원목록을 받아온다.
		//전체 회원목록을 반복문으로 배열을 돌아서 내용찾고 .get메소드로 출력
		for(MemberDto tmp:list) {
			System.out.println(tmp.getNum()+"|"+tmp.getName()+"|"+tmp.getAddr());
		}
	}
	//전체 회원의 목록을 리턴해주는 메소드
	public static List<MemberDto> getList(){
			//SELECT 작업을 위해서 필요한 객체의 참조값을 담을 지역변수 미리 만들기
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			Connection conn=null;
			//MemberDto 를 포괄한 List 타입의 ArrayList 객체를 생성하여
			//정보를 담아 리턴해줄 객체를 생성
			List<MemberDto> list=new ArrayList<>();
			try {
				//DBConnect 객체를 이용해서 Connection 객체의 참조값을 얻어온다.
				conn=new DBConnect().getConn();
				//실행할 sql문
				String sql="SELECT num,name,addr FROM member"
						+ " ORDER BY num ASC";//습관적으로 한 칸씩 뛰어라
				//PreparedStatement 객체의 참조값 얻어오기
				pstmt=conn.prepareStatement(sql);
				//PreparedStatement 객체를 이용해서 query 문  수행하고 결과를
				//ResultSet 객체로 받아오기
				rs=pstmt.executeQuery();
				/*
				* ResultSet 객체의 .next() 메소드는 cursor 밑에 row 가 존재하는지 확인해서
				* 만일 존재하면 true 를 리턴하고 cursor 가 한칸 밑으로 이동한다.
				* 만일 존재하지않으면 false 를 리턴한다.
				*/
				while(rs.next()) {
					//MemberDto 객체를 생성해서
					MemberDto md=new MemberDto();
					//setter 메소드를 이용해서 현재 cursor가 위치한곳에 num이라는 칼럼의 정수를
					//얻어낸 정보를 담는다.
					md.setNum(rs.getInt("num"));
					md.setName(rs.getString("name"));
					md.setAddr(rs.getString("addr"));
					//호출하면서 MemberDto 객체의 참조값을 전달
					list.add(md);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(conn!=null)conn.close();
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
				}catch(Exception e) {}
			}
			
			return list;
	}
}


