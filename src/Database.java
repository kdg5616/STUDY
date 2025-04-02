import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Database {
	
	private static List<Map<String, Object>> memberList = new LinkedList<Map<String, Object>>();
	
	static void save(String id, String pw, String name, int age,boolean domestic) {
		Map<String, Object> memberMap = new HashMap<String, Object>();
		memberMap.put("id", id);
		memberMap.put("pw", pw);
		memberMap.put("name", name);
		memberMap.put("age", age);
		memberMap.put("domestic", domestic);
		memberList.add(memberMap);
	}
	static List<Map<String, Object>> search() {
		return Database.memberList;
	}
}
