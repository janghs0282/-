package cls;


import java.util.Scanner;
import dao.EmpDao;


public class UpdateCls {
	
	public void Update() {

	EmpDao ad = EmpDao.getInstance();
	
	Scanner sc = new Scanner(System.in);
	System.out.println("수정하실 사원의 이름과 수정할 부서명을 입력하세요");
	System.out.print("수정 할 사원의 이름 : ");
	String ename = sc.next();
	
	System.out.print("수정 할 부서명: ");
	String depname = sc.next();;
	
	int count = ad.update(ename, depname);
	if(count == 1) {
		System.out.println("수정이 완료 됐습니다.");
	}else{
		System.out.println("수정에 실패했습니다");
	}
	}
}
