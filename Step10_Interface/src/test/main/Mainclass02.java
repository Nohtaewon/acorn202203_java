package test.main;

import test.mypac.Remocon;
import test.mypac.TaeRemocon;

public class Mainclass02 {
	public static void main(String[] args) {
		//���� Ŭ���� test.mypac ��Ű���� ���� useRemocon()�޼ҵ带 ���⼭ ȣ���� ������.
		Remocon r2=new TaeRemocon();
		useRemocon(r2);
	}
	
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
}
