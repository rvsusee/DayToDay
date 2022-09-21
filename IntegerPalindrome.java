import java.util.Scanner;

public class IntegerPalindrome {

	public static void main(String[] args) {
		while(true) {
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			int temp = input;
			int result = 0;
			
			while(temp>0) {
				result = (temp%10)+(result*10);
				temp = temp/10;
				System.out.println(result);
			}
			if (input == result) {
				System.out.println("Palindrome");
			}else {
				System.out.println("Not Palindrome");
			}
		}		
	}
}
