package Basic;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileOperations {
	public static void main(String[] args) throws Exception{
			File file =  new File("C:\\Users\\User ID\\Documents\\Eclipse Project\\Suseendhiran\\src\\oct\\temp.txt");
			
			FileOutputStream fileOut = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(new Employee(101,"Aaa",20000));
			out.writeObject(new Employee(102,"Bbb",20000));
			out.writeObject(new Employee(103,"Ccc",20000));

			out.close();
			fileOut.close();

			FileInputStream fileInput = new FileInputStream(file);
			ObjectInputStream input = new ObjectInputStream(fileInput);
		
			try {
				while(true) {
					Employee emp = (Employee) input.readObject();
					System.out.println(emp.getEmployee());
				}
			}catch(Exception e) {}
	}
}

class Employee implements Serializable{
	int emp_ID;
	String emp_Name;
	int emp_Salary;
	public Employee(int emp_ID, String emp_Name, int emp_Salary) {
		super();
		this.emp_ID = emp_ID;
		this.emp_Name = emp_Name;
		this.emp_Salary = emp_Salary;
	}

	public String getEmployee() {
		return "Emp Id:"+this.emp_ID+"\nEmp Name: "+emp_Name+"\nEmp Salary: "+emp_Salary;
	}
}