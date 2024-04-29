package Day1;

public class FindDifferenceLeetCode {

	public static void main(String[] args) {
		String s = "abcd";
		String t = "abcde";
		
		int sumS=0;
		int sumT =0;
		
		for(int i =0; i <s.length(); i++) {
			
			sumS = sumS+(s.charAt(i)-'0');
		}
		
		for(int j=0; j <t.length(); j++) {
			sumT = sumT + (t.charAt(j)-'0');
		}
		
		
		char diff = (char) ((sumT - sumS)+'0');
		
		char diff1 = (char)(sumT-sumS);

	}

}
