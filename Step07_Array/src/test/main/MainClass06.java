package test.main;

import java.util.Scanner;

public class MainClass06 {
	public static void main(String[] args) {
		/*
		 * 	Scanner ��ü�� �̿��ؼ� ���ڿ��� 5�� �Է� �޴´�.
		 * 	�Է� ���� ���ڿ��� ���ʴ�� �迭�� ���� �Ǿ�� �Ѵ�.
		 * 	��δ� �Է� ���� �� for ���� �̿��ؼ� �迭�� �����
		 * 	��� ���ڿ��� �ܼ�â�� ������� ����ϴ� �ڵ带 �ۼ��� ������.
		 */
		Scanner scan=new Scanner(System.in);
		String[] strs=new String[5];

		for(int i=0; i<strs.length; i++) {
			System.out.print("���ڿ� �Է�:");
			String str=scan.nextLine();
			strs[i]=str;
		}
		
		for(int i=0; i<strs.length;i++) {
			String tmp=strs[i];
			System.out.println(tmp);
		}
		
	}
}
