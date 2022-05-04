package test.mypac;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class MainClass15 {
	public static void main(String[] args) {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream("c:/acorn202203/myFolder/1.jpg");
			fos=new FileOutputStream("c:/acorn202203/myFolder/copied.jpg");
			//해보시용~ (읽어낸 int 값을 그대로 출력하면 됨)
			while(true) {//101,428 번 돌았다
				//1byte 씩 읽어내고
				int fr=fis.read();
				//만일 더 이상 읽을 데이터가 없다면
				if(fr==-1) {
					break;//반복문 탈출
				}
				//읽어낸 만큼 출력
				fos.write(fr);
				fos.flush();//방출 안해주면 close시점에 메모리가 일괄적으로 실행
			}
			System.out.println("작업 성공!");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fos!=null)fos.close();
				if(fis!=null)fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
