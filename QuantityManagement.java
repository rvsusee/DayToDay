package oct;

import java.util.Scanner;
import java.util.Vector;

public class QuantityManagement {

	static Vector<String> list = new Vector<>();
	static Vector<Integer> quantity = new Vector<>();

	public static void main(String[] args) {

		list.add("Apple");
		list.add("Orange");
		list.add("Banana");
		list.add("Mango");
		quantity.add(10);
		quantity.add(3);
		quantity.add(4);
		quantity.add(5);
		while(true)
			options();
		
	}

	private static void options() {
		Scanner sc = new Scanner(System.in);

		Options:
			while (true) {
			System.out.println("----------------Option----------------");			
			System.out.println("1.Export \t2.Import \n3.Display \t4.Exit");
			System.out.print("Enter Above Option: ");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				Export:
				while (true) {
					display();
					System.out.println("Enter Product Name: ");
					String prodName = sc.next();
					if (list.contains(prodName)) {
						while (true) {
							System.out.println("Enter "+prodName+" Quantity: ");
							int prodQuantity = sc.nextInt();
							int index = list.indexOf(prodName);
							int currQuantity = quantity.get(index);
							if (currQuantity >= prodQuantity) {
								System.out.println("Export Success");
								quantity.set(index, quantity.get(index) - prodQuantity);
								break Options;
							} else {
								System.err.print("Export Failed! ");
								System.err.println(prodName + " Quantity is: " + currQuantity+" only!!!");
								System.out.println("--------------------------------------");			
							}
						}
					} else {
						System.out.println("Product not found!!");
						
					}
				}
			case 2:
				Import:
					while (true) {
						display();
						System.out.println("Enter Product Name: ");
						String prodName = sc.next();
						if (list.contains(prodName)) {
							System.out.println("Enter "+prodName+" Quantity: ");
							int prodQuantity = sc.nextInt();
							int index = list.indexOf(prodName);
							int currQuantity = quantity.get(index);
							System.out.println("Import Success");
							quantity.set(index, quantity.get(index) + prodQuantity);
							System.err.println(prodName + " Quantity is: " + quantity.get(index));
							System.out.println("--------------------------------------");			
							break Import;
						} else {
							System.out.println("Product not found!!");							
						}
					}
			case 3:
				display(1);
				options();
			case 4:
				System.exit(0);

			default:
				System.out.println("Wrong option");
			}

			System.out.println("Enter Product");
			if (list.contains(sc.next())) {

			}
		}
	}

	static void display() {
		System.out.println("-------------Product List-------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i++) + "\t" + list.get(i));
		}
		System.out.println("--------------------------------------");			
	}

	static void display(int a) {
		System.out.println("--------Product List With Quantity--------");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "\t" + quantity.get(i)+"\t");
			i++;
			System.out.println(list.get(i) + "\t" + quantity.get(i)+"\t");
		}
		System.out.println("--------------------------------------");			
	}

}
