package carApp;

import java.util.Scanner;

public class LoginMenuTest {
		
	//�� ���� �߰�
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		MemberDAO mem=new MemberDAO();
		mem.MemberDTO();
		while (true) {			
			System.out.println("------- �޴� ���� -------");
			System.out.println("1. �α���");
			System.out.println("2. ȸ������");
			System.out.println("3. ȸ����������");
			System.out.println("4. ȸ��Ż��");
			System.out.println("5. ���α׷� ����");
			int choice=sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1://�α���
				mem.Login();
				break;
			case 2://ȸ������
				mem.insertCustomerInfo();
				break;
			case 3://ȸ������ ����
				mem.updateCustomerInfo();
				break;
			case 4://ȸ������ ����
				mem.deleteCustomerInfo();
				break;
			case 5:
				System.out.println("���α׷� ����");
				sc.close();
				System.exit(0);
			}

		}
		
	}

}
