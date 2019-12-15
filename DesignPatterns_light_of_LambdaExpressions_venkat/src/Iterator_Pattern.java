import java.util.Arrays;
import java.util.List;

public class Iterator_Pattern {

	public static void main(String[] args) {
		
		//External iterators
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		for(int i=0;i<numbers.size(); i++)
			System.out.println(numbers.get(i));
		
		System.out.println("************");
		
		
		for(int i: numbers)
			System.out.println(i);
		System.out.println("************");
		
		//internal iterators
		numbers.forEach(e-> System.out.println(e));
		System.out.println("************");
		
		numbers.forEach(System.out::println);
		

	}

}
