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
		
		Sauce sauce = new Sauce();
		Beverges beverges = new Beverges();
		Dairy dairy = new Dairy();
		
		sauce.start();
		beverges.start();
		dairy.start();
		
	}	
}

class Sauce extends Thread{	
	public void run() {
		String sauce[]= {"Tomato","chilly","soya"};
		System.out.println("------Suave------");
		for (int i = 0; i < SuperMarket.inputs.size(); i++) {
			if (Linear.search(sauce,SuperMarket.inputs.get(i))) {
				System.out.println(SuperMarket.inputs.get(i));
			}
		}
	}
}
class Beverges extends Thread{
	String beverges[]= {"tea","coffee","bonevita","boost","horlicks","complan"};
	public void run() {
		System.out.println("------beverges------");
		for (int i = 0; i < SuperMarket.inputs.size(); i++) {
			if (Linear.search(beverges,SuperMarket.inputs.get(i))) {
				System.out.println(SuperMarket.inputs.get(i));
			}
		}
	}
	
}

class Dairy extends Thread{
	String dairy[]= {"curd","milk","butter","ghee","butter"};
	public void run() {
		System.out.println("------dairy------");
		
	}
}




class Linear{

	synchronized static void check(String[] products, ArrayList<String> inputs) {
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
