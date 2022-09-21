
public class BinarySearch {
	public static void main(String[] args) {
		int arr[] = {10,20,30,40,50,60,70,80,90,100};
		System.out.println(binarySearch(arr,80));
	}

	static int binarySearch(int[] arr,int value) {

		int beg = 0;
		int end = arr.length-1;
		while(beg<=end) 
		{
			int mid = (beg+end)/2;		  
			if (arr[mid] == value) {
				return mid+1;
			}else if (arr[mid] < value) {
				beg = mid+1;
			}else if(arr[mid] > value) {
				end = mid-1;
			}
		}
		return -1;
	}
}


