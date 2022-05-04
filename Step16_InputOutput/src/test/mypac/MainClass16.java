package test.mypac;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class MainClass16 {
	public static void main(String[] args) {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream("c:/acorn202203/myFolder/1.jpg");
			fos=new FileOutputStream("c:/acorn202203/myFolder/copied.jpg");
			//해보시용~ (읽어낸 int 값을 그대로 출력하면 됨)
			
			//byte 알갱이를 읽어낼 byte[] 객체 생성
			byte[] buffer=new byte[1024];
			while(true) {
				//byte[] 객체를 전달해서 읽어내고 리턴되는 데이터는 읽은 byte 의 갯수가 리턴된다.
				int readedByte=fis.read(buffer);
				System.out.println("readedByte:"+readedByte);
				if(readedByte==-1) {
					break;//반복문 탈출
				}
				//byte[] 에 있는 데이터를 0번방에서 부터 읽은 만큼(readedByte) 출력하기
				fos.write(buffer, 0, readedByte);//52번째방 부터 쓰레기임 더들어가면 파일깨짐
				fos.flush();
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
