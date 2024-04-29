public class MergeSortWithoutExtraSpace {

	public static void main(String[] args) {
		/*
		 * int[] a1 = { 10, 27, 38, 43, 82 }; int[] a2 = { 3, 9 };
		 */
		
		int[] a1 = {1,2,3,0,0,0};
		int[] a2 = {2,5,6};
 
        // Function Call
        mergeUisngGap(a1, a2, a1.length, a2.length);
        
 
		
		  System.out.print("First Array: "); for (int i = 0; i < a1.length; i++) {
		  System.out.print(a1[i] + " "); }
		  
		  System.out.println();
		  
		  System.out.print("Second Array: "); for (int i = 0; i < a2.length; i++) {
		  System.out.print(a2[i] + " "); }
		 
 

	}

	private static void mergeUisngGap(int[] nums1, int[] nums2, int length1, int length2) {
		
		
		int gap = length1+length2;
		int[] output = new int[length1+length2];
		int i;
		int j;
		for(gap = getGap(gap); gap > 0; gap = getGap(gap)) {
			
			for(i =0; i+gap < length1; i++) {
				
				if(nums1[i] > nums1[i+gap]) {
					int temp = nums1[i+gap]; 
					nums1[i+gap] = nums1[i];
					nums1[i] = temp;
				}
			}
			
			for(j = gap > length1 ? gap -length1 : 0 ; i <length1 && j < length2; i++, j++) {
				
				if(nums1[i] > nums2[j]) {
					
					int temp = nums1[i];
					nums1[i] = nums2[j];
					nums2[j] = temp;
				}
			}
			
			if( j < length2) {
				
				for(j = 0; j + gap < length2; j++) {
					
					if( nums2[j] > nums2[j+gap]) {
						
						int temp = nums2[j];
						nums2[j] = nums2[j+gap];
						nums2[j+gap] = temp;
					}
				}
			}
		}
		
		int k =0;
		
		while( k < nums1.length) {
			output[k] = nums1[k];
			k++;
		}
		
		int m =0;
		while(m < nums2.length) {
			output[k+m] = nums2[m];
			m++;
		}
		System.out.println();
	}
	
	private static int getGap(int gap) {
		
		if(gap <=1) return 0;
		else return (gap/2) + (gap%2);
	}

}
