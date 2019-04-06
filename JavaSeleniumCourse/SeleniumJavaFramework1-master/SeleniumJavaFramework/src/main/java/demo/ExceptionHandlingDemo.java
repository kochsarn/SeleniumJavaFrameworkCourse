package demo;

public class ExceptionHandlingDemo {

	public static void main(String[] args) {
		try{
			demo();
		} catch (Exception e) {
			
	       e.printStackTrace();
          	}

}	
	
	public static void demo()  {
		System.out.println("Hello World");
	//	throw new ArithmeticException("not valid operation");
		 int i = 10/1;				
		System.out.println("Completed");
}

}
