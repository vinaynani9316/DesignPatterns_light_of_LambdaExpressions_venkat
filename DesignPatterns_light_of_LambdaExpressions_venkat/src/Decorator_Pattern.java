import java.util.function.*;
public class Decorator_Pattern 
{
	// here Function is an interface.
	public static void doWork(int value, Function<Integer, Integer> func)
	{
		System.out.println(func.apply(value));
	}

	public static void main(String[] args) 
	{
		Function<Integer, Integer> inc = e->e+1;
		Function<Integer, Integer> doubleIt= e-> e*2;
		
		doWork(5, inc);
		doWork(5, doubleIt);
//		//increment & double using temp variable don't do like this
//		int temp =inc.apply(5);
//		System.out.println(doubleIt.apply(temp));		
		doWork(5, inc.andThen(doubleIt));
		
		
		

	}

}
