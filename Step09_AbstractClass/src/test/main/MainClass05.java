package test.main;

import test.mypac.Weapon;

public class MainClass05 {
	// 1
	static Weapon w1=new Weapon() {//�͸�Ŭ���� 
		//class ? extends Weapon{ }
		//Weapon Ÿ���� �������� ���� ���
		@Override
		public void attack() {
			System.out.println("���� �𸣰����� ��������!");
		}
		
	};
	
	
	// 2
	public static void main(String[] args) {
		useWeapon(w1);
		
		Weapon w2=new Weapon() {

			@Override
			public void attack() {
				System.out.println("����? �̰͵� �����ϳ�?");
			}
		};
		useWeapon(w2);
		//3
		useWeapon(new Weapon() {

			@Override
			public void attack() {
				System.out.println("����? �̰͵� �����ϳ�?");
			}
		});
		
	}
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
