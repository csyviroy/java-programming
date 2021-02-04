package com.example.generic_code;

public class GenericMethod {
	public static <Z> void printArray(Z[] inputArray) {
		for (Z element: inputArray) {
	         System.out.printf("%s ", element);
		}
		System.out.println();
	}
	
	public static <z> void printElement(z element) {
		System.out.println(element);
	}
	
	public static <z extends Dog> void printDog(z element) {
		element.bark();
	}
	
	public static <z extends Shiba> void printDogge(z element) {
		element.bark();
	}
	
	public static void main(String []args) {
	      // Create arrays of Integer, Double and Character
	      Integer[] intArray = { 1, 2, 3, 4, 5 };
	      Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
	      Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

	      System.out.println("Array integerArray contains:");
	      printArray(intArray);   // pass an Integer array

	      System.out.println("\nArray doubleArray contains:");
	      printArray(doubleArray);   // pass a Double array

	      System.out.println("\nArray characterArray contains:");
	      printArray(charArray);   // pass a Character array
	      
	      for (int i : intArray) {
	    	  printElement(i);
	      }
	      
	      Shiba d1 = new Shiba();
	      GermanShepherd d2 = new GermanShepherd();
	      
	      printDog(d1);
	      printDog(d2);

	      printDogge(d1);
	      //printDogge method use type placehold 'z' that is extends to Shiba, GermanShepherd is not extend to Shiba
	      //printDogge(d2);
	}
}
