package rajaram;

public class OccuranceUsingString {
	public static void main(String[] args) {
		int[] nums = { 11, 242, 124, 11 };

//		124, 77, 65, 343, 23, 54, 77, 546, 1234, 978 };

		String res = "";
		for (int num : nums) {
			String currKey = "|" + num + " => ";
			if (res.contains(currKey)) {
				int index = res.indexOf(currKey);

			} else {	
				currKey += "1|";
			}
			res += currKey;
			System.out.println(res);
		}
		System.out.println(res);

	}
}