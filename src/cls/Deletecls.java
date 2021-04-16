package cls;


import java.util.Scanner;

import dao.EmpDao;

public class Deletecls {
	
	public int delete() {
	Scanner sc = new Scanner(System.in);
	EmpDao ad = EmpDao.getInstance();
	System.out.println("삭제할 사원의 이름을 입력하세요");
	String ename = sc.next();
	
	int count = ad.delete(ename);
	if(count == 1) {
		System.out.println("성공적으로 삭제하였습니다");
	}else {
		System.out.println("삭제에 실패했습니다");
		}
	return count;
	}
}
	


