package rvsusee;

import java.util.Scanner;

public abstract class Calculate implements EBBoard{
	public int[] getInputs() {
		int arr[] = new int[3];
		System.out.println("----------------------------------");
		Scanner sc = new Scanner(System.in);
		int connType = 0;
		int cityType = 0;
		int units = 0;
		while(true) {
			System.out.print("\tEB type \n1.Commercial \t2.Domestic\nEnter Option: ");
			connType = sc.nextInt();
			if (connType == 1 || connType == 2) {
				break;
			}
			System.out.println("Please Enter Valid Type");
		}
		System.out.println("----------------------------------");
		while(true) {
			System.out.print("\tLocation Type \n1.Urban \t2.Panjayath \n3.Rural \t4.Metro City \nEnter Option: ");
			cityType = sc.nextInt();
			if (cityType == 1 || cityType == 2 || cityType ==3 || cityType == 4) {
				break;
			}
			System.out.println("Please Enter Valid Type");
		}
		System.out.println("----------------------------------");
		while (true) {
			System.out.print("Enter Unit: ");
			units = sc.nextInt();
			if (units>=0) {
				break;
			}
			System.out.println("Please Enter Valid Unit");
		}
		System.out.println("----------------------------------");	
		
		arr[0] = connType;
		arr[1] = cityType;
		arr[2] = units;
		return arr;
	}

	public int calculateBill(int unit,int unitCost,int tax) {
		int cost = 0;
		if (unit<200){
			unit = unit-100;
			cost += unit*unitCost;
		}
		if(unit<400) {
			unit = unit-200;
			cost += unit * unitCost*0.2;
		}else if(unit>=500) {
			unit = unit-100;
			cost = unit*unitCost;
		}
		return cost;
	}
}
