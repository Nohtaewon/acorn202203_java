package test.main;

import test.mypac.Game;
import test.mypac.HandPhone;
import test.mypac.Phone;
import test.mypac.SmartPhone;

public class AClass {
	public static void main(String[] args) {
		Phone p0=new Game();
		p0.call();
		
		Game p1=(Game)p0;
		p1.playGame();
		
		SmartPhone p2=(SmartPhone)p0;
		p2.doInternet();
		
		HandPhone p3=(HandPhone)p0;
		p3.takePicture();
		
//		Phone p4=new SmartPhone(); <= new �̰�() ���� new�� ���� �ߴ���
//		Game p5=(Game)p4;		   <= �̰� ������ ĳ���� ����
		
	}
}
