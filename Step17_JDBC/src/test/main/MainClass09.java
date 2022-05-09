package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import test.dto.MemberDto;
import test.mypac.Member;
import test.util.DBConnect;

public class MainClass09 {
	public static void main(String[] args) {
		//�߰��� ȸ���� ����
		String name="�ֵ���";
		String addr="��õ��";
		//MemberDto ��ü�� �����ؼ�
		MemberDto md=new MemberDto();
		//setter �޼ҵ带 �̿��ؼ� ȸ�������� ���
		md.setName(name);
		md.setAddr(addr);
		//�޼ҵ� ȣ���ϸ鼭 MemberDto ��ü�� ������ �����ϱ�
		insert(md);
	}
	
	//ȸ�� �Ѹ��� ������ �߰��ϴ� �޼ҵ�
	public static void insert(MemberDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//DBConnect ��ü�� �̿��ؼ� Connection ��ü�� �������� ���´�.
			conn=new DBConnect().getConn();
			//������ �̿ϼ��� sql��
			String sql="INSERT INTO member"
					+ " (num,name,addr)"
					+ " VALUES(member_seq.nextval,?,?)";//���������� �� ĭ�� �پ��
			//PreparedStatement ��ü�� ������ ������
			pstmt=conn.prepareStatement(sql);
			//?�� ���� ���ε��ؼ� �̿ϼ��� sql ���� �ϼ���Ų��.
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
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
