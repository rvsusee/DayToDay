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

	
//	private static void calculateBill(int unit,int unitCost,int tax) {
//		
//	}

//	int[] getInputs() {
//		int arr[] = new int[3];
//		System.out.println("----------------------------------");
//		Scanner sc = new Scanner(System.in);
//		int connType = 0;
//		int cityType = 0;
//		int units = 0;
//		while(true) {
//			System.out.print("\tEB type \n1.Commercial \t2.Domestic\nEnter Option: ");
//			connType = sc.nextInt();
//			if (connType == 1 || connType == 2) {
//				break;
//			}
//			System.out.println("Please Enter Valid Type");
//		}
//		System.out.println("----------------------------------");
//		while(true) {
//			System.out.print("\tLocation Type \n1.Urban \t2.Panjayath \n3.Rural \t4.Metro City \nEnter Option: ");
//			cityType = sc.nextInt();
//			if (cityType == 1 || cityType == 2 || cityType ==3 || cityType == 4) {
//				break;
//			}
//			System.out.println("Please Enter Valid Type");
//		}
//		System.out.println("----------------------------------");
//		while (true) {
//			System.out.print("Enter Unit: ");
//			units = sc.nextInt();
//			if (units>=0) {
//				break;
//			}
//			System.out.println("Please Enter Valid Unit");
//		}
//		System.out.println("----------------------------------");	
//		
//		arr[0] = connType;
//		arr[1] = cityType;
//		arr[2] = units;
//		return arr;
//	}
}
