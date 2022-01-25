package carApp;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerDAO {
	private ArrayList<CustomerDTO> CustomerList;
	public CustomerDAO() {
		CustomerList= new ArrayList<CustomerDTO>();
				
		CustomerList.add(new CustomerDTO("customer1","as1234","��ö��","�뱸 ���� ���絿"));
		CustomerList.add(new CustomerDTO("customer2","zx1234","�̿���","�뱸 ���� ��õ4��"));
		CustomerList.add(new CustomerDTO("customer3","qw1234","�ֿ���","�뱸 ���� �Ƚ�1��"));
		CustomerList.add(new CustomerDTO("customer4","er1234","������","�뱸 �߱� ���1��"));
		CustomerList.add(new CustomerDTO("customer5","df1234","������","�뱸 ������ ����1��"));
		CustomerList.add(new CustomerDTO("manager","admin1234","������","�뱸 ������ ����1��"));
		}
		
		//�� ���� ��� ����
		public void showAll() {
			for(int i=0;i<CustomerList.size();i++) {
				CustomerList.get(i).Introduce();
			}
		}
		
		//�� ���� �̸����� ã��
		public void showByName(String cusname) {
			Scanner sc=new Scanner(System.in);
			System.out.print("ã�� ���� �̸��� �Է��ϼ���:");
			cusname=sc.next();
			sc.nextLine();
			for(int i=0;i<CustomerList.size();i++) {
				if((CustomerList.get(i).getCusname().equals(cusname)==true)) {
					CustomerList.get(i).Introduce();
				}
			}
			sc.close();
		}
		
		//�� ���� �߰�
		public void insertCustomerInfo(String cusid,String cuspassword,
				String cusname,String cusaddress) {
			Scanner sc=new Scanner(System.in);
			System.out.print("���Խ� �̿��� ���̵� �Է��ϼ���:");
			cusid=sc.next();
			sc.nextLine();
			System.out.print("���Խ� �̿��� ��й�ȣ�� �Է��ϼ���:");
			cuspassword=sc.next();
			sc.nextLine();
			System.out.print("������ �̸��� �Է����ּ���:");
			cusname=sc.next();
			sc.nextLine();
			System.out.print("������ �ּҸ� �Է����ּ���:");
			cusaddress=sc.next();
			sc.nextLine();
			CustomerList.add(new CustomerDTO(cusname,cuspassword,cusname,cusaddress));
			sc.close();
		}
	
		
		
			
			
			
			
		
		
		
	}
	


