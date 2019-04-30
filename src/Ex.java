
public class Ex {
	public static void main(String[] args) {
		try {
			say();
			System.out.println("main");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void say() throws Exception {
		try {
			todo();
			System.out.println("say");
			System.out.println("todo exception");
		} catch(Exception e) {
			throw e;
		}
			
		
	}
	public static void todo() throws Exception {
		throw new Exception("todo");
	}
}
