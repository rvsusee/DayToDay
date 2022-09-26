
public class Employee implements Comparable{
	
	int id;
	String name;
	String dob;
	int salary;
	
	public Employee(int id, String name, String dob, int salary) {
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.salary = salary;
	}
	
	
	@Override
	public int compareTo(Object o) {
		return toString().compareTo(o.toString());
	}
	
	public String toString() {
        return "id: " + id +"\tName: " + name +"\t DOB: " + dob + "\tsalary: " + salary ;
    }
    
	
    
}
