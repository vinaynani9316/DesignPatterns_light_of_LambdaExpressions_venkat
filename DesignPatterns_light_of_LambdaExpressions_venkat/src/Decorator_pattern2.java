import java.awt.Color;
import java.util.function.Function;
import java.util.stream.Stream;


@SuppressWarnings("unchecked")          //this removes warnings
class Camera
{
	private static Function<Color,Color> filter;
	public Camera(Function<Color,Color>...filters)
	{
		setFilters(filters);
	}
	public void setFilters(Function<Color,Color>...filters)
	{
		filter = Stream.of(filters)
				       .reduce(Function.identity(),
				    		   Function::andThen);           // this is worth effective & concise    
//				    		   color-> color,                      // or this
//				    		   (theFilters, aFilter)->
//				    		   theFilters.andThen(aFilter));
				    		   
	}
	public static Color snap(Color input)
	{
		return filter.apply(input);
	}
}
@SuppressWarnings("unchecked")
public class Decorator_pattern2 
{
	public static void printSnap(Camera camera)
	{
		System.out.println(Camera.snap(new Color(125, 125, 125)));
	}

	public static void main(String[] args) 
	{
		printSnap((new Camera()));                     // 125
		
		printSnap((new Camera(Color::brighter)));     // 178
		
		printSnap((new Camera(Color::darker)));      //87
		
		printSnap((new Camera(Color::brighter, Color::darker)));  //124
		

	}

}
