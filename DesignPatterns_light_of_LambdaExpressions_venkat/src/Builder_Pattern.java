import java.util.function.Consumer;

public class Builder_Pattern 
{
	public static void main(String[] args) 
	{
		Mailer.send(mailer->mailer
		.to("vinaynani93@gmail.com")
		.from("vinay@gmail.com")
		.subject("java developer")
		.body("looking for java developer"));
		
    }
}
class Mailer
{
	public static void print(String msg)
	{
		System.out.println(msg);
	}
	
//	public void from(String addr) {print("from");}
//	public void to(String addr) {print("to");}
//	public void subject(String line) {print("subject");}
//	public void body(String msg) { print("body");}
//	public void send() {System.out.println("Sending...");}
	
	public Mailer from(String addr) {print("from"); return this;}
	public Mailer to(String addr) {print("to"); return this;}
	public Mailer subject(String line) {print("subject"); return this;}
	public Mailer body(String msg) { print("body"); return this;}
	public static void send(Consumer<Mailer> block) 
	{
		Mailer mailer= new Mailer();
		block.accept(mailer);
		System.out.println("Sending...");
	}
	
	
}
