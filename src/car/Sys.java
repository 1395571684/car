package car;

import java.util.Scanner;

import javax.xml.parsers.FactoryConfigurationError;

public class Sys {
	public void rentMoto() {
		String[] carType = { "����", "����", "�µ�" };
		int[] carRentFee={500,600,400};
		String[] busType = {"<16",">16"};
		int[] busRentFee={1000,2000};
		int[] busSeat={10,32};
		Scanner input = new Scanner(System.in);
		System.out.println("***************��ӭ�����⳵ϵͳ***************");
		System.out.println("������Ҫ�⼸������");
		int count=input.nextInt();
		String[] name=new String[count];//��¼�⳵���ͺ�
		double[] rent=new double[count];
		int[] rentFee=new int[count];//��¼�⳵�ļ۸�
		int[] day=new int[count];//��¼�⳵������
		for (int i = 0; i < count; i++) {
			
		System.out.println("1���γ� 2���ͳ�");
		int sel = input.nextInt();
		if (sel == 1) {
			System.out.println("��ѡ�񳵵��ͺţ�1������ 2���µ� 3������");
			sel = input.nextInt();
			name[i]=carType[sel-1];
			rentFee[i]=carRentFee[sel-1];
			Moto moto = new Car("³ B88888");
			((Car)moto).setType(carType[sel - 1]);
			System.out.println("���������õ�������");
			day[i] = input.nextInt();
			// �������
			rent[i] = moto.rentFee(day[i]);
			// ������
		} else {
			System.out.println("��ѡ��ͳ�����λ��1�� < 16�� 2�� > 16��");
			sel = input.nextInt();
			name[i]=busType[sel-1];
			rentFee[i]=busRentFee[sel-1];
			Moto moto = new Bus("³ A88888");
			((Bus)moto).setSeatCount(busSeat[sel - 1]);
			System.out.println("day");
			day[i] = input.nextInt();
			// �������
			rent[i]= moto.rentFee(day[i]);
			// ������
		}
		}
		System.out.println("���Ķ���Ϊ��");
		System.out.println("�ͺ�"+"\t"+"���ü۸�"+"\t"+"��������");
		double totalfee=0;//��¼�⳵���ܷ���
		for (int i = 0; i < count; i++) {
			System.out.println(name[i]+"\t"+rentFee[i]+"\t"+day[i]);
			totalfee+=rent[i];
		}
		System.out.println("�⳵�ܷ���Ϊ��"+totalfee);
	}
	public static void main(String[] args) {
		new Sys().rentMoto();
	}
}
