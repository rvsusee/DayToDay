
public class FindWordsInParagraph {

	public static void main(String[] args) {

		String para = "Hello this is java program and java program this is java java python";
		String word = "java";
		int pos = 0;
		int count = 0;
		while(pos<para.length()) {
			para = para.substring(pos);
			int temp = stringContains(word,para);
			if(temp>0) {
				pos = temp+word.length();
				count++;
			}else {
				break;
			}
		}
		System.out.println(count);
	}

	static int stringContains(String word,String para) {
		if (para.contains(word))
			return para.indexOf(word);
		return -1;
	}
}
