package Set1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8Test {

	public static boolean check(List l , Predicate<List> p) {
		return p.test(l);
	}
	/*
	 * public static void main(String[] args) { boolean b = check(new ArrayList<>(),
	 * al -> al.isEmpty()); System.out.println(b);
	 * 
	 * }
	 */
	
	public static  void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		
		list.add(23);
		list.add(12);
		list.add(2);
		list.add(6);
		

		
		//list.stream().collect(Collectors.toMap(Function.identity(), true));
		
		Map<Integer, Object> map = list.stream().collect(Collectors.toMap(Function.identity(), e -> true));
		
		System.out.println();
		
		Map<String, Integer> map1 = new HashMap<>();
		
		map1.put("A", 4);
		
		map1.put("B",9);
		map1.put("C", 2);
		
		map1.entrySet().stream().sorted(Map.Entry.comparingByValue())
		.collect(Collectors.toMap(e -> e.getKey(),e -> e.getValue(),(e1,e2) -> e2));
		
		/*
		 * Map<String, Integer> sorted = map1 .entrySet() .stream()
		 * .sorted(Map.Entry.comparingByValue()) .collect( toMap(e -> e.getKey(), e ->
		 * e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
		 */
		//map.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed()).collect(Collectors.toMap(null, null, null));
		
		System.out.println();
	}

}
