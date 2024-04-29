package java8;

import java.util.Optional;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

public class SupplierTest {

	public static void main(String[] args) {
		/*
		 * Supplier<Double> ds1 = () -> Math.random();
		 * 
		 * DoubleSupplier ds2 = Math::random;
		 * 
		 * System.out.println(ds1.get()); System.out.println(ds2.getAsDouble());
		 */
		

		Supplier<Double> ds1 = () -> Math.random();
		
		Optional<Double> op = Optional.empty();
		
		
		System.out.println(op.orElseGet(ds1));
		
	}

}
