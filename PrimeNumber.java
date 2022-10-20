package suseendhiran;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class PrimeNumber {
	static Map<Integer, Integer> map = new LinkedHashMap();

	public static void main(String args[]) throws IOException {
		File file = new File(
				"C:\\Users\\User ID\\Documents\\Eclipse Project\\MentorTasks\\src\\suseendhiran\\PrimeNumbers.properties");
		System.out.println("Enter N th number: ");
		getPrimeNumbers(new Scanner(System.in).nextInt());
		writeOperation(file);
		readPropFileWriteDB(file);
		getDatasFromDB();

	}


	private static void writeOperation(File files) throws IOException {
		FileWriter fileWriter = new FileWriter(files);
		Properties p = new Properties();

		for (Integer key : map.keySet()) {
			p.setProperty(key.toString(), map.get(key).toString());
		}
		p.store(fileWriter, "");
	}

	private static void readPropFileWriteDB(File file) throws IOException {
		FileInputStream fileInput = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(fileInput);

		for (Object key : properties.keySet()) {
			System.out.println(key + " : " + properties.get(key));
			insertDB("INSERT INTO Suseendhiran_PrimeNumber VALUES('" + key.toString() + "','"
					+ properties.getProperty((String) key) + "')");
		}

	}

	private static void getPrimeNumbers(int upto) {
		System.out.println("Generate Prime numbers upto "+upto);
		int nos = 1;
		for (int i = 1; i <= upto; i++) {
			int c = 0;
			for (int j = 1; j <= i; j++)
				if (i % j == 0)
					c++;
			if (c == 2) {
				System.out.println(i);
				map.put(nos, i);
			} else
				continue;
			nos++;
		}
		System.out.println(map);
	}

	private static void insertDB(String query) {
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:sqlserver://192.168.168.12:1433;databaseName=New_joinee_2022", "NewJoinee2022", "P@ssw0rd");

			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void getDatasFromDB() {
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:sqlserver://192.168.168.12:1433;databaseName=New_joinee_2022", "NewJoinee2022", "P@ssw0rd");
			Statement stmt = conn.createStatement();	

			ResultSet rs = stmt.executeQuery("SELECT * FROM Suseendhiran_PrimeNumber");
			
			while (rs.next()) {
				System.out.println(rs.getString(1)+"->"+rs.getString(2));
			}
		
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}