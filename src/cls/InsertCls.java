package cls;


import java.util.Scanner;

import dao.EmpDao;


public class InsertCls {

	Scanner sc = new Scanner(System.in);
	
	public void insert() {
	
	System.out.print("사원명:");
	String ename = sc.next();
	
	System.out.print("부서번호 :");
	int eno = sc.nextInt();
	
	System.out.print("부서명 : ");
	String depname = sc.next();
	
	System.out.print("입사일 : ");
	String hiredate = sc.next();
		
	EmpDao ad = EmpDao.getInstance();
	int count = ad.Insert(ename, eno, depname, hiredate);
	if (count == 1) {
		System.out.println("데이터가 추가되었습니다");
	}else {
		System.out.println("데이터 추가에 실패했습니다");
	}
}
}


