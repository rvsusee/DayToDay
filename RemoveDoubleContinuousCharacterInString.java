package rvsusee;

public class RemoveDoubleContinuousCharacterInString {
	public static void main(String[] args) {	
		String str = "abbccbdabcoc";
		while(true) {
			if(checkRepeatOrNot(str)) {
				System.out.println(str);
				str = removeRepeatedChar(str);
				System.out.println(str);
			}else {
				System.out.println("Output is: "+str);				
				break;
			}
		}
	}
	
	static String removeRepeatedChar(String str) {
		String temp = "";

		for (int i = 0; i < str.length()-1; i++) {
			if (str.charAt(i) == str.charAt(i+1)) {
				i++;
			}else {
				temp+= str.charAt(i);
			}
			
			if(i == str.length()-2 ) {
				temp += str.charAt(i);
			}
		}
		return temp;
	}

	static boolean checkRepeatOrNot(String str) {
		for (int i = 0; i < str.length()-1; i++) {
			for (int j = 1; j < str.length(); j++) {
		
				if (str.charAt(i) == str.charAt(j)) {
					return true;
				}
			}
		}
		return false;
	}
}
