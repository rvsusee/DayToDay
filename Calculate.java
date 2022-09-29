package rvsusee;

import java.util.Scanner;

public abstract class Calculate implements EBBoard{
	public int[] getInputs() {
		int arr[] = new int[3];
		System.out.println("----------------------------------");
		Scanner sc = new Scanner(System.in);
		int connType = 0;
		int cityType = 0;
		int unit = 0;
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
			unit = sc.nextInt();
			if (unit>=0) {
				break;
			}
			System.out.println("Please Enter Valid Unit");
		}
		System.out.println("----------------------------------");	
		
		arr[0] = connType;
		arr[1] = cityType;
		arr[2] = unit;
		return arr;
	}

	public int calculateBill(int unit,int unitCost,int tax) {
		int cost = 0;
		if (unit<200){
			unit = unit-100;
			cost += unit*unitCost;
		}
		
		if (unit <= 100) {
            return unit * 0;
        }
        else if (unit <= 200) {
            return (100 * unitCost + 2)
                + (unit - 100)
                      * unitCost + 4;
        }
        else if (unit <= 300) {
            return (100 * unitCost + 2)
                + (100 * unitCost + 4)
                + (unit - 200)
                      * unitCost + 6;
        }
        else if (unit > 300) {
            return (100 * unitCost + 2)
                + (100 * unitCost + 4)
                + (100 * unitCost + 6)
                + (unit - 300)
                      * unitCost + 8;
        }else if (unit > 300) {
            return (100 * unitCost + 2)
                    + (100 * unitCost + 4)
                    + (100 * unitCost + 6)
                    + (unit - 300)
                          * unitCost + 8;
        }
		return cost;
	}
}
