package Basic;
import java.io.FileInputStream;
import java.io.Serializable;

public class SerializeAndDeSeralize implements Serializable{
	public static void main(String[] args) {
		try {
			FileInputStream file = new FileInputStream("C:\\Users\\User ID\\Documents\\Eclipse Project\\Suseendhiran\\src\\oct\\temp.txt");
			
			int i ;
			while((i= file.read()) != -1) {
				System.out.print((char)i);
			}
		}catch (Exception e) {
			System.out.println(e);
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