package car;

import java.util.Scanner;

import javax.xml.parsers.FactoryConfigurationError;

public class Sys {
	Moto[] motos;

	public int[] rentMoto() {
		String[] carType = { "宝马", "奔驰", "奥迪" };
		int[] carRentFee = { 500, 600, 400 };
		String[] busType = { "<16", ">16" };
		int[] busRentFee = { 1000, 2000 };
		int[] busSeat = { 10, 32 };
		Scanner input = new Scanner(System.in);
		System.out.println("***************欢迎来到租车系统***************");
		System.out.println("请问想要租几辆车：");
		int count = input.nextInt();
		motos = new Moto[count];
		 int[] day=new int[count];//记录租车的天数
		for (int i = 0; i < count; i++) {

			System.out.println("1、轿车 2、客车");
			int sel = input.nextInt();
			if (sel == 1) {
				System.out.println("请选择第" + i + 1 + "辆车");
				System.out.println("请选择车的型号：1、宝马 2、奥迪 3、奔驰");
				sel = input.nextInt();
				motos[i] = new Car("鲁 B88888", carType[sel - 1]);
			} else {
				System.out.println("请选择客车的座位：1、 < 16座 2、 > 16座");
				sel = input.nextInt();
				motos[i] = new Bus("鲁 A88888", busSeat[sel - 1]);
			}
			System.out.println("请输入租用的天数：");
			day[i] = input.nextInt();
		}
		return day;
		
	}

	public void calcFee(int[] day) {
		System.out.println("您的订单为：");
		System.out.println("型号" + "\t\t" + "租用价格" + "\t" + "租用天数");
		double totalfee = 0;// 记录租车的总费用
		for (int i = 0; i < motos.length; i++) {
			totalfee += motos[i].rentFee(day[i]);
			if(motos[i] instanceof Car)
			System.out.print("(轿车)");
			else
			System.out.println("(客车)");
			System.out.println(motos[i].getMotoNo() + "\t" + motos[i].getFee()+ "\t" + day[i]);
		}
		System.out.println("租车总费用为：" + totalfee);
	}

	public static void main(String[] args) {
		Sys sys=new Sys();
		sys.calcFee(sys.rentMoto());
		
	}
}
