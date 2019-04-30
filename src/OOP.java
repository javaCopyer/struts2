import java.util.HashMap;
import java.util.Map;


public class OOP {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String, String>();
		Map<String, String> map2 = map;
		map2.put("name", "java");
		map.put("age", "100");
		System.out.println(map2.toString());
	}
}
