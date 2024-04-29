package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = Arrays.asList("A","B","C");
		
		Predicate<String> prd = str -> str.startsWith("A");
		
		Predicate<String> prd2 = str -> str.length() >=0;
		
		//list.stream().filter(prd).forEach(System.out::println);
		
		list.stream().filter(prd.and(prd2)).forEach(System.out::println);
	}

}
