import java.util.Arrays;

public class MaximumPlatformsRequiredGFG {

/*    Given the arrival and departure times of all trains that reach a railway station,
    the task is to find the minimum number of platforms required for the railway station
    so that no train waits.
    We are given two arrays that represent the arrival and departure times of trains that stop.*/

/*    Examples:

    Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}
    dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
    Output: 3
    Explanation: There are at-most three trains at a time (time between 9:40 to 12:00)

    Input: arr[] = {9:00, 9:40}
    dep[] = {9:10, 12:00}
    Output: 1
    Explanation: Only one platform is needed.*/

    public static void main(String[] args){

        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        int n = 6;
        System.out.println(
                "Minimum Number of Platforms Required = "
                        + findPlatform(arr, dep, n));
    }

    private static int findPlatform(int[] arrival, int[] departure, int n) {

        int maxPlatFormNeeded = 1;
        int NoOfplatfroms = 1;

        //Step1: Sort arr and dept tarray in asc order

        Arrays.sort(arrival);
        Arrays.sort(departure);

        //Step2 : declare two pointer for arrival and departure to 0 and 1;
        //coz 1st tarin has to take one platfrom, so we will consider the departure time of 1st tarin

        int i =1;
        int j =0;

        while(i < n && j <n){

            //if departure of 1st train is greater than the arrival of 2nd train
            //means 1st train has to take one more platfrom
            //coz let say 1st train departure is 7 and 2nd train arrives at 5 means platfrom can not be reused
            if(arrival[i] <= departure[j]){
                NoOfplatfroms++;
                i++;
            }

            //case when platfrom can be resued
            //as arrival is greater than departure of next train means ...after departs
            //it can arrive at same platfrom
            else if(arrival[i]  > departure[j]){
                NoOfplatfroms--;
                j++;
            }
            maxPlatFormNeeded = Math.max(maxPlatFormNeeded,NoOfplatfroms);
        }

        return maxPlatFormNeeded;
    }

}
