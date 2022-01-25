package carApp;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberDAO {
	ArrayList<MemberDTO> members=new ArrayList<>();
	public void MemberDTO() {//ȸ������ ����
		members.add(new MemberDTO("customer1","as1234","��ö��","�뱸 ���� ���絿"));
		members.add(new MemberDTO("customer2","zx1234","�̿���","�뱸 ���� ��õ4��"));
		members.add(new MemberDTO("customer3","qw1234","�ֿ���","�뱸 ���� �Ƚ�1��"));
		members.add(new MemberDTO("customer4","er1234","������","�뱸 �߱� ���1��"));
		members.add(new MemberDTO("customer5","df1234","������","�뱸 ������ ����1��"));
		members.add(new MemberDTO("manager","admin1234","������","�뱸 ������ ����1��"));
		}
					
	public void insertCustomerInfo() {//ȸ������
		Scanner sc=new Scanner(System.in);
		String cusid;
		String cuspassword;
		String cusname;
		String cusaddress;
		System.out.print("���Խ� �̿��� ���̵� �Է��ϼ���:");
		cusid=sc.nextLine();
		while(true) {
		if(ifOverlapId(cusid)==false) {
			System.out.println("�̹� ������� ���̵��Դϴ�!");
			continue;
		}
		break;
		}
		System.out.print("���Խ� �̿��� ��й�ȣ�� �Է��ϼ���:");
		cuspassword=sc.nextLine();		
		System.out.print("������ �̸��� �Է����ּ���:");
		cusname=sc.nextLine();		
		System.out.print("������ �ּҸ� �Է����ּ���:");
		cusaddress=sc.nextLine();		
		System.out.println(cusname+"�� ȸ�������� ȯ���մϴ�!");
		members.add(new MemberDTO(cusid,cuspassword,cusname,cusaddress));
	}
	
	public void Login() {//�α��� 
		Scanner sc=new Scanner(System.in);
		System.out.print("���̵� �Է��ϼ���:");
		String id=sc.nextLine();
		System.out.print("��й�ȣ�� �Է��ϼ���:");
		String pass=sc.nextLine();
		for(int j=0;j<members.size();j++) {
			if(getMemberIndexid(id)==-1) {
				System.out.println("���̵� �߸� �Է��ϼ̽��ϴ�!");
				break;
				
			}
			else if(getMemberIndexid(id)!=-1&&getMemberIndexps(pass)==-1) {
				System.out.println("��й�ȣ�� �߸� �Է��ϼ̽��ϴ�!");
				break;
			}
			else if(getMemberIndexid(id)==getMemberIndexps(pass)&&getMemberIndexid(id)!=-1) {
				System.out.println("�α��� ����!");
				
			}
				
			
		}
    }
	   //ȸ����������
    public void updateCustomerInfo(){
    	Scanner sc=new Scanner(System.in);
    	System.out.println("������ ������ ȸ�� ���̵� �Է��ϼ���");
    	String id=sc.nextLine();
    	if(getMemberIndexid(id)!=-1) {
    	for(int j=0;j<members.size();j++) {
    		if(members.get(j).getCusid().equals(id)) {    			
    			System.out.print("������ ��й�ȣ�� �Է��ϼ���");
    			String cpassword=sc.nextLine();
    			System.out.print("������ �̸��� �Է��ϼ���");
    			String cname=sc.nextLine();
    			System.out.print("������ �ּҸ� �Է��ϼ���");
    			String caddress=sc.nextLine();
    			members.set(j, new MemberDTO(id,cpassword,cname,caddress));    			
    		}
    	}
    	}
    	else {
    		System.out.println("���̵� �߸� �Է��ϼ̽��ϴ�!");
    	}
    }
  //���� ����
    public void deleteCustomerInfo() {
    	Scanner sc=new Scanner(System.in);
    	System.out.print("������ ������ ȸ�� ���̵� �Է��ϼ���:");
    	String id=sc.nextLine();
    	if(getMemberIndexid(id)!=-1) {
    		System.out.print("������ ������ ȸ�� ��й�ȣ�� �Է��ϼ���:");
    		String password=sc.nextLine();
    		if(getMemberIndexid(id)==getMemberIndexps(password)) {
    			System.out.println(members.get(getMemberIndexid(id)).getCusname()+"���� ������ �����Ǿ����ϴ�!");
    			members.remove(getMemberIndexid(id));
    		}
    	}
    	
    }
    
    public int getMemberIndexid(String id) {//arraylist���°�� id���ִ��� ���
    	int i=0;
    	for(MemberDTO memberDTO: members) {
    		if(memberDTO.getCusid().equals(id)==true) {
    			return i;
    		}
    		i++;
    	}
    	return -1;
    }
    
    public int getMemberIndexps(String password) {//arraylist ����翡 password�� �ִ��� ���
    	int i=0;
    	for(MemberDTO memberDTO:members) {
    		if(memberDTO.getCuspassword().equals(password)==true) {
    			return i;
    		}
    		i++;
    	}
    	return -1;    	
    }
    
    public boolean ifOverlapId(String id) {//���̵� �ߺ� Ȯ��
    	int index=getMemberIndexid(id);
    	if(index==-1) {
    		return true;
    	}
    	return false;    	
    }
    
    
    		

}
