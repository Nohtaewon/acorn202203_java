package test.auto;

public class BoongBoong extends Car{

	public BoongBoong(Engine engine) {
		super(engine);

	}
	public void flyCar() {
		System.out.println("�ϴ��� ���ƿ�");
	}
	@Override
	public void drive() {
		
		/*
		 * ������(�������̵�) �� �θ� �޼ҵ带 ȣ���ؾ� ���� ������
		 * ��Ȳ�� ���� �ٸ���.
		 * � ��쿡�� �θ��� �޼ҵ带 ȣ���� ���� ������ ��ü��
		 * ����� ������ ���ϴ� ��찡 �ִ�.
		 * �׷� ��쿡�� �θ��� �޼ҵ带 �ݵ�� ȣ���� �־�� �Ѵ�.
		 */
		super.drive();
		System.out.println("���� �� ������ �ٿ��� ��û ������ �޷���");
	}

}
