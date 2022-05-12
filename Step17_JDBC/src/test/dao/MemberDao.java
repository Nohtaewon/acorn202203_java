package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MemberDao {
	   // 회원 한명의 정보를 이름으로 검색해주는 메소드
	   public List<MemberDto> getDataByName(String name){
	      List<MemberDto> list = new ArrayList<>();
	         MemberDto dto;
	      
	         //SELECT 작업을 위해서 필요한 객체의 참조값을 담을 지역변수 미리 만들기 
	         Connection conn=null;
	         PreparedStatement pstmt=null;
	         ResultSet rs=null;
	         try {
	            conn = new DBConnect().getConn();
	            String sql = "SELECT * FROM member" + " WHERE name LIKE '%'||?||'%'" + " ORDER BY num ASC";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, name);
	            rs = pstmt.executeQuery();
	         
	            while(rs.next()) {
	               dto = new MemberDto();
	               dto.setNum(rs.getInt("num"));
	               dto.setName(rs.getString("name"));
	               dto.setAddr(rs.getString("addr"));
	               list.add(dto);
	            }
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	         return list;
	      }
	
	//회원 정보를 저장하는 메소드
	public boolean insert(MemberDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int updatedRowCount=0;
		try {
			conn=new DBConnect().getConn();
			String sql="INSERT INTO member"
					+ " (num,name,addr)"
					+ " VALUES(member_seq.nextval,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			updatedRowCount=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(updatedRowCount>0) {
			return true;
		}else {
			return false;
		}
	}
	//회원 정보를 수정하는 메소드
	public boolean update(MemberDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int updatedRowCount=0;
		try {
			conn=new DBConnect().getConn();
			String sql="UPDATE member"
					+ " SET name=?, addr=?"
					+ " WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
			updatedRowCount=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(updatedRowCount>0) {
			return true;
		}else {
			return false;
		}
	}
	//회원 한명의 정보를 삭제하는 메소드
	public boolean delete(int num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int updatedRowCount=0;
		try {
			conn=new DBConnect().getConn();
			String sql="DELETE FROM member"
					+ " WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			updatedRowCount=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception e) {}
		}
		if(updatedRowCount>0) {
			return true;
		}else {
			return false;
		}
	}
	//회원 한명의 정보를 리턴하는 메소드
	public MemberDto getData(int num) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Connection conn=null;
		MemberDto dto=null; //
		try {
			conn=new DBConnect().getConn();
			String sql="SELECT name,addr FROM member"
					+ " WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				dto=new MemberDto();
				dto.setNum(num);
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
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
		return dto;
	}
	//회원 목록을 리턴하는 메소드
	public List<MemberDto> getList(){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Connection conn=null;
		List<MemberDto> list=new ArrayList<>();
		try {
			conn=new DBConnect().getConn();
			String sql="SELECT num,name,addr FROM member"
					+ " ORDER BY num ASC";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberDto md=new MemberDto();
				md.setNum(rs.getInt("num"));
				md.setName(rs.getString("name"));
				md.setAddr(rs.getString("addr"));
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
