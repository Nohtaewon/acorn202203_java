package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import test.util.DBConnect;

public class MainClass15 {
	public static void main(String[] args) {
		//������ ȸ���� ������ �Է� �޴´�.
		Scanner scan=new Scanner(System.in);
		System.out.println("������ ȸ�� ��ȣ �Է�:");
		int num=scan.nextInt();
		
		boolean isSuccess=delete(num);
		
		if(isSuccess) {
			System.out.println(num+" �� ȸ���� �����߽��ϴ�.");
		}else {
			System.out.println(num+" �� ȸ���� �������� �ʽ��ϴ�.");
		}
		
	}
	/*
	 * ���ڷ� ���޵� ��ȣ�� �ش��ϴ� ȸ�� ������ �����ϰ� �۾��� �������θ� �����ϴ� �޼ҵ�
	 * 
	 * �۾��� �������θ� �����ϴ� �޼ҵ�� ��������
	 */
	public static boolean delete(int num) {
		//�޼ҵ尡 �� �۾��� ���� ���п��ΰ� ����
		Connection conn=null;
		PreparedStatement pstmt=null;
		int updatedRowCount=0;
		try {
			//DBConnect ��ü�� �̿��ؼ� Connection ��ü�� �������� ���´�.
			conn=new DBConnect().getConn();
			//������ �̿ϼ��� sql��
			String sql="DELETE FROM member"
					+ " WHERE num=?";//���������� �� ĭ�� �پ��
			//PreparedStatement ��ü�� ������ ������
			pstmt=conn.prepareStatement(sql);
			//?�� ���� ���ε��ؼ� �̿ϼ��� sql ���� �ϼ���Ų��.
			pstmt.setInt(1, num);
			//sql �� �����ϰ� ������(�߰�, ����, ����) row �� ���� ���� �ޱ�
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
			//������ ���
			return true;
		}else {
			//������ ���
			return false;
		}
		
		
	}
}