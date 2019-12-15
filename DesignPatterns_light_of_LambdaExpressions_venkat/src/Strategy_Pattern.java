import java.util.Arrays;
import java.util.List;

public class Strategy_Pattern
{

	public static void main(String[] args) 
	{
		List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		System.out.println(totalValues(numbers));
		System.out.println(totalEvenValues(numbers));
		System.out.println(totalOddValues(numbers));
	}
	// total All values
	private static int totalValues(List<Integer>values) {
		
		int result=0;
		 for(int e:values)
			 result += e;
		 return result;
	}
	// total all even values
	private static int totalEvenValues(List<Integer> values)
	{
		int result=0;
		
		for(int e: values)
			if(e%2==0)
				result+=e;
				return result;
	}
	// total all odd values
	private static int totalOddValues(List<Integer> values)
	{
		int result=0;
		for(int e:  values)
			if(e%2!=0)
				result +=e;
		return result;
	}

}
