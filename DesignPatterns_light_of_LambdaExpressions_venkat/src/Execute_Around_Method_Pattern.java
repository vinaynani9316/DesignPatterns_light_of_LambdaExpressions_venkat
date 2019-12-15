import java.lang.AutoCloseable;
import java.util.function.Consumer;
public class Execute_Around_Method_Pattern 
{
	public static void main(String[] args) 
	{                                              
//		try(Resource resource=new Resource()) // from Java7 we have ARM Automatic resource management try does not need finally or catch block
//		{
//		resource.op1();
//		resource.op2();   
//		}                           OR
		
		Resource.use(resource-> 
	    resource.op1()
	            .op2());
	}
}
class Resource                                // implements AutoCloseable
{
	private Resource()
	{
		System.out.println("created...");
	}
	public Resource op1()
	{
		System.out.println("op1");
		return this;
	}
	public Resource op2()
	{
		System.out.println("op2");
		return this;
	}
//	public void finalize()             // don't do this because if memory is high then it will not go in to garbage 
//	{
//		System.out.println("cleanup....");
//	}
	private void close()    // instead close the portal so it automatically closes the memory
	{
		System.out.println("cleanup....");
	}
	public static void use(Consumer<Resource> block)
	{
		Resource resource =new Resource();
		try
		{
			block.accept(resource);
		}
		finally
		{
			resource.close();
		}
	}
}
