package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ConsumerTest {

	public static void main(String[] args) {
		
		Consumer<String> con = t -> System.out.println(t);
		Consumer<List<String>> cons2 = list ->{
			for(int i =0; i<list.size();i++) {
				list.set(i, list.get(i).toUpperCase());
			}
		};
		
		Consumer<List<String>> cons3 = list ->{
			list.stream().forEach(System.out::println);
		};
		
		List<String> list = Arrays.asList("a","b","c");
		
		//list.forEach(con);
		
		cons2.andThen(cons3).accept(list);

	}

}
