import java.util.Arrays;

public class ThreeArrayFindSmallestElement {

	public static void main(String[] args) {
		
		int a[] = {10,20,7,8,6};
		int b[] = {10,15,3,6,8};
		int c[] = {7,9,6,13,10};
		
		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);
		
		for (int i = 0; i < a.length; i++) {
			if(foundOrNot(b,a[i])) {
				if(foundOrNot(c, a[i])) {
					System.out.println(a[i]);
					break;
				}
			}
		}
		
	}
	static boolean foundOrNot(int[] arr, int val) {

		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == val) {
				return true;
			}else if (arr[j] > val) {
				return false;
			}
		}
		return false;
	}

	
}
