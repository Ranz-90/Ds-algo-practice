package array;

import java.util.*;

public class MinSwapsToMakeArrayIdentical {

    public static void main(String[] args){
        int a[] = {3, 6, 4, 8};
        int b[] = {4, 6, 8, 3};
        int n = a.length;

        int minSwaps = getMinSwaps(a,b,n);
    }


    private static int getMinSwaps(int[] a, int[] b, int n) {

        Map<Integer,Integer> map = new HashMap<>();

        for(int i =0; i <n;i++){
            map.put(b[i],i);
        }

        for(int j =0; j <n; j++){
            b[j] = map.get(a[j]);
        }

        return minSwap(b,n);
    }

    private static int minSwap(int[] b, int n) {

        List<List<Integer>> arrPos = new ArrayList<>();

        for(int k=0; k < n; k ++){
            arrPos.add(Arrays.asList(b[k],k));
        }

        Collections.sort(arrPos, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });

        // To keep track of visited elements. Initialize
        // all elements as not visited or false.
        boolean[] vis = new boolean[n];

        // Initialize result
        int ans = 0;

        // Traverse array elements
        for (int i = 0; i < n; i++)
        {

            // already swapped and corrected or
            // already present at correct pos
            if (vis[i] || arrPos.get(i).get(1) == i)
                continue;

            // find out the number of  node in
            // this cycle and add in ans
            int cycle_size = 0;
            int j = i;
            while (!vis[j])
            {
                vis[j] = true;

                // move to next node
                j = arrPos.get(j).get(1);
                cycle_size++;
            }

            // Update answer by adding current cycle.
            ans += (cycle_size - 1);
        }

        // Return result
        return ans;
    }
}
