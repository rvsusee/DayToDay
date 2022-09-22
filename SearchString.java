import java.util.Arrays;
import java.util.Scanner;

public class SearchString {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		String[] arr = new String[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}
		
		Arrays.sort(arr);
		for(String s: arr) {
			System.out.print(s);
		}
	}

}
