package Day1;

public class Empployee implements Comparable<Empployee> {
	
	String firstName;
	String lastName;
	
	
	public Empployee(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	

	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}



	@Override
	public int compareTo(Empployee o) {
		
		if(this.firstName == o.getFirstName() && this.lastName == o.getLastName()) {
			return 0;
		}
		else if(this.firstName != o.getFirstName()){
			return 1;
		}
		return -1;
	}
	

}


