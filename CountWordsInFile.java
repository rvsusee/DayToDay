import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountWordsInFile {
	  static Map<String,Integer> map = new HashMap<>();
	  public static void main(String[] args) {
		  try {
			  File file = new File("C:\\Users\\User\\Documents\\Demo.txt");
			  Scanner scanner = new Scanner(file);
			  while (scanner.hasNext()){
				  count(scanner.nextLine());
			  }
			  scanner.close();
		  }catch (FileNotFoundException e){
			  System.out.println("File Not Found! "+e);
		  }
		  //file write
		  try{
			  FileWriter file = new FileWriter("C:\\Users\\User\\Documents\\result.txt",true);
			  BufferedWriter writer = new BufferedWriter(file);
			  for (String str: map.keySet()){
				  String temp = str+" = "+map.get(str);
				  System.out.println(temp);
				  writer.write(temp);
				  writer.newLine();
			  }
			  writer.write("AAA");
			  writer.close();
		  }catch (IOException e) {
			  e.printStackTrace();
		  }
	  }
	static void count(String str){
	    String[] arr = str.split("\\s+");
	    for (String s: arr) {
	        if (map.get(s) == null)
	        	map.put(s,1);
	        else
	        	map.put(s,map.get(s)+1);
    }
    }
}
