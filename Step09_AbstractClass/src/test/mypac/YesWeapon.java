package test.mypac;

public class YesWeapon extends Weapon{
	
	@Override
	public void attack() {
		System.out.println("공격을 허가합니다.");
	}
}
