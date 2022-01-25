package carApp;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberDAO {
	ArrayList<MemberDTO> members=new ArrayList<>();
	public void MemberDTO() {//회원정보 삽입
		members.add(new MemberDTO("customer1","as1234","김철수","대구 서구 내당동"));
		members.add(new MemberDTO("customer2","zx1234","이영희","대구 동구 신천4동"));
		members.add(new MemberDTO("customer3","qw1234","최영수","대구 동구 안심1동"));
		members.add(new MemberDTO("customer4","er1234","김희재","대구 중구 대봉1동"));
		members.add(new MemberDTO("customer5","df1234","서지희","대구 수성구 범어1동"));
		members.add(new MemberDTO("manager","admin1234","서진수","대구 수성구 범어1동"));
		}
					
	public void insertCustomerInfo() {//회원가입
		Scanner sc=new Scanner(System.in);
		String cusid;
		String cuspassword;
		String cusname;
		String cusaddress;
		System.out.print("가입시 이용할 아이디를 입력하세요:");
		cusid=sc.nextLine();
		while(true) {
		if(ifOverlapId(cusid)==false) {
			System.out.println("이미 사용중인 아이디입니다!");
			continue;
		}
		break;
		}
		System.out.print("가입시 이용할 비밀번호를 입력하세요:");
		cuspassword=sc.nextLine();		
		System.out.print("고객님의 이름을 입력해주세요:");
		cusname=sc.nextLine();		
		System.out.print("고객님의 주소를 입력해주세요:");
		cusaddress=sc.nextLine();		
		System.out.println(cusname+"님 회원가입을 환영합니다!");
		members.add(new MemberDTO(cusid,cuspassword,cusname,cusaddress));
	}
	
	public void Login() {//로그인 
		Scanner sc=new Scanner(System.in);
		System.out.print("아이디를 입력하세요:");
		String id=sc.nextLine();
		System.out.print("비밀번호를 입력하세요:");
		String pass=sc.nextLine();
		for(int j=0;j<members.size();j++) {
			if(getMemberIndexid(id)==-1) {
				System.out.println("아이디를 잘못 입력하셨습니다!");
				break;
				
			}
			else if(getMemberIndexid(id)!=-1&&getMemberIndexps(pass)==-1) {
				System.out.println("비밀번호를 잘못 입력하셨습니다!");
				break;
			}
			else if(getMemberIndexid(id)==getMemberIndexps(pass)&&getMemberIndexid(id)!=-1) {
				System.out.println("로그인 성공!");
				
			}
				
			
		}
    }
	   //회원정보수정
    public void updateCustomerInfo(){
    	Scanner sc=new Scanner(System.in);
    	System.out.println("정보를 수정할 회원 아이디를 입력하세요");
    	String id=sc.nextLine();
    	if(getMemberIndexid(id)!=-1) {
    	for(int j=0;j<members.size();j++) {
    		if(members.get(j).getCusid().equals(id)) {    			
    			System.out.print("변경할 비밀번호를 입력하세요");
    			String cpassword=sc.nextLine();
    			System.out.print("변경할 이름을 입력하세요");
    			String cname=sc.nextLine();
    			System.out.print("변경할 주소를 입력하세요");
    			String caddress=sc.nextLine();
    			members.set(j, new MemberDTO(id,cpassword,cname,caddress));    			
    		}
    	}
    	}
    	else {
    		System.out.println("아이디를 잘못 입력하셨습니다!");
    	}
    }
  //정보 삭제
    public void deleteCustomerInfo() {
    	Scanner sc=new Scanner(System.in);
    	System.out.print("정보를 삭제할 회원 아이디를 입력하세요:");
    	String id=sc.nextLine();
    	if(getMemberIndexid(id)!=-1) {
    		System.out.print("정보를 삭제할 회원 비밀번호를 입력하세요:");
    		String password=sc.nextLine();
    		if(getMemberIndexid(id)==getMemberIndexps(password)) {
    			System.out.println(members.get(getMemberIndexid(id)).getCusname()+"님의 정보가 삭제되었습니다!");
    			members.remove(getMemberIndexid(id));
    		}
    	}
    	
    }
    
    public int getMemberIndexid(String id) {//arraylist몇번째에 id가있는지 출력
    	int i=0;
    	for(MemberDTO memberDTO: members) {
    		if(memberDTO.getCusid().equals(id)==true) {
    			return i;
    		}
    		i++;
    	}
    	return -1;
    }
    
    public int getMemberIndexps(String password) {//arraylist 몇번재에 password가 있는지 출력
    	int i=0;
    	for(MemberDTO memberDTO:members) {
    		if(memberDTO.getCuspassword().equals(password)==true) {
    			return i;
    		}
    		i++;
    	}
    	return -1;    	
    }
    
    public boolean ifOverlapId(String id) {//아이디 중복 확인
    	int index=getMemberIndexid(id);
    	if(index==-1) {
    		return true;
    	}
    	return false;    	
    }
    
    
    		

}
