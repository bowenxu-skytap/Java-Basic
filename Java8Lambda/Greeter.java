package Java8Lambda;

public class Greeter {

	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		
		Greeting helloWorldGreeting = new Greeting() {
			@Override
			public void perform() {
				System.out.println("Hello World");
			}
		};
		
		Greeting lambdaGreeting = () -> System.out.println("Hello World");
		
		
		greeter.greet(helloWorldGreeting);
		greeter.greet(lambdaGreeting);
	}
	
	public void greet(Greeting greeting) {
		greeting.perform();
	}

}
