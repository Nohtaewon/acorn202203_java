package test.main;

import test.mypac.Remocon;
import test.mypac.TaeRemocon;

public class Mainclass02 {
	public static void main(String[] args) {
		//직접 클래스 test.mypac 패키지에 만들어서 useRemocon()메소드를 여기서 호출해 보세요.
		Remocon r2=new TaeRemocon();
		useRemocon(r2);
	}
	
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
}
