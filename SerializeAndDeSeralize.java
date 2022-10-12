package Basic;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeAndDeSeralize implements Serializable{
	public static void main(String[] args) {
		try {
			File file =  new File("C:\\Users\\User ID\\Documents\\Eclipse Project\\Suseendhiran\\src\\oct\\temp.txt");
			FileOutputStream fileOut = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(new Employee(101, "AAA"));

			out.close();
			fileOut.close();

			FileInputStream fileInput = new FileInputStream(file);
			ObjectInputStream input = new ObjectInputStream(fileInput);
			
			Employee e = (Employee) input.readObject();
			
			System.out.println(e.emp_id);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Employee{
	int emp_id;
	String emp_name;
	public Employee(int emp_id, String emp_name) {
		this.emp_id = emp_id;
		this.emp_name = emp_name;
	}
}