package test.mypac;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainClass03 {
	public static void main(String[] args) {
		//1 byte 처리스트림
		InputStream is=System.in;
		//2 byte 처리스트림
		InputStreamReader isr=new InputStreamReader(is);
		
		System.out.println("입력:");
		try {
			//입력한 키의 코드값 읽어오기
			int code=isr.read();
			System.out.println("code:"+code);
			//코드값에 대응되는 문자얻어내기
			char ch=(char)code;
			System.out.println("char:"+ch);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
