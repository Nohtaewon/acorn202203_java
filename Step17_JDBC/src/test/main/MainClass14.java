package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.dto.MemberDto;
import test.util.DBConnect;
/*
 * hint
 * 
 * select num, name, addr
 * from member
 * where num=?
 * 
 * .setInt(1,num)
 */
public class MainClass14 {
	public static void main(String[] args) {
		//�޼ҵ带 ȣ���ؼ� ���ڷ� ������ ��ȣ�� �ش��ϴ� ȸ�� ������ ���ͼ�
		MemberDto dto=getData(1);
		if(dto!=null) {
		//����ϱ�
			System.out.println("��ȣ:"+dto.getNum()+" �̸�:"+dto.getName()+" �ּ�:"+dto.getAddr());
		}else {
			System.out.println("�ش� ȸ���� �������� �ʴ´�");
		}
	}
	//���ڷ� ���޵� ��ȣ�� �ش��ϴ� ȸ�� �Ѹ��� ������ �����ϴ� �޼ҵ�
	public static MemberDto getData(int num){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Connection conn=null;
		//MemberDto ��ü�� ���� ���������� �̸������.
		MemberDto dto=null; //
		try {
			
			conn=new DBConnect().getConn();
			String sql="SELECT name,addr FROM member"
					+ " WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			while(rs.next()) {//if �� �ᵵ ��
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
}
