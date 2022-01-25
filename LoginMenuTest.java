package carApp;

import java.util.Scanner;

public class LoginMenuTest {
		
	//고객 정보 추가
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		MemberDAO mem=new MemberDAO();
		mem.MemberDTO();
		while (true) {			
			System.out.println("------- 메뉴 선택 -------");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 회원정보수정");
			System.out.println("4. 회원탈퇴");
			System.out.println("5. 프로그램 종료");
			int choice=sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1://로그인
				mem.Login();
				break;
			case 2://회원가입
				mem.insertCustomerInfo();
				break;
			case 3://회원정보 수정
				mem.updateCustomerInfo();
				break;
			case 4://회원정보 삭제
				mem.deleteCustomerInfo();
				break;
			case 5:
				System.out.println("프로그램 종료");
				sc.close();
				System.exit(0);
			}

		}
		
	}

}
