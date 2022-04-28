package test.main;

import test.mypac.Weapon;

public class MainClass05 {
	// 1
	static Weapon w1=new Weapon() {//익명클래스 
		//class ? extends Weapon{ }
		//Weapon 타입의 참조값을 얻어내는 방법
		@Override
		public void attack() {
			System.out.println("뭔진 모르겠지만 공격하자!");
		}
		
	};
	
	
	// 2
	public static void main(String[] args) {
		useWeapon(w1);
		
		Weapon w2=new Weapon() {

			@Override
			public void attack() {
				System.out.println("오잉? 이것도 공격하네?");
			}
		};
		useWeapon(w2);
		//3
		useWeapon(new Weapon() {

			@Override
			public void attack() {
				System.out.println("오잉? 이것도 공격하네?");
			}
		});
		
	}
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
