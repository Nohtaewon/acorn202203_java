package test.main;

import test.mypac.Car;
import test.mypac.MyObject;
import test.mypac.Radio;
import test.mypac.Speaker;

public class MainClass01 {
	public static void main(String[] args) {
		//MyObject Ŭ������ ���ǵ� 3���� �޼ҵ带 ���ʷ� ȣ���ϴ� code�� �ۼ��� ������.
		MyObject m=new MyObject();
		m.walk();
		int num=m.getNumber();
		String greet=m.getGreeting();
		Car car=m.getCar();
		
		// . setNum() .setName() .useCar() �޼ҵ带 3���� ȣ���ϴ� code �ۼ�
		m.setNum(10);
		m.setName("������");
		m.useCar(new Car());
		
		//.listenMusic �޼ҵ带 ȣ���ϴ� code �� �ۼ��غ�����
		m.listenMusic(new Radio(), new Speaker());//import �� �������
	}
}
