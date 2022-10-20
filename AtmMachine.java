package oct.atm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AtmMachine {
	static int atmcash = 30000;
	
	public static void options() throws PinMissMatchException,CashNotFoundException {
		 Scanner sc = new Scanner(System.in);
		 while(true) {
			 System.out.print("Enter Account Number: ");
			 int accNumber = sc.nextInt();
			 if (checkAccount(accNumber)) {
				 while(true) {
					 System.out.print("Enter Pin Number: ");
					 int pinNumber=sc.nextInt();
					 if(checkPin(accNumber, pinNumber)) {			
						 while(true) {
							 System.out.println("---------------------------------------");
							 System.out.println("1.Withdrawal \t\t2.Fast Cash \n3.Balance Enquire \t4.Exit");
							 System.out.print("Please Enter above option: ");
							 int option = sc.nextInt();
							 System.out.println("---------------------------------------");
							 if (option == 1) {
								 withdraw(pinNumber);
							 }else if(option ==2) {
								 fastCash(pinNumber);
							 }else if (option == 3) {
								 balanceEnquire(pinNumber);
							 }else if(option ==4){
								 System.out.println("Thank You!!!");
								 System.exit(0);
							}else {
								System.out.println("Enter Valid Option");
							}
						 }	
					 }else {
						 try {
							 throw new PinMissMatchException("PIN Number is Wrong!. ");
						 }catch(PinMissMatchException ex) {
		//						 System.out.println(ex);
						 }
					}
				 }
			 }
		 }
	}
	public static void withdraw(int pinNumber) throws CashNotFoundException{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter withdrawal Amount: ");
		int withdrawalAmount=sc.nextInt();
		withdraw(pinNumber,withdrawalAmount);
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
			 System.out.print("PIN Not Found!");
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
	
	
	
	static boolean checkAccount(int accNumber) {	
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccNo() == accNumber)
				return true;
		}
		System.out.println("Invalid Account Number!");
		return false;
	}
	
	static boolean checkPin(int accNumber, int pinNumber) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccNo() == accNumber)
				return accounts.get(i).getPinNo() == pinNumber ? true : false; 
		}
		System.out.println("Wrong Pin Number");
		return false;
	}
	
	static int checkBalance(int accNumber) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccNo() == accNumber)
				return accounts.get(i).getBalance();
		}
		return 0;
	}
	
	
	
	static Map<Integer,Double> acc = new HashMap<>();
	static List<Account> accounts = new LinkedList();
	public static void main(String[] args) throws PinMissMatchException,CashNotFoundException {
		accounts.add(new Account(1001, 101, "AAA", 20000));
		accounts.add(new Account(1002, 102, "BBB", 15000));
		accounts.add(new Account(1003, 103, "CCC", 30000));
		accounts.add(new Account(1004, 104, "DDD", 00000));
		accounts.add(new Account(1005, 105, "EEE", 00120));

		acc.put(101, (double) 60000);
		acc.put(102, (double) 2000);
		acc.put(103, (double) 2600);
		acc.put(4444, (double) 6500);
		acc.put(4444, (double) 2500);
		options();
	}
	
}























class PinMissMatchException extends Exception{
	public PinMissMatchException(String str) {
		System.out.print(str);
	}	
}
class CashNotFoundException extends Exception{
	public CashNotFoundException(String str) {
		System.out.println(str);
	}
}



class Account{
	private int accNo;
	private int pinNo;
	private String name;
	private int balance;
	
	public Account(int accNo, int pinNo, String name, int balance) {
		this.accNo = accNo;
		this.pinNo = pinNo;
		this.name = name;
		this.balance = balance;
	}
	
	public int getAccNo() {
		return accNo;
	}
	public int getPinNo() {
		return pinNo;
	}	
	public String getName() {
		return name;
	}
	public int getBalance() {
		return balance;
	}
}
