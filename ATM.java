package dhanusri.atm;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATM {
	

	public static void options() {
		 Scanner sc=new Scanner(System.in);

		 while(true) {
			 System.out.println("Enter your Pin Number: ");
			 int pinNumber=sc.nextInt();
			 if(acc.containsKey(pinNumber)) {
				 System.out.println("Your PIN NUMBER is correct");
			
				 while(true) {
					 System.out.println("1.Balance Enquire \n2.Withdrawal \n3.Fast Cash \n4.Exit");
					 System.out.println("Please Enter above option: ");
					 int option = sc.nextInt();
					 if (option == 1) {
						 balanceEnquire(pinNumber);
					 }else if(option ==2) {
						 withdraw(pinNumber);
					 }else if (option == 3) {
						 System.out.println("Fast Cash");
						 fastCash(pinNumber);
					 }else if(option ==4){
						 System.out.println("Thank You!!!");
						 System.exit(0);
					}else {
						System.out.println("Enter Valid Option");
					}
				 }	
			 }else {
				 System.out.println("PIN Number is Wrong!. Kindly Enter Valid Pin!");
			 	}
			 }
		}
	public static void withdraw(int pinNumber) {
		 Scanner sc=new Scanner(System.in);
		 System.out.print("Enter withdrawal Amount: ");
		 int withdrawalAmount=sc.nextInt();
		 if(withdrawalAmount<= acc.get(pinNumber)) {
			 System.out.println("Withdrawal Completed!");
			 System.out.println("Withdrawal Amount: "+withdrawalAmount);
			 acc.put(pinNumber, acc.get(pinNumber)-withdrawalAmount);
			 balanceEnquire(pinNumber);
		 }else {
			 System.out.println("Insufficient Balance!");
			 balanceEnquire(pinNumber);
		 }
	 }
		 
	public static void balanceEnquire(int pinNumber) {
		 if(acc.containsKey(pinNumber)) {
			 System.out.println("Your Pin Numeber: "+pinNumber+"\nCurrent Balance is: "+acc.get(pinNumber));
		 }else {
			 System.out.println("PIN Not Found!");
			 System.exit(0);
		 }
	}
		 
		
	public static void fastCash(int pinNumber) {
		 double Amount = 0;
		 Scanner sc=new Scanner(System.in);
		 System.out.print("Enter your withdrawal Amount Here:");
		 int withdrawalAmount=sc.nextInt();
		 if(Amount<= acc.get(pinNumber)) {
			
		
		 }
		
	}
	
	
	static Map<Integer, Double> acc = new HashMap<>();
	
	public static void main(String[] args) {
		acc.put(1111, (double) 5000);
		acc.put(2222, (double) 2000);
		acc.put(3333, (double) 2600);
		acc.put(4444, (double) 6500);
		acc.put(4444, (double) 2500);
		options();
	}
	
}
