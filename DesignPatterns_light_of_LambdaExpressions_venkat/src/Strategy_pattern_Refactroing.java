import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
public class Strategy_pattern_Refactroing 
{
	//higher order function
	private static int totalValues(List<Integer> values, Predicate<Integer> selector)
	{
//		int result=0;
//		for(int e: values)
//			if(selector.test(e))
//				result +=e;
//		return result;
		
		return values.stream()
				     .filter(selector)                // .mapToInt(e->e)
				     .reduce(0, Integer::sum);        // .sum();
	}

	public static void main(String[] args) 
	{
		List<Integer> numbers =Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		System.out.println(totalValues(numbers, e-> true));
//		System.out.println(totalValues(numbers, e-> e%2==0));
//		System.out.println(totalValues(numbers, e-> e%2 !=0));
		
		System.out.println(totalValues(numbers, Util::isEven));
		System.out.println(totalValues(numbers, Util::isOdd));
		

	}

}
class Util
{
	public static boolean isEven(int number)
	{
		return number%2==0;
	}
	
	public static boolean isOdd(int number)
	{
		return number%2!=0;
		
	}
}
