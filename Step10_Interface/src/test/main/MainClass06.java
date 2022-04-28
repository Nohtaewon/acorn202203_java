package test.main;

import test.mypac.Drill;

public class MainClass06 {
	public static void main(String[] args) {
		
		useDrill(new Drill() {//class ? implements Drill{}
			@Override
			public void hole() {
				System.out.println("바닥에서 구멍을 뚫어요!");
			}
		});
		
		useDrill(()->{//메소드의 인자로 메소드에 전달, 오직메소드가 하나일때
			System.out.println("천장에 구멍을 뚫어요!");
		});
		
	}
	//1개의 추상메소드로 구성되어 있는 Drill 객체를 인자로 전달받는 메소드
	public static void useDrill(Drill d) {
		d.hole();
	}
}
