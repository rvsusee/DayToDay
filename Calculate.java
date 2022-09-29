package rvsusee.eb;

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
			System.out.print("\tEB type \n1.Domestic \t2.Commercial\nEnter Option: ");
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

	public double calculateBill(int unit,double unitCost) {
		double cost = 0;
		
		if (unit <= 100) {
            return unit * 0;
        }
        else if (unit <= 200) {
            return (100 * unitCost + 0.5)
                + (unit - 100)
                      * unitCost + 1.0;
        }
        else if (unit <= 300) {
            return (100 * unitCost + 0.5)
                + (100 * unitCost + 1.0)
                + (unit - 200)
                      * unitCost + 1.5;
        }
        else if (unit <= 400) {
            return (100 * unitCost + 0.5)
                + (100 * unitCost + 1.0)
                + (100 * unitCost + 1.5)
                + (unit - 300)
                      * unitCost + 2.0;
        }else if (unit <= 500) {
            return (100 * unitCost + 0.5)
                    + (100 * unitCost + 1.0)
                    + (100 * unitCost + 1.5)
                    + (100 * unitCost + 2.0)
                    + (unit - 400)
                          * unitCost + 2.5;
        }else if (unit > 500 && unit <= 1000) {
            return (100 * unitCost + 0.5)
                    + (100 * unitCost + 1.0)
                    + (100 * unitCost + 1.5)
                    + (100 * unitCost + 2.0)
                    + (100 * unitCost + 2.5)
                    + (unit - 500)
                          * unitCost + 3.0;
        }else if (unit > 1000 ) {
            return (100 * unitCost + 0.5)
                    + (100 * unitCost + 1.0)
                    + (100 * unitCost + 1.5)
                    + (100 * unitCost + 2.0)
                    + (100 * unitCost + 2.5)
                    + (100 * unitCost + 3.0)
                    + (unit - 1000)
                          * unitCost + 4.0;
        }
		return cost;
	}
}
