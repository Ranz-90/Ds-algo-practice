import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	public static void main(String[] args) {
		
		int[] candidates = {10,1,2,7,6,1,5};
		
		int target = 8;
		
		Arrays.sort(candidates);;
		
        List<List<Integer>> output = new ArrayList<>();
        
        List<Integer> subList = new ArrayList<>();
        
        int length = candidates.length;
        
		/*
		 * Map<Integer, Integer> map = new HashMap<>();
		 * 
		 * for(int i =0; i <= length; i++){
		 * map.put(candidates[i],map.getOrDefault(candidates[i],0)+1); }
		 */
        
        findCombination(candidates,length,target,subList,output,0);
        
       for(List<Integer> list : output) {
    	   System.out.println(list);
       }

	}
	
    public static void findCombination(int[] candidates,int length,int target, List<Integer> subList, List<List<Integer>> output, int index){
        
    	if(target < 0) {
    		return;
    	}
        
        if(target == 0){
           output.add(new ArrayList<>(subList));
            return;
        }
        
        
        for(int i = index; i < length; i++){
        	if(i > index && candidates[i] == candidates[i-1]) continue;
        	
              subList.add(candidates[i]);
            findCombination(candidates,length,target-candidates[i],subList,output,i+1);
                subList.remove(subList.size() -1);
        }
    }

}
