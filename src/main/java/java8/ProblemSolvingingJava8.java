package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class ProblemSolvingingJava8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {10,20,30,40,50};
		int sum = IntStream.of(a).sum();
		
		List<Integer> a1 = Arrays.asList(10,20,35);
		
		int sum1 = a1.stream().reduce(0, (e1,e2) -> e1+e2);
		
		//reduce method
		
		 List<String> words = Arrays.asList("GFG", "Geeks", "for",
                 "GeeksQuiz", "GeeksforG");
		   Optional<String> longestString = words.stream()
                   .reduce((word1, word2)
             -> word1.length() > word2.length()
                           ? word1 : word2);
		   
		   Optional<String> longest = words.stream()
				                      .reduce((word1,word2) -> word1.length() > word2.length()? word1 : word2);
		   
		   Optional<String> combine = words.stream().reduce((word1, word2)-> word1.concat(word2));
	}

}
