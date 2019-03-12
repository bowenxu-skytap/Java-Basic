package Java8Lambda;

public class TypeInferenceExample {

	public static void main(String[] args) {
		printLambda(s -> s.length());
	}
	
	public static void printLambda(StringLengthLambda l) {
		System.out.println(l.getLength("Hello World"));
	}
	
	
}


interface StringLengthLambda {
	int getLength(String s);
}