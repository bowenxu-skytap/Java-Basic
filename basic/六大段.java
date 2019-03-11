1. Immutable Class
/**
 * How to define an immutable class?
 * 1. class is final
 * 2. all fields are private (*and final)
 * 3. define constructors for initialization
 * 4. only getters, no setters
 */
public final class Person {
	private String name; // official is "private final String name;"
	private double salary;	
	public Person() {}
//	For the case that added final keyword in the fields 
//	public Person() {
//		this.name = null;
//		this.salary = 0;
//	}
	public Person(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public double getSalary() { 
		return salary; 
	}
	public Person addPrefix(String prefix) {
		return new Person(prefix + " " + name, salary);
	}
	public Person increaseSalary() {
		return new Person(name, salary * 1.1); 
	}
}

2. Cloneable
/**
 * 1. implements Cloneable
 * 2. Override clone()
 */
public class Original implements Cloneable{
	private String str;
	public Original() {}
	public Original(String str) {
		this.str = str;
	}
	public String getStr() {
		return this.str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	@Override
	public Original clone() throws CloneNotSupportedException {
		return	(Original)super.clone();
	}
}

3. Hashcode & Equals
/**
 * 1. Override hashCode() and equals()
 */
public class WrappedString {
	private String str;
	public WrappedString() {}
	public WrappedString(String str) {
		this.str = str;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	@Override
	public int hashCode() {
		return str.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof WrappedString)) {
			return false;
		}
		WrappedString ws = (WrappedString) obj;
		return this.str.equals(ws.str);
	}
}

4. Singleton
/**
 * Singleton Pattern 
 * 1. private constructor
 * 2. static "MySingle" field
 * 
 * Lazy-model: we didn't create an instance of a class until we use it.
 * 		benefit - save memory
 * Greedy-model: a object is created when we load it
 * 		"private static MySingle instance = new MySingle();"
 * Thread-safe: good performance, memory-safe
 */

public class MySingle {
	private static MySingle instance;
	private MySingle() {}
	public static MySingle getInstance() {
		if(instance == null) {
			synchronized(MySingle.class) {
				if(instance == null) {
					instance = new MySingle();
				}
			}
		}
		return instance;
	}
}

5. Comparable & Comparator
(1)Comparable
/**
 * Implement Comparable
 */
public class BeanA implements Comparable<BeanA> {
	private int x;
	public BeanA() {}
	public BeanA(int x) {
		this.x = x;
	}
	public int getX() {
		return this.x;
	}
	public void setX(int x) {
		this.x = x;
	}
	@Override
	public int compareTo(BeanA another) {
		if(x < another.x) {
			return -1;
		} else if(x == another.x) {
			return 0;
		} else {
			return 1;
		}
	}
}
public class TestComparable {
	@Test
	public void test() {
		List<BeanA> list = new ArrayList<BeanA>();
		list.add(new BeanA(5));
		list.add(new BeanA(7));
		list.add(new BeanA(3));
		assertEquals(5, list.get(0).getX());
		assertEquals(7, list.get(1).getX());
		assertEquals(3, list.get(2).getX());
		Collections.sort(list);
		assertEquals(3, list.get(0).getX());
		assertEquals(5, list.get(1).getX());
		assertEquals(7, list.get(2).getX());
	}
}
(2)Comparator
public class BeanB {
	private int x;
	public BeanB() {}
	public BeanB(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
}
	@Test
	public void test() {
		List<BeanB> list = new ArrayList<BeanB>();
		list.add(new BeanB(5));
		list.add(new BeanB(7));
		list.add(new BeanB(3));
		assertEquals(5, list.get(0).getX());
		assertEquals(7, list.get(1).getX());
		assertEquals(3, list.get(2).getX());
		Collections.sort(list, new Comparator<BeanB>(){
			@Override
			public int compare(BeanB first, BeanB second) {
				return first.getX() - second.getX();
			}
		});
		assertEquals(3, list.get(0).getX());
		assertEquals(5, list.get(1).getX());
		assertEquals(7, list.get(2).getX());		
	}

6. Iterator
	/**
	 * Iterate List/Set/Map
	 */
	@Test
	public void test() {
		List<String> list = new ArrayList<String>();
		list.add("blue");
		list.add("yellow");
		list.add("red");
		list.add("green");
		list.add("orange");
		System.out.println("Iterate List:");
		//(1)
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println();
		//(2)
		for(String str: list) {
			System.out.println(str);
		}
		System.out.println();
		//(3)
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();
		
		Set<String> set = new HashSet<String>();
		set.add("blue");
		set.add("yellow");
		set.add("red");
		set.add("green");
		set.add("orange");
		System.out.println("Iterate Set:");
		//(1)
		for(String str: set) {
			System.out.println(str);
		}
		System.out.println();
		//(2)
		Iterator<String> itSet = set.iterator();
		while(itSet.hasNext()) {
			System.out.println(itSet.next());
		}
		System.out.println();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("bowen", 26);
		map.put("renee", 27);
		map.put("tom", 42);
		map.put("john", 19);
		System.out.println("Iterate Map:");
		Set<String> keySet = map.keySet();
		//(1)
		for(String key: keySet) {
			System.out.println(key + ": " + map.get(key));
		}
		System.out.println();
		//(2)
		Iterator<String> it_keySet = keySet.iterator();
		while(it_keySet.hasNext()) {
			String key = it_keySet.next();
			System.out.println(key + ": " + map.get(key));
		}
		System.out.println();
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		//(3)
		for(Map.Entry<String, Integer> entry: entrySet) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		System.out.println();
		//(4)
		Iterator<Map.Entry<String, Integer>> it_entry = entrySet.iterator();
		while(it_entry.hasNext()) {
			Entry<String, Integer> each = it_entry.next();
			System.out.println(each.getKey() + ": " + each.getValue());
		}
	}
