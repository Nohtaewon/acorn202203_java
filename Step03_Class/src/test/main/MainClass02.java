package test.main;

import test.mypac.MyUtil;

public class MainClass02 {
	public static String myName="김구하";
	public static void test() {
		System.out.println("test() 호출됨");
	}
	public static void main(String[] args) {
		MyUtil.send();
		MyUtil.version="1.0";
		System.out.println(myName);//같은공간안에 존재하면 클래스명을 생략 가능하기도하다 MainClass.Myname
		MainClass02.test();
		//this.test();// new MainClass02().test(); 참조값 필요
	}
}
