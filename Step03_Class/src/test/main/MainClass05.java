package test.main;

import test.mypac.Rect;

/*
 * Rect ��� �̸��� Ŭ������ ������� �Ѵ�.
 * 
 * �ش� Ŭ������ ��ü�� �����ϰ�
 * 
 * �簢���� ��(width)�� ���̸�(height) �� �ʵ忡 �����ϰ�
 * 
 *  showArea()�� ȣ���ϸ� �簢���� ���̰� �ܼ�â�� ��µ� �� �ֵ���
 *  
 *  Rect Ŭ������ �����غ�����.
 *  
 */
public class MainClass05 {
	public static void main(String[] args) {
		Rect r1=new Rect();
		r1.width=2;
		r1.height=3;
		r1.showArea();
		//�޼ҵ尡 �������ִ� ���� ������ ��ƺ���
		int area=r1.getArea();
	}
}
