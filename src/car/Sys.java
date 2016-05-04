package car;

import java.util.Scanner;

import javax.xml.parsers.FactoryConfigurationError;

public class Sys {
	public void rentMoto() {
		String[] carType = { "宝马", "奔驰", "奥迪" };
		int[] carRentFee={500,600,400};
		String[] busType = {"<16",">16"};
		int[] busRentFee={1000,2000};
		int[] busSeat={10,32};
		Scanner input = new Scanner(System.in);
		System.out.println("***************欢迎来到租车系统***************");
		System.out.println("请问想要租几辆车：");
		int count=input.nextInt();
		String[] name=new String[count];//记录租车的型号
		double[] rent=new double[count];
		int[] rentFee=new int[count];//记录租车的价格
		int[] day=new int[count];//记录租车的天数
		for (int i = 0; i < count; i++) {
			
		System.out.println("1、轿车 2、客车");
		int sel = input.nextInt();
		if (sel == 1) {
			System.out.println("请选择车的型号：1、宝马 2、奥迪 3、奔驰");
			sel = input.nextInt();
			name[i]=carType[sel-1];
			rentFee[i]=carRentFee[sel-1];
			Moto moto = new Car("鲁 B88888");
			((Car)moto).setType(carType[sel - 1]);
			System.out.println("请输入租用的天数：");
			day[i] = input.nextInt();
			// 计算租金
			rent[i] = moto.rentFee(day[i]);
			// 输出结果
		} else {
			System.out.println("请选择客车的座位：1、 < 16座 2、 > 16座");
			sel = input.nextInt();
			name[i]=busType[sel-1];
			rentFee[i]=busRentFee[sel-1];
			Moto moto = new Bus("鲁 A88888");
			((Bus)moto).setSeatCount(busSeat[sel - 1]);
			System.out.println("day");
			day[i] = input.nextInt();
			// 计算租金
			rent[i]= moto.rentFee(day[i]);
			// 输出结果
		}
		}
		System.out.println("您的订单为：");
		System.out.println("型号"+"\t"+"租用价格"+"\t"+"租用天数");
		double totalfee=0;//记录租车的总费用
		for (int i = 0; i < count; i++) {
			System.out.println(name[i]+"\t"+rentFee[i]+"\t"+day[i]);
			totalfee+=rent[i];
		}
		System.out.println("租车总费用为："+totalfee);
	}
	public static void main(String[] args) {
		new Sys().rentMoto();
	}
}
