package test.mypac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass02 {
	public static void main(String[] args) {
		//1 byte ó����Ʈ��
		//InputStream is=System.in;
		//2 byte ó����Ʈ��
		//InputStreamReader isr=new InputStreamReader(is);
		//���ڿ� 1�پ� �Է� ���� �� �ִ� ��ü
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("���ڿ� �Է�:");
		try {
			String line=br.readLine();
			System.out.println("line:"+line);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
}
