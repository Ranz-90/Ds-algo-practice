package Day1;

import java.util.Arrays;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] num = {2,3};
		
		int output = getSingleNumber(num, num.length);
		
		System.out.println(output);

	}

	private static int getSingleNumber(int[] num, int length) {
		// TODO Auto-generated method stub
		
		int singleNum =0;
		for(int j=0; j <length; j++) {
			singleNum = singleNum &num[j];
		}
		return singleNum;
	}

}
