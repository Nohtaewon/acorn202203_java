package test.main;

import java.util.Random;

public class MainClass08 {
	public static void main(String[] args) {
		String[] items= {"cherry", "apple", "banana", "melon", "7"};
		//�ο��� ������ �̸� �迭�� �غ�
		int[] points={10, 20, 30, 40, 100};
		
		Random ran=new Random();
		
		int ranNum=ran.nextInt(5);
		System.out.println(items[ranNum]);
		//--------------------------------
		//0~4 ������ �����߿��� ������ ���� 3�� ����
		int ranNum2=ran.nextInt(5);
		int ranNum3=ran.nextInt(5);
		//���ڿ� �����ϱ�
		String line=items[ranNum]+"|"+items[ranNum2]+"|"+items[ranNum3];
		
		int jumsu=0;
		//���� ������ �������� ��� ���ٸ�
		if(ranNum==ranNum2&&ranNum2==ranNum3) {
			jumsu=points[ranNum];
		}
		
		//����ϱ�
		System.out.println(line);
		
		System.out.println("jumsu:"+jumsu);
	}
}
