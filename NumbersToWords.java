import java.util.Scanner;

public class NumbersToWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt();
		
		String[] onedigit = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};  

		String[] twodigits = new String[] {"", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};  
		
		String[] multipleoftens = new String[] {"",  "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};  

		if (value == 0 ) {
			System.out.println("Zero");
		}
		if (value<10) {
			System.out.println(onedigit[value]);
		}else if(value<20){
			System.out.println(twodigits[value-9]);			
		}
		
	}
}