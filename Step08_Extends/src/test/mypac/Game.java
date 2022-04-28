package test.mypac;

public class Game extends SmartPhone{
	public Game() {
		System.out.println("Game 생성자 호출");
	}
	public void playGame() {
		System.out.println("게임을 해요");
	}
	@Override
	public void doInternet() {
		System.out.println("인터넷을 더 빨리해요");
	}
	@Override
	public void takePicture() {
		System.out.println("게임 속 사진을 찍어요");
	}
}
