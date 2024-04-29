package array;

public class Sort012InArray {

/*    Input: {0, 1, 2, 0, 1, 2}
    Output: {0, 0, 1, 1, 2, 2}

    Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
    Output: {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}*/

    //Approach1: it can be solved using counting short. but that has 0(N)+O(N)+O(N) +O(N)
/*    but for that we need to count 0 1, and 2 seperately and
    print 0 in all indexes for 0 to noOfZeros-1
     run loop from  0+noOfZeros to < noOf1s and print 1
    run loop from 0+noOfZeros+noOf1s till < length and porint 2*/

  /*  Most optimal Approach: Using Dutch National Flag algorithm
    using 3 pointer , low, mid, high
    and idea is from 0 to left-1 is 0
    low to mid -1 is 1
    and high +1 till length is 2

    to do that algorithm is initially point low and mid = 0 and high = legth -1
     Iterate mid till it crosses high ...and we can have 3 conditions:
    if number is 0 --> swap low and mid and increment low and mid by 1
    if number is 1 -- simple increment mid by 1 nothing else
     if number is 2 swap mid with right and decrement right by 1*/

    public static void main(String[] args){

        int[] input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};

         sort0s1sAnd2(input, input.length);
        for(int sorted : input){
            System.out.println(sorted);
        }
    }

    private static void sort0s1sAnd2(int[] input, int length) {
        int low =0;
        int mid = 0;
        int high = length-1;

        while(mid <= high){

            switch (input[mid]) {
                //if number is 0 --> swap low and mid and increment low and mid by 1
                case 0: {
                    int temp = input[low];
                    input[low] = input[mid];
                    input[mid] = temp;
                    low++;
                    mid++;
                    break;
                }
                //if number is 1 -- simple increment mid by 1 nothing else
                case 1: {
                    mid++;
                    break;
                }
                // if number is 2 swap mid with right and decrement right by 1
                case 2: {
                    int temp2 = input[high];
                    input[high] = input[mid];
                    input[mid] = temp2;
                    high--;
                    break;
                }

            }


            }
    }
}
