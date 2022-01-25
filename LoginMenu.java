package carApp;

import java.util.*;


class MemberHandler {
	int idx=6;
	ArrayList<MemberDTO> members=new ArrayList<>();
	Scanner sc=new Scanner(System.in);
	
	public MemberHandler() {
		
	}

	public void memberInsert() { // ȸ�����Կ� �޼ҵ�
		String cusid;
		String cuspassword;
		String cusname;
		String cusaddress;
		Scanner sc = new Scanner(System.in);
		System.out.print("���̵� : ");
		cusid = sc.nextLine();
		for(int i=0;i<members.size();i++) {
			if(members.get(i).getCusid().compareTo(cusid)==0){
				System.out.println("�ߺ��� ���̵��Դϴ�!");
				break;
			}					
		}
		System.out.print("�� ȣ : ");
		cuspassword = sc.nextLine();
		System.out.print("�� �� : ");
		cusname = sc.nextLine();
		System.out.print("�� �� : ");
		cusaddress = sc.nextLine();
		members.add(new MemberDTO(cusid,cuspassword,cusname,cusaddress));
		System.out.println("���� �Ϸ�!! \n");
	}

	

	public void memberLogin() { // ȸ���α��ο� �޼ҵ�
		ArrayList<MemberDTO> members=new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.print("���̵� : ");
		String cusid = sc.nextLine();
		System.out.print("�н����� : ");
		String cuspassword = sc.nextLine();

		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getCusid().equals(cusid) && members.get(i).getCuspassword().equals(cuspassword)) {
				System.out.println("ȯ���մϴ�.");
				System.out.println("�α��ο� �����Ͽ����ϴ�. \n");
				break;
			} else if (!members.get(i).getCusid().equals(cusid)) {
				System.out.println("�������� �ʴ� ���̵��Դϴ�. \n");
				return;
			} else if (members.get(i).getCusid().equals(cusid) && !members.get(i).getCuspassword().equals(cuspassword)) {
				System.out.println("��ȣ�� �߸��Ǿ����ϴ�. \n");
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
			System.out.println("------- �޴� ���� -------");
			System.out.println("1. ȸ������");
			System.out.println("2. �� �� ��");
			System.out.println("9. ���α׷� ����");

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
				System.out.println("���α׷� ����");
				return;
			}

		}
	}
}