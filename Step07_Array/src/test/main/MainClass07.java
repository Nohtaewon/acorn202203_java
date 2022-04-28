package test.main;

import java.util.Random;

/*
 * 1. cherry, apple, banana, melon, 7
 * 	  5개의 문자열 중에서 1개가 랜덤하게 출력되게 해 보세요.
 * 2. 5개의 문자열 중에서 3개가 한줄에 한번에 랜덤하게 출력되게 해 보세요.
 *    예) cherry | apple | cherry
 *    		7 | apple | melon
 *    		7 | 7 | 7
 *    
 *    -hint
 *    
 *    String[] items={"cherry", "apple", "banana", "melon", "7"}
 *    
 *    Random ran=new Random();
 *    int ranNum=ran.nextInt(5);
 */
public class MainClass07 {
	public static void main(String[] args) {
		String[] items= {"cherry", "apple", "banana", "melon", "7"};
		Random ran=new Random();
		
		int ranNum=ran.nextInt(5);
		System.out.println(items[ranNum]);
		//--------------------------------
		//0~4 사이의 정수중에서 랜덤한 정수 3개 얻어내기
		int ranNum2=ran.nextInt(5);
		int ranNum3=ran.nextInt(5);
		//문자열 출력하기
		System.out.println(items[ranNum]+"|"+items[ranNum2]+"|"+items[ranNum3]);
		//----------------------------------
		
		String[] items2=new String[3];
		for(int i=0; i<3; i++) {
			int num2=ran.nextInt(items.length);
			items2[i]=items[num2];
		}
		System.out.println(items2[0]+"|"+items2[1]+"|"+items[2]);
		
		int[] random= {0,0,0};
	    for( int i=0; i<random.length; i++) {
	        random[i]=ran.nextInt(5);
	    }
	    System.out.println(items[random[0]] +"|"+items[random[1]]+"|"+items[random[2]]);
		
	
	}
}
