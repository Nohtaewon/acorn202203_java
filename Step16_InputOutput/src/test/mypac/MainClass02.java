package test.mypac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass02 {
	public static void main(String[] args) {
		//1 byte 처리스트림
		//InputStream is=System.in;
		//2 byte 처리스트림
		//InputStreamReader isr=new InputStreamReader(is);
		//문자열 1줄씩 입력 받을 수 있는 객체
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("문자열 입력:");
		try {
			String line=br.readLine();
			System.out.println("line:"+line);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
}
