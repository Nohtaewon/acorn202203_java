package test.main;

import java.util.ArrayList;

/*
 * java ���� �迭�� ũ�⸦ ������ �� ���� ���� �迭�̴�.
 * 
 * ���� �������� item �� �߰��ϰ� �����ϰ� �ϴ� �۾��� �Ϸ��� �Ϲݹ迭�� ����� �� ����.
 * 
 * �׷��� �ش� �۾��� �Ϸ��� ArrayList ��ü�� ����ϸ� �ȴ�.
 */
public class MainClass01 {
	public static void main(String[] args) {
		//String type �� ������ �� �ִ� ArrayList ��ü����
		ArrayList<String> names=new ArrayList<>();
		
		ArrayList<Integer> nums=new ArrayList<>();
		nums.add(1);
		//"�豸��", "�ذ�", "������" 3���� String type �� ������ ������.
		names.add("�豸��");
		names.add("�ذ�");
		names.add("������");
		
		//0������ �������� �ҷ��ͼ� item �̶�� ������ ��ƺ�����
		String item=names.get(0);
		
		//1������ �������� �����Ϸ���?
		names.remove(1);
		
		//0���濡 "������" �� �ְ� ������?
		names.set(0, "������");
		
		//����� �������� ����(size) �� size ��� ���� ������ ��� ������
		int size=names.size();
		
		//����� ��� ������ ��ü ����
		names.clear();
	}
}