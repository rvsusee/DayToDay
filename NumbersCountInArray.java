public class NumbersCountInArray {
	  public static void main(String[] args) {
		  int arr[] = {12,5,36,54,12,5,12,9,12,36};
		  
		  for (int i = 0; i < arr.length; i++) {
			  int count = 0;
			  for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			  }
			  System.out.println(arr[i]+" present in: "+ count+" times");
		  }
	  }
}