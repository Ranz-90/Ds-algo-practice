package array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args){
        int[] input = {2,3,5,7};
        int target =16;
        List<List<Integer>> finalList = findCombination(input,target);
        if(null != finalList && !finalList.isEmpty()){
            for(List<Integer> validCombo : finalList){
                System.out.println(validCombo);
            }
        }
    }
    private static List<List<Integer>> findCombination(int[] input, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        getCombinations(input,0,target,ans,new ArrayList<Integer>());
        return ans;
    }

    private static void getCombinations(int[] input, int index,int target, List<List<Integer>> ans, ArrayList<Integer> ds) {

/*        if(index == input.length){*/
            if(target ==0){
                ans.add(new ArrayList<>(ds));
            }
            else{
                return;
            }
/*            return;
        }*/

             if(input[index] <= target){
                 ds.add(input[index]);
                 getCombinations(input,index,target-input[index],ans,ds);
                 ds.remove(ds.size()-1);
             }
        getCombinations(input,index+1,target,ans,ds);
    }
}
