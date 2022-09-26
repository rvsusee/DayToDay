class InsertionSort{
	public static void main(String[] args) {  
	    int[] numArray = {45,5,214,6,4,674};  

	    for(int k=1; k<numArray.length-1; k++)   {  
	        int temp = numArray[k];  
	        int j= k-1;  
	        while(j>=0 && temp <= numArray[j])   {  
	            numArray[j+1] = numArray[j];   
	            j = j-1;  
	        }  
	        numArray[j+1] = temp;  
	    }  
	    for (int i : numArray) {
			System.out.print(i+" ");
		}
	}
}