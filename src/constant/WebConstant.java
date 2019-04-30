package constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class WebConstant {
	public static final String jsonResName = "jsonstr";
	public static final String dowmloadName = "download";
	public static final Map<String, HttpSession> sessionMap = new HashMap<String, HttpSession>();
	public static final List<String> users = new ArrayList<String>();
	static {
		users.add("user1");
		users.add("user2");
		users.add("user3");
	}
	
	
}
