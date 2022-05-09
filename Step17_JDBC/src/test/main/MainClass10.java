package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass10 {
	public static void main(String[] args) {
		//������ ȸ���� ����
		int num=1;
		String name="ȣ��";
		String addr="�н���";
		
		//MemberDto ��ü�� ������ ȸ���� ������ ���
		MemberDto md=new MemberDto();
		md.setName(name);
		md.setAddr(addr);
		md.setNum(num);
		
		//�޼ҵ� ȣ���ϸ鼭 �����ϱ�
		update(md);
	}
	
	//ȸ�� 1���� ������ �����ϴ� �޼ҵ�
	public static void update(MemberDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//DBConnect ��ü�� �̿��ؼ� Connection ��ü�� �������� ���´�.
			conn=new DBConnect().getConn();
			//������ �̿ϼ��� sql��
			String sql="UPDATE member"
					+ " SET name=?, addr=?"
					+ " WHERE num=?";//���������� �� ĭ�� �پ��
			//PreparedStatement ��ü�� ������ ������
			pstmt=conn.prepareStatement(sql);
			//?�� ���� ���ε��ؼ� �̿ϼ��� sql ���� �ϼ���Ų��.
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
			//sql ��  �����ϱ�
			pstmt.executeUpdate();
			System.out.println("ȸ�� ������ �����߽��ϴ�.");
			
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
