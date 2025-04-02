import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FrontEnd {
	
	Scanner scanner = new Scanner(System.in);
	BackEnd backEnd = new BackEnd();
	
	void start() {
		while (true) {
			System.out.println("[회원관리시스템]");
			System.out.println("1.회원등록");
			System.out.println("2.회원조회");
			System.out.println("9.종료");
			System.out.println("번호를 입력하시오");
			String menuNo = scanner.next();
			if ("1".equals(menuNo) ) {
				System.out.println("[회원관리시스템>회원등록]");
				System.out.println("id : ");
				String id = scanner.next();
				System.out.println("pw : ");
				String pw = scanner.next();
				System.out.println("name : ");
				String name = scanner.next();
				System.out.println("age : ");
				int age = Integer.parseInt(scanner.next());
				System.out.println("domestic(y/n)");
				boolean domestic = Boolean.valueOf(scanner.next());
				backEnd.creatMemberInfo(id, pw, name, age, domestic);
			}
			if ("2".equals(menuNo) ) {
				System.out.println("[회원관리시스템>회원조회]");
				List<Map<String, Object>> idNameList = backEnd.viewmemberList();
				for (int i = 0 ; i < idNameList.size() ; i++) {
					System.out.printf("%d) %s | %s", (i+1), idNameList.get(i).get("id"), idNameList.get(i).get("name"));
					System.out.println();
				}
			}
			if ("9".equals(menuNo) ) {
				break;
			}
		}
		System.out.println("프로그램 종료");
	}
}
