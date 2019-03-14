package Java8Lambda;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {

	public static void main(String[] args) {
		int[] someNumbers = {1, 2, 3, 4};
		int key = 0;
		
		process(someNumbers, key, wrapperLambda((a, b) -> System.out.println(a / b)));
	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
		for (int num: someNumbers) {
			consumer.accept(num, key);
		}
	}
	
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
		return (a, b) -> {
			try {
				consumer.accept(a, b);
			} catch(Exception e) {
				System.out.println(e);
			}
		};
	}

}
