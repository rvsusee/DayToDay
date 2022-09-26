

import java.util.*;

public class EmployeeManagement
{
//	static Employee []arr = new Employee[9];

	public static void main(String[] args) {
		Employee arr[] = new Employee[9];
		
		arr[0] =  new Employee(1, "Ashwin", "01-05-2001", 120000);
		arr[1] =  new Employee(2, "Joy", "10-12-2001", 92000);
		arr[2] =  new Employee(3, "Munusamy", "02-05-2001", 89000);
		arr[3] =  new Employee(4, "Vicky", "01-02-2001", 9800);
		arr[4] =  new Employee(5, "Kumar", "01-01-2001", 65000);
		arr[5] =  new Employee(6, "Nandha", "01-01-2001", 78000);
		arr[6] =  new Employee(7, "Ramu", "01-01-2001", 65000);
		arr[7] =  new Employee(8, "Somu", "01-01-2001", 123000);
		arr[8] =  new Employee(9, "Harish", "01-01-2001", 17502);


		Arrays.sort(arr, new Comparator<Employee>() {
	        @Override
	        public int compare(Employee o1, Employee o2) {
	            return o1.name.compareTo(o2.name);
	        }
	    });
		System.out.println("Sort By Name");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].toString());
		}

	}
}
