package test.main;

import test.mypac.HandPhone;
import test.mypac.SmartPhone;

public class MainClass05 {
	public static void main(String[] args) {
		
		//자식에게 사준 일반 핸드폰(인터넷이 안됨)
		HandPhone p1=new HandPhone();
		
		//나도 스마트폰 갖고 싶어!
		
		//엄마가 새로운 설명서를 가지고 왔어 이제 그 폰은 스마트폰이야
		SmartPhone p2=(SmartPhone)p1;//ClassCastException 발생!
		//객체가 핸드폰이라 핸드폰까지만 쓸 수 있음
		//진짜? 나 이제 인터넷한다.
		p2.doInternet();
	}
}
