package carApp;

import java.util.*;


class MemberHandler {
	int idx=6;
	ArrayList<MemberDTO> members=new ArrayList<>();
	Scanner sc=new Scanner(System.in);
	
	public MemberHandler() {
		
	}

	public void memberInsert() { // 회원가입용 메소드
		String cusid;
		String cuspassword;
		String cusname;
		String cusaddress;
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		cusid = sc.nextLine();
		for(int i=0;i<members.size();i++) {
			if(members.get(i).getCusid().compareTo(cusid)==0){
				System.out.println("중복된 아이디입니다!");
				break;
			}					
		}
		System.out.print("암 호 : ");
		cuspassword = sc.nextLine();
		System.out.print("이 름 : ");
		cusname = sc.nextLine();
		System.out.print("주 소 : ");
		cusaddress = sc.nextLine();
		members.add(new MemberDTO(cusid,cuspassword,cusname,cusaddress));
		System.out.println("가입 완료!! \n");
	}

	

	public void memberLogin() { // 회원로그인용 메소드
		ArrayList<MemberDTO> members=new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		String cusid = sc.nextLine();
		System.out.print("패스워드 : ");
		String cuspassword = sc.nextLine();

		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getCusid().equals(cusid) && members.get(i).getCuspassword().equals(cuspassword)) {
				System.out.println("환영합니다.");
				System.out.println("로그인에 성공하였습니다. \n");
				break;
			} else if (!members.get(i).getCusid().equals(cusid)) {
				System.out.println("존재하지 않는 아이디입니다. \n");
				return;
			} else if (members.get(i).getCusid().equals(cusid) && !members.get(i).getCuspassword().equals(cuspassword)) {
				System.out.println("암호가 잘못되었습니다. \n");
				return;
			}
		}
	}
}

class LoginMenu {
	public static void main(String[] args) {
		MemberHandler handler = new MemberHandler();
		MemberDAO mem=new MemberDAO();
		mem.MemberDTO();

		while (true) {
			System.out.println("------- 메뉴 선택 -------");
			System.out.println("1. 회원가입");
			System.out.println("2. 로 그 인");
			System.out.println("9. 프로그램 종료");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				handler.memberInsert();
				break;
			case 2:
				handler.memberLogin();
				break;
			case 9:
				System.out.println("프로그램 종료");
				return;
			}

		}
	}
}