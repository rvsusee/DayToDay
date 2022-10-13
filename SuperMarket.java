package supermarket;

import java.util.ArrayList;
import java.util.Scanner;

public class SuperMarket {
	
	static ArrayList<String> inputs = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Products: ");
		while(true) {
			String product = sc.next();
			if (product.equals("-1")) {
				break;
			}
			inputs.add(product);
		}
		sc.close();

		Sauce sauce = new Sauce();
		Beverges beverges = new Beverges();
		Dairy dairy = new Dairy();
		
		sauce.setName("sauce");
		beverges.setName("beverges");
		dairy.setName("dairy");
		sauce.start();
		beverges.start();
		dairy.start();
		
	}	
}

class Sauce extends Thread{	
	public void run() {
		String sauce[]= {"Tomato","chilly","soya"};
		Linear.check(sauce, SuperMarket.inputs);	
	}
}
class Beverges extends Thread{
	String beverges[]= {"tea","coffee","bonevita","boost","bonevita","complan"};
	public void run() {
		Linear.check(beverges, SuperMarket.inputs);		
	}
	
}

class Dairy extends Thread{
	String dairy[]= {"curd","milk","butter","ghee","butter"};
	public void run() {
		Linear.check(dairy, SuperMarket.inputs);	
	}
}

class Linear{

	synchronized static void check(String[] products, ArrayList<String> inputs) {
		System.out.println("--------"+Thread.currentThread().getName()+"--------");
		for (int i = 0; i < inputs.size(); i++) {
			if (Linear.search(products,inputs.get(i))) {
				System.out.println(inputs.get(i));
			}
		}
	}
	
	synchronized static boolean search(String[] arr, String key){    
        for(int i=0;i<arr.length;i++){    
            if(arr[i].equals(key)){    
                return true;
            }    
        }    
        return false;    
    }   
}
