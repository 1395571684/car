package car;

import java.util.Scanner;

import javax.xml.parsers.FactoryConfigurationError;

public class Sys {
	Moto[] motos;

	public int[] rentMoto() {
		String[] carType = { "����", "����", "�µ�" };
		int[] carRentFee = { 500, 600, 400 };
		String[] busType = { "<16", ">16" };
		int[] busRentFee = { 1000, 2000 };
		int[] busSeat = { 10, 32 };
		Scanner input = new Scanner(System.in);
		System.out.println("***************��ӭ�����⳵ϵͳ***************");
		System.out.println("������Ҫ�⼸������");
		int count = input.nextInt();
		motos = new Moto[count];
		 int[] day=new int[count];//��¼�⳵������
		for (int i = 0; i < count; i++) {

			System.out.println("1���γ� 2���ͳ�");
			int sel = input.nextInt();
			if (sel == 1) {
				System.out.println("��ѡ���" + i + 1 + "����");
				System.out.println("��ѡ�񳵵��ͺţ�1������ 2���µ� 3������");
				sel = input.nextInt();
				motos[i] = new Car("³ B88888", carType[sel - 1]);
			} else {
				System.out.println("��ѡ��ͳ�����λ��1�� < 16�� 2�� > 16��");
				sel = input.nextInt();
				motos[i] = new Bus("³ A88888", busSeat[sel - 1]);
			}
			System.out.println("���������õ�������");
			day[i] = input.nextInt();
		}
		return day;
		
	}

	public void calcFee(int[] day) {
		System.out.println("���Ķ���Ϊ��");
		System.out.println("�ͺ�" + "\t\t" + "���ü۸�" + "\t" + "��������");
		double totalfee = 0;// ��¼�⳵���ܷ���
		for (int i = 0; i < motos.length; i++) {
			totalfee += motos[i].rentFee(day[i]);
			if(motos[i] instanceof Car)
			System.out.print("(�γ�)");
			else
			System.out.println("(�ͳ�)");
			System.out.println(motos[i].getMotoNo() + "\t" + motos[i].getFee()+ "\t" + day[i]);
		}
		System.out.println("�⳵�ܷ���Ϊ��" + totalfee);
	}

	public static void main(String[] args) {
		Sys sys=new Sys();
		sys.calcFee(sys.rentMoto());
		
	}
}
