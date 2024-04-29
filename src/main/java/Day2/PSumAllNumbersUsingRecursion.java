package Day2;

public class PSumAllNumbersUsingRecursion {

	public static void main(String[] args) {
	
		int n = 10;
		int sum = getSumUsingRecursion(n);
		System.out.println(sum);
	}

	private static int getSumUsingRecursion(int n) {

		if(n ==0) return 0;
		if(n==1) return 1;
		
		return n+getSumUsingRecursion(n-1);
	}
}
