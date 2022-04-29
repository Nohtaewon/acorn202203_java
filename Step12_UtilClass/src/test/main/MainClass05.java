package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.Car;

public class MainClass05 {
	public static void main(String[] args) {
		//1. Car type �� ������ �� �ִ� ArrayList ��ü�� �����ؼ�
		//�������� List �������̽� type �������� cars �� ��ƺ�����
		List<Car> cars=new ArrayList<>();
		//2. Car ��ü(3��)�� �����ؼ� List ��ü�� ������ ������
		cars.add(new Car("����"));
		cars.add(new Car("�ѽ�"));
		cars.add(new Car("����"));
		//3. �ݺ��� for ���� �̿��ؼ� List ��ü�� ����� ��� Car ��ü�� drive()�޼ҵ带
		//������� ȣ���غ�����.
		for(Car tmp:cars) {
			tmp.drive();
		}
	}
}
