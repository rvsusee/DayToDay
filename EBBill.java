package Basic;

import java.util.Scanner;

public class EBBill {
	
	int unit  = 0;
	public void freeUnit(int unit) {
		this.unit = unit;
		if (unit > 0 && unit <= 100) {
			System.out.println("Cost: Free of cost");
		}
	}
	class Payment{
		double price = 0;
		public void paymentUnit(int unit) {
			if (unit>100 && unit<=200) {
				price = 1.90;
				System.out.println("Cost: "+(price * unit));
			}else if(unit>200 && unit <= 300) {
				price = 2;
				System.out.println("Cost: "+(price * unit));
			}else if (unit>300 && unit <=400) {
				price = 3;
				System.out.println("Cost: "+(price*unit));
			}else if (unit>400) {
				price = 4;
				System.out.println("Cost: "+(price*unit));
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Unit: ");
		int unit = sc.nextInt();
		EBBill ebBill = new EBBill();
		ebBill.freeUnit(unit);
		EBBill.Payment payment= ebBill.new Payment();
		payment.paymentUnit(unit);
	}
}