package test.main;

import test.mypac.Drill;

public class MainClass06 {
	public static void main(String[] args) {
		
		useDrill(new Drill() {//class ? implements Drill{}
			@Override
			public void hole() {
				System.out.println("�ٴڿ��� ������ �վ��!");
			}
		});
		
		useDrill(()->{//�޼ҵ��� ���ڷ� �޼ҵ忡 ����, �����޼ҵ尡 �ϳ��϶�
			System.out.println("õ�忡 ������ �վ��!");
		});
		
	}
	//1���� �߻�޼ҵ�� �����Ǿ� �ִ� Drill ��ü�� ���ڷ� ���޹޴� �޼ҵ�
	public static void useDrill(Drill d) {
		d.hole();
	}
}
