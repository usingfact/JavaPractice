package carApp;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerDAO {
	private ArrayList<CustomerDTO> CustomerList;
	public CustomerDAO() {
		CustomerList= new ArrayList<CustomerDTO>();
				
		CustomerList.add(new CustomerDTO("customer1","as1234","김철수","대구 서구 내당동"));
		CustomerList.add(new CustomerDTO("customer2","zx1234","이영희","대구 동구 신천4동"));
		CustomerList.add(new CustomerDTO("customer3","qw1234","최영수","대구 동구 안심1동"));
		CustomerList.add(new CustomerDTO("customer4","er1234","김희재","대구 중구 대봉1동"));
		CustomerList.add(new CustomerDTO("customer5","df1234","서지희","대구 수성구 범어1동"));
		CustomerList.add(new CustomerDTO("manager","admin1234","서진수","대구 수성구 범어1동"));
		}
		
		//고객 정보 모두 보기
		public void showAll() {
			for(int i=0;i<CustomerList.size();i++) {
				CustomerList.get(i).Introduce();
			}
		}
		
		//고객 정보 이름으로 찾기
		public void showByName(String cusname) {
			Scanner sc=new Scanner(System.in);
			System.out.print("찾을 고객의 이름을 입력하세요:");
			cusname=sc.next();
			sc.nextLine();
			for(int i=0;i<CustomerList.size();i++) {
				if((CustomerList.get(i).getCusname().equals(cusname)==true)) {
					CustomerList.get(i).Introduce();
				}
			}
			sc.close();
		}
		
		//고객 정보 추가
		public void insertCustomerInfo(String cusid,String cuspassword,
				String cusname,String cusaddress) {
			Scanner sc=new Scanner(System.in);
			System.out.print("가입시 이용할 아이디를 입력하세요:");
			cusid=sc.next();
			sc.nextLine();
			System.out.print("가입시 이용할 비밀번호를 입력하세요:");
			cuspassword=sc.next();
			sc.nextLine();
			System.out.print("고객님의 이름을 입력해주세요:");
			cusname=sc.next();
			sc.nextLine();
			System.out.print("고객님의 주소를 입력해주세요:");
			cusaddress=sc.next();
			sc.nextLine();
			CustomerList.add(new CustomerDTO(cusname,cuspassword,cusname,cusaddress));
			sc.close();
		}
	
		
		
			
			
			
			
		
		
		
	}
	


