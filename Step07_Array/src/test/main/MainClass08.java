package test.main;

import java.util.Random;

public class MainClass08 {
	public static void main(String[] args) {
		String[] items= {"cherry", "apple", "banana", "melon", "7"};
		//부여할 점수도 미리 배열에 준비
		int[] points={10, 20, 30, 40, 100};
		
		Random ran=new Random();
		
		int ranNum=ran.nextInt(5);
		System.out.println(items[ranNum]);
		//--------------------------------
		//0~4 사이의 정수중에서 랜덤한 정수 3개 얻어내기
		int ranNum2=ran.nextInt(5);
		int ranNum3=ran.nextInt(5);
		//문자열 구성하기
		String line=items[ranNum]+"|"+items[ranNum2]+"|"+items[ranNum3];
		
		int jumsu=0;
		//만일 세개의 아이템이 모두 같다면
		if(ranNum==ranNum2&&ranNum2==ranNum3) {
			jumsu=points[ranNum];
		}
		
		//출력하기
		System.out.println(line);
		
		System.out.println("jumsu:"+jumsu);
	}
}
