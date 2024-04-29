import java.util.*;

public class InsertUpdateDeleteInConsistentTime {

    //Task is to design a Data Structure which supports insert, delete, random , search in O(1);

    //The idea is we have to use Map with Array or ArrayList . ArrayList is preferable as it is resizable

/*    insert(x)
1) Check if x is already present by doing a hash map lookup.
            2) If not present, then insert it at the end of the array.
3) Add in the hash table also, x is added as key and last array index as the index.
            remove(x)
            1) Check if x is present by doing a hash map lookup.
2) If present, then find its index and remove it from a hash map.
            3) Swap the last element with this element in an array and remove the last element.
    Swapping is done because the last element can be removed in O(1) time.
            4) Update index of the last element in a hash map.
    getRandom()
1) Generate a random number from 0 to last index.
2) Return the array element at the randomly generated index.
            search(x)
    Do a lookup for x in hash map.
    Below is the implementation of the data structure.*/

    List<Integer> list;

    Map<Integer, Integer> map;

    public InsertUpdateDeleteInConsistentTime() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }

    void insert(int val){

        //check if value is present then simply return

        if(map.get(val) != null){
            return;
        }

        //otherwise insert in list and map , in map always insert last index of list that is list.size;
        int size = list.size();
        list.add(val);
        map.put(val,size);

    }

    //very important
    void remove(int val){

        //if value is not present simply return
        Integer index = map.get(val);
        if(null == index){
            return;
        }

        //else -- very important

        //step 1: remove from map;

        map.remove(val);

        //Step 2: this is the trick
        //if u simply remove from list then all indexes needs to be rearranged which cost is O(N)
        //so we have swap the last element of list with the found element
        //so that we can remove from list by list.remove(size-1) by O(1)
        //so to remove from last index of List the found element has to come to end , hence swap is needed

        int last = list.get(list.size()-1);

        //swap last with index (where it found)
        Collections.swap(list, index, list.size()-1);

        //once swapped means the element we want to remove is at end of list now, so lets remove\
        list.remove(list.size()-1);

        //update the map index of last element with the found index;
        map.put(last, index);

    }

    int getRandom(){

        Random rand = new Random();
        int randomVal = rand.nextInt(list.size());

        return map.get(randomVal);
    }

    Integer search(int val){
        return map.get(val);
    }
}
