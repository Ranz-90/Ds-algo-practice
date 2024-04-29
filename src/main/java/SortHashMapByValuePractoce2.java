import java.util.*;
import java.util.stream.Collectors;

public class SortHashMapByValuePractoce2 {

    public static void main(String[] args){

        Map<String,Integer> map = new HashMap<String,Integer>();

        map.put("G",20);
        map.put("B",10);
        map.put("C",30);

        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });


//map.keySet().stream().forEach(s -> System.out.println(s + " " + map.get(s)));

for(Map.Entry<String, Integer> enrty : list){
    System.out.println(enrty.getKey());
    System.out.println(enrty.getValue());
}

//java 8

        Map<String, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                                         .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2) -> e1,LinkedHashMap::new));
    }
}
