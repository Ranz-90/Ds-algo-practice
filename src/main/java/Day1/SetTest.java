package Day1;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		
		
		//System.out.println(this);
		
		
		  Set<Empployee> employeSet = new TreeSet<>();
		  
		  Empployee e1 = new Empployee("Sam", "Roy"); 
		  Empployee e2 = new Empployee("Sam", "Roy");
		  
		  employeSet.add(e1); employeSet.add(e2);
		  
		  System.out.println("The size is " + employeSet.size());
		  
		  Day day = Day.SUNDAY;
		  
		  System.out.print(day.getVegOrNonveg());
	}

}
