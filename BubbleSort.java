public class BubbleSort {  
    
    public static void main(String[] args) {    
	    int arr[] = {56,174,21,53,5,8,31,50};
	    
	    int n = arr.length;  
	    int i, j, temp;  
	    for (i = 0; i < n; i++)  
	    {  
	        for (j = i + 1; j < n; j++)  
	        {  
	            if (arr[j] < arr[i])  
	            {  
	                temp = arr[i];  
	                arr[i] = arr[j];  
	                arr[j] = temp;  
	            }  
	        }  
	    }
	    for (int item : arr) {
			System.out.print(item+" ");
		}
    }
    
}  