package Day2;

public class PowXToPowerN {

	public static void main(String[] args) {
		
		int x = 2;
		int n = 10;
		
		int output = getPow(x, n);
		
		System.out.println(output);

	}

	private static int getPow(int x, int n) {
		
		int ans = 1;
		
		while(n > 0) {
			
			if(n %2 == 0) {
				x = x *x;
				n = n/2;
			}
			else if(n %2 ==1) {
				ans = ans *x;
				n = n-1;
			}
		}
		
		return ans;
	}

}
