package Java8Lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample2 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), 
											new Person("Lewis", "Carroll", 42),
											new Person("Thomas", "Carlyle", 51),
											new Person("Charlotte", "Bronte", 45),
											new Person("Matthew", "Arnold", 39));
		
		//step 2: create a method that prints all elements in the list
		performAllWithCondition(people, p -> true, System.out::println); // p -> method(p)
		
	}
	
	public static void performAllWithCondition(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		for(Person p: people) {
			if (predicate.test(p)) {
				consumer.accept(p);
			}
		}
	}
	
}
