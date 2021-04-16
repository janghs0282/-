package cls;


import java.util.List;
import java.util.Scanner;
import dao.EmpDao;
import dto.Dto;



public class SelectCls {
	
	
	
	public void  nameSelect() {	// 이름으로 검색
		Scanner sc = new Scanner(System.in);
		EmpDao ad = EmpDao.getInstance();
		System.out.print("찾으실 이름을 입력해주세요 : ");
		String ename = sc.next();
		Dto dto = ad.nameSelect(ename);
		if(dto != null) {
			System.out.println(dto.toString());
		}else {
			System.out.println("찾으시는 이름의 데이터가 없습니다");
		}
	}
	
public void allPrint() {	// 전체 출력
		
		EmpDao ad = EmpDao.getInstance();
		List<Dto> list = ad.getList();
		for (int i = 0; i < list.size(); i++) {
			Dto d = list.get(i);
			System.out.println(d.toString());			
		}	
	}
	


public void orderdate() {	// 날짜순
	EmpDao ad = EmpDao.getInstance();
	List<Dto> list = ad.day();
	for (int i = 0; i < list.size(); i++) {
		Dto d = list.get(i);
		System.out.println(d.toString());
		
	}
}
}

