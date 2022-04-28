package test.main;

import test.mypac.Car;
import test.mypac.MyObject;
import test.mypac.Radio;
import test.mypac.Speaker;

public class MainClass01 {
	public static void main(String[] args) {
		//MyObject 클래스에 정의된 3개의 메소드를 차례로 호출하는 code를 작성해 보세요.
		MyObject m=new MyObject();
		m.walk();
		int num=m.getNumber();
		String greet=m.getGreeting();
		Car car=m.getCar();
		
		// . setNum() .setName() .useCar() 메소드를 3개를 호출하는 code 작성
		m.setNum(10);
		m.setName("원숭이");
		m.useCar(new Car());
		
		//.listenMusic 메소드를 호출하는 code 를 작성해보세요
		m.listenMusic(new Radio(), new Speaker());//import 도 해줘야함
	}
}
