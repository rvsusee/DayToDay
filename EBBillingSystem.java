package rvsusee.eb;

public class EBBillingSystem extends Calculate{
	public static void main(String[] args) {
		
		System.out.println("\tEB Billing System\t");
		EBBillingSystem obj = new EBBillingSystem();
		int inputs[] = obj.getInputs();
		double cost = 0;
		if (inputs[2] <=100) {
			System.out.println("Bill Due: 0.00rs");
		}else if (inputs[0] == 1) {
			inputs[2] -=100;
			switch (inputs[1]) {
				case 1: 
					cost = obj.calculateBill(inputs[2], 1);
					break;
				case 2:
					cost = obj.calculateBill(inputs[2], 1.5);
					break;
				case 3:
					cost = obj.calculateBill(inputs[2], 2);
					break;
				case 4:
					cost = obj.calculateBill(inputs[2], 2.5);
					break;
			}	
		}else if (inputs[0] == 2) {
			inputs[2] -=100;
			switch (inputs[1]) {
				case 1: 
					cost = obj.calculateBill(inputs[2], 1.5);
					break;
				case 2:
					cost = obj.calculateBill(inputs[2], 2);
					break;
				case 3:
					cost = obj.calculateBill(inputs[2], 2.5);
					break;
				case 4:
					cost = obj.calculateBill(inputs[2], 3);
					break;
			}
		}
		System.out.println("Bill Due: "+cost+" rs");
	}
}
