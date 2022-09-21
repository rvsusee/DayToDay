

public class FindMinMaxUsingTwoDimArray {
	
	public static void main(String[] args) {
		int arr[][] = {{10,90,8},
				{60,56,4},
				{35,2,45}};
		int min = arr[0][0];
		int max = arr[0][0];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (max < arr[i][j]) {
					max = arr[i][j];
				}else if(min > arr[i][j]) {
					min = arr[i][j];
				}
			}
		}
		
		System.out.println("Minimum Value: "+min);
		System.out.println("Maximum Value: "+max);
		
	}
}
