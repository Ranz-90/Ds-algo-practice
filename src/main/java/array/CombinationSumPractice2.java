package array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumPractice2 {
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

        List<List<Integer>> listOfCombo = new ArrayList<>();
        findCombo(listOfCombo,new ArrayList<Integer>(),target,input,0);
        return listOfCombo;
    }

    private static void findCombo(List<List<Integer>> listOfCombo, List<Integer> myDs, int target, int[] input,int index) {

        if(target < 0)return;

        if(target ==0){
            listOfCombo.add(new ArrayList<>(myDs));
        }

        for(int i =index; i <input.length; i++){
            myDs.add(input[i]) ;
            findCombo(listOfCombo,myDs, target - input[i],input,i);
            myDs.remove(myDs.size()-1);

        }
    }

}
