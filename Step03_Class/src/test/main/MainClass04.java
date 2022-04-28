package test.main;

import test.mypac.Member;

public class MainClass04 {
	public static void main(String[] args) {
		//1. Member 객체를 생성해서
		Member m3=new Member();
		//2. 회원 한명의 정보를 담고
		m3.num=3;
		m3.name="원숭이";
		m3.addr="행도동";
		//3. showInfo() 메소드를 호출해 보세요.
		m3.showInfo();
	}
}
