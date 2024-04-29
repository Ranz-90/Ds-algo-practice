package Set1;

class child extends Base{
	child(String s){
		System.out.println("sub -" +s);
	}
	
	public static void main(String[] args) {
		child c = new child("2");
	}
}
