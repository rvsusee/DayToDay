package rajaram;

import java.util.HashMap;

public class OccurangeUsingHashMap {
	public static void main(String[] args) {
		int []nums = {11,242,124,11,124,77,65,343,23,54,77,546,1234,978};

		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num)+1);
			}else {
				map.put(num, 1);
			}
		}	
		for (Integer num : map.keySet()) {
			System.out.println(num+" \t: "+map.get(num));
		}
	}
}
