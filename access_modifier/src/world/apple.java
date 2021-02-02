package world;

public class apple {
	String color = "Red";
	String accessibility;
	public apple(){
		//Cannot access no modifier pear from other package
		//pear p = new pear();
	}
	
	public void printHelloWorld() {
		System.out.print("Hello World!");
	}
	
	private String getAppleColor() {
		return this.color;
	}
	
	protected void setAccessibility(String accessibility) {
		this.accessibility = accessibility;
		//Can call private method
		this.getAppleColor();
		
	}
}
