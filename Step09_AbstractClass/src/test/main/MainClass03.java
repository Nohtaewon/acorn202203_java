package test.main;

import test.mypac.Zoo;
import test.mypac.Zoo.Monkey;
import test.mypac.Zoo.Tiger;
/*
 * Ŭ���� �ȿ� ���� Ŭ���� : inner class
 * �޼ҵ� �ȿ� ���� Ŭ���� : local inner class
 */
public class MainClass03 {
	public static void main(String[] args) {
		//Zoo Ŭ������ �ִ� getMonkey()�޼ҵ带 ȣ���ؼ�
		//���� �Ǵ� ���� m1 �̶�� ���� ������ ��� ������.
		Zoo z=new Zoo();
		Monkey m1=z.getMonkey();
		m1.say();
		//Zoo Ŭ������ �ִ� getMonkey()�޼ҵ带 ȣ���ؼ�
		//���� �Ǵ� ���� m1 �̶�� ���� ������ ��� ������.
		Tiger m2=z.getTiger();
		m2.say();
		
		//�޼ҵ� �ȿ��� Ŭ������ ���� �� �� �ִ�. �޼ҵ�ȿ����� �� �� �ִ�.
		class Gura{
			public void say() {
				System.out.println("�ȳ� ���� �����!");
			}
		}
		
		Gura g1=new Gura();
		g1.say();
	}
}
