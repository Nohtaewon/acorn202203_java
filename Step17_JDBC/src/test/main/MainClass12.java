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
		//�޼ҵ尡 �������ִ� ��ü ȸ���� ����� main �޼ҵ� �ȿ��� ����ϰ� �ʹٸ�?
		List<MemberDto> list=getList();//�޼ҵ带 ȣ���ؼ� ��ü ȸ������� �޾ƿ´�.
		//��ü ȸ������� �ݺ������� �迭�� ���Ƽ� ����ã�� .get�޼ҵ�� ���
		for(MemberDto tmp:list) {
			System.out.println(tmp.getNum()+"|"+tmp.getName()+"|"+tmp.getAddr());
		}
	}
	//��ü ȸ���� ����� �������ִ� �޼ҵ�
	public static List<MemberDto> getList(){
			//SELECT �۾��� ���ؼ� �ʿ��� ��ü�� �������� ���� �������� �̸� �����
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			Connection conn=null;
			//MemberDto �� ������ List Ÿ���� ArrayList ��ü�� �����Ͽ�
			//������ ��� �������� ��ü�� ����
			List<MemberDto> list=new ArrayList<>();
			try {
				//DBConnect ��ü�� �̿��ؼ� Connection ��ü�� �������� ���´�.
				conn=new DBConnect().getConn();
				//������ sql��
				String sql="SELECT num,name,addr FROM member"
						+ " ORDER BY num ASC";//���������� �� ĭ�� �پ��
				//PreparedStatement ��ü�� ������ ������
				pstmt=conn.prepareStatement(sql);
				//PreparedStatement ��ü�� �̿��ؼ� query ��  �����ϰ� �����
				//ResultSet ��ü�� �޾ƿ���
				rs=pstmt.executeQuery();
				/*
				* ResultSet ��ü�� .next() �޼ҵ�� cursor �ؿ� row �� �����ϴ��� Ȯ���ؼ�
				* ���� �����ϸ� true �� �����ϰ� cursor �� ��ĭ ������ �̵��Ѵ�.
				* ���� �������������� false �� �����Ѵ�.
				*/
				while(rs.next()) {
					//MemberDto ��ü�� �����ؼ�
					MemberDto md=new MemberDto();
					//setter �޼ҵ带 �̿��ؼ� ���� cursor�� ��ġ�Ѱ��� num�̶�� Į���� ������
					//�� ������ ��´�.
					md.setNum(rs.getInt("num"));
					md.setName(rs.getString("name"));
					md.setAddr(rs.getString("addr"));
					//ȣ���ϸ鼭 MemberDto ��ü�� �������� ����
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


