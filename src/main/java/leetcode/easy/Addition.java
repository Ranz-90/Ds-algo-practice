package leetcode.easy;

public class Addition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input1 = "123";
		String input2 = "78";
		
		String output = doAddition(input1,input2);
		
		System.out.println(output);
	}
	
	public static String doAddition(String input1, String input2){

		String output = "";
		int carry = 0;

		int len1 = input1.length()-1;
		int len2 = input2.length()-1;
		int i = len1;
		int j = len2;

		while(i >=0 && j>=0){

		int x = input1.charAt(i)-'0';
		int y = input2.charAt(j)-'0';

		int sum = x+y+carry;
		carry = sum/10;
		i--;
		j--;
		output += Integer.toString(sum%10);
		}

		return output;

		}

}
