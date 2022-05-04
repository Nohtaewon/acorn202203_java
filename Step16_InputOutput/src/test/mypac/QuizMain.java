package test.mypac;

import java.io.FileWriter;
import java.util.Scanner;

public class QuizMain {
	public static void main(String[] args) {
		/*
		 * Scanner 객체를 이용해서 문자열 한 줄을 입력 받은 다음
		 * c:/acoron202203/myFolder/quiz.txt 파일을 만들어서
		 * 해당 파일에 문자열을 저장해 보세요
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("문자열 입력:");
		String str = scan.nextLine();
		FileWriter fw = null;
		try {
			fw=new FileWriter("c:/acorn202203/myFolder/quiz.txt", true);//append 모드 true 면 추가 아니면 덮어씀
			fw.write(str);
			fw.write("\r\n");
			fw.flush();
			System.out.println("파일에 문자열을 저장했습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			}catch(Exception e) {}
		}
	}
}
