package test.main;

import test.mypac.Weapon;
import test.mypac.YesWeapon;

public class MainClass02 {
	public static void main(String[] args) {
		//�������� ���� Ŭ������ ����� ��ü ������ �ؼ� �Ʒ��� useWeapon()���ҵ带 ȣ���� ������.
		Weapon w2=new YesWeapon();
		MainClass02.useWeapon(w2);
	}
	//�� �޼ҵ�� ���� ������ ������ �ϴ� �޼ҵ��� ��������
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
