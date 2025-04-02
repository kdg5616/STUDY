import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BackEnd {
	
	void creatMemberInfo(String id, String pw, String name, int age,boolean domestic) {
		if (null != id) {
			id.trim();
			if (!"".equals(id) ) {
				Database.save(id, pw, name, age, domestic);
		}else{
			System.out.println("id is blank.");
		}
		}else {
			System.out.println("id is null");
		}
	}
	
	List<Map<String, Object>> viewmemberList() {
		
		List<Map<String, Object>> memberList = Database.search();
		List<Map<String, Object>> idNameList = new ArrayList<Map<String,Object>>();
		
		for (int i = 0 ; i < memberList.size() ; i++) {
			Map<String, Object> memberMap = new HashMap<String, Object>();
			memberMap.put("id", memberList.get(i).get("id"));
			memberMap.put("name", memberList.get(i).get("name"));
			idNameList.add(memberMap);
		}
		return idNameList;
	}
	
}