package oct;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;




public class ATM {
	static int atmcash = 60000;
	
	public static void options() throws PinMissMatchException,CashNotFoundException {
		 Scanner sc = new Scanner(System.in);

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
						 fastCash(pinNumber);
					 }else if(option ==4){
						 System.out.println("Thank You!!!");
						 System.exit(0);
					}else {
						System.out.println("Enter Valid Option");
					}
				 }	
			 }else {
				 try {
					 throw new PinMissMatchException("PIN Number is Wrong!. Kindly Enter Valid Pin!");
				 }catch(PinMissMatchException ex) {
//					 System.out.println(ex);
				 }
				}
			 }
		}
	public static void withdraw(int pinNumber) throws CashNotFoundException{
		 Scanner sc=new Scanner(System.in);
		 System.out.print("Enter withdrawal Amount: ");
		 int withdrawalAmount=sc.nextInt();
		 if(withdrawalAmount<= acc.get(pinNumber) && withdrawalAmount<= atmcash) {
			 atmcash = atmcash - withdrawalAmount ;
			 System.out.println("Withdrawal Completed!");
			 System.out.println("Withdrawal Amount: "+withdrawalAmount);
			 acc.put(pinNumber, acc.get(pinNumber)-withdrawalAmount);
			 balanceEnquire(pinNumber);
		 }else {
			 if (withdrawalAmount > acc.get(pinNumber)) {
				 System.out.println("Insufficient Balance!");
				 balanceEnquire(pinNumber);
			 }else if(withdrawalAmount > atmcash) {
				 try {
					 throw new CashNotFoundException("Cash Not found");
				 }catch(CashNotFoundException ex) {
				 }
			 }
		 }
	 }
	public static void withdraw(int pinNumber, int withdrawalAmount) {
		 if(withdrawalAmount<= acc.get(pinNumber) && withdrawalAmount <= atmcash) {
			 atmcash = atmcash - withdrawalAmount ;
			 System.out.println("Withdrawal Completed!");
			 System.out.println("Withdrawal Amount: "+withdrawalAmount);
			 
			 acc.put(pinNumber, acc.get(pinNumber)-withdrawalAmount);
			 balanceEnquire(pinNumber);
		 }else {
			 if (withdrawalAmount > acc.get(pinNumber)) {
				 System.out.println("Insufficient Balance!");
				 balanceEnquire(pinNumber);
			 }else if(withdrawalAmount > atmcash) {
				 try {
					 throw new CashNotFoundException("Cash Not found");
				 }catch(CashNotFoundException ex) {
				 }
			 }
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
		 boolean flag = true;
		 while(flag) {
			 System.out.println("choose below option: ");
			 System.out.println("1.$5,000 \t2.$10,000 \n3.$15,000 \t4.$20,000");
			 int option = sc.nextInt();
			 switch(option) {
			 case 1: 
				 withdraw(pinNumber,5000);
				 flag = false;
				 break;
			 case 2: 
				 withdraw(pinNumber,10000);
				 flag = false;
				 break;
			 case 3: 
				 withdraw(pinNumber,15000);
				 flag = false;
				 break;
			 case 4: 
				 withdraw(pinNumber,20000);
				 flag = false;
				 break;
			 default:
				 System.out.println("Option Not found!");
			 }
		 }
	}
	
	static Map<Integer,Double> acc = new HashMap<>();
	
	public static void main(String[] args) throws PinMissMatchException,CashNotFoundException {
		acc.put(1111, (double) 60000);
		acc.put(2222, (double) 2000);
		acc.put(3333, (double) 2600);
		acc.put(4444, (double) 6500);
		acc.put(4444, (double) 2500);
		options();
	}
	
}

class PinMissMatchException extends Exception{
	public PinMissMatchException(String str) {
		System.out.println(str);
	}	
}
class CashNotFoundException extends Exception{
	public CashNotFoundException(String str) {
		System.out.println(str);
	}
}
