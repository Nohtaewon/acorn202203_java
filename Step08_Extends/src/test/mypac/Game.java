package test.mypac;

public class Game extends SmartPhone{
	public Game() {
		System.out.println("Game ������ ȣ��");
	}
	public void playGame() {
		System.out.println("������ �ؿ�");
	}
	@Override
	public void doInternet() {
		System.out.println("���ͳ��� �� �����ؿ�");
	}
	@Override
	public void takePicture() {
		System.out.println("���� �� ������ ����");
	}
}
