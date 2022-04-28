package test.main;

import test.mypac.Member;
import test.mypac.Student;

public class MainClass01 {
	public static void main(String[] args) {
		Student s1=new Student();
		s1.study();//지역변수에 넣어서 다시 사용할거라면
		
		new Student().study();//한번만 사용할거라면
		new Student().goSchool();
		Member m1=new Member(1, "김구라", "노량진");
		Member m2=new Member(2, "해골", "행신동");
		Member m3=new Member();
	}
}
