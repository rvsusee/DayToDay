package MatrixMultUsiConsChan;

class MatMulCons {

	static int c[][] = new int[2][2];
	static int a[][] = {{1,2},{3,4}};
	static int b[][] = {{1,2},{3,4}};

	MatMulCons() {
		this(a,b);
		System.out.println("Program end");
	}

	MatMulCons(int[][] a,int[][] b){
		this("Constructor Chaining Using Matrix Multiplication: ");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				c[i][j] = a[i][j]+b[i][j];
			}
		}
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				System.out.print(c[i][j]);
			}
			System.out.println();
		}
	}

	MatMulCons(String str){
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		MatMulCons cons = new MatMulCons();
	}

}
