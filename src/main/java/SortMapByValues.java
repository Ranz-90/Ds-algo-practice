import java.util.*;
import java.util.Map.Entry.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SortMapByValues {

    public static void main(String[] args){

        Map<String, Integer> map = new HashMap<>();

        map.put("USA", 100);
        map.put("jobs", 200);
        map.put("software", 50);
        map.put("technology", 70);
        map.put("opportunity", 200);

List<Map.Entry<String, Integer>> entryList = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {

    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return o1.getValue().compareTo(o2.getValue());
    }
});

        map.keySet().stream().forEach(s -> System.out.println(s + " " + map.get(s)));

        final Map<String, Integer> sortedByCount = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        final Map<String, Integer> sortedByCount1 = map.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        final Map<String, Integer> sortedByCount2 = map.entrySet()
                .stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2) -> e1,LinkedHashMap::new));


    }



}
