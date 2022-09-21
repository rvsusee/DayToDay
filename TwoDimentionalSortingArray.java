

public class TwoDimentionalSortingArray {
	public static void main(String[] args) {
		int arr[][] = {{10,90,8},
						{60,56,4},
						{35,2,45}};

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				int temp= arr[i][j];
				
				for (int k = 0; k < arr.length; k++) {
					for (int l = 0; l < arr[k].length; l++) {
						
						if (arr[k][l] > temp ) {
							arr[i][j] = arr[k][l];
							arr[k][l] = temp;
							temp = arr[i][j];
						}
					}
				}
				
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
