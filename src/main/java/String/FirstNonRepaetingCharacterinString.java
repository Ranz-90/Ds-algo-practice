package String;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepaetingCharacterinString {

    static final int totalChars = 256;
    public static void main(String[] args){
        String str = "Geeksfor";

        int output = getNonRepeatingChars(str);
        if(output < Integer.MAX_VALUE)System.out.println(str.charAt(output));

    }

    private static int getNonRepeatingChars(String str) {

        Map<Character, CounterIndex> map = new HashMap<>(totalChars);
        int result = Integer.MAX_VALUE;

        for(int i =0; i <str.length();i++){

            if(null != map.get(str.charAt(i))){
                //If charcater is found dont do anything jyust increment
                CounterIndex cIndex = map.get(str.charAt(i));
                cIndex.increment();
            }
            //if not present insrted with default count 1
            else{
                map.put(str.charAt(i),new CounterIndex(i));
            }
        }

        for(Map.Entry<Character, CounterIndex> entry : map.entrySet()){
            int cnt = entry.getValue().count;
            int ind = entry.getValue().index;
            if(cnt == 1 && ind < result ){
               result= ind;
            }
        }
        return result;
    }
}

class CounterIndex{

    int count;
    int index;

    public CounterIndex(int index){
        this.index = index;
        this.count =1;
    }

    public void increment(){
        count++;
    }
}
