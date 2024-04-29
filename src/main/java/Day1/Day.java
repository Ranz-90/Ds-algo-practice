/**
 * 
 */
package Day1;

/**
 * @author 91700
 *
 */
public enum Day {
	
	   // enum constants calling the enum constructors 
	   SATURDAY(true),
	   SUNDAY(false),
	   MONDAY(true),
	   TUESDAY(true);
	
private final boolean isVeg;
	
	private Day(boolean isVeg) {
		this.isVeg = isVeg;
	}
	
	public boolean getVegOrNonveg() {
		return this.isVeg;
	}
}
