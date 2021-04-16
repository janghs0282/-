package main;

import java.util.Scanner;

import cls.Deletecls;
import cls.InsertCls;
import cls.SelectCls;
import cls.UpdateCls;


public class MainClass {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		InsertCls ic = new InsertCls();
		Deletecls dc = new Deletecls();
		UpdateCls uc = new UpdateCls();
		SelectCls slc = new SelectCls();
			
		while(true) {
			
			System.out.println("1.추가하기");
			System.out.println("2.삭제하기");
			System.out.println("3.수정하기");
			System.out.println("4.날짜순으로 보기");
			System.out.println("5.모두 출력");
			System.out.print(">>");
			
			int num = sc.nextInt();
			
			switch(num) {
				case 1:
					ic.insert();
					break;
				case 2:
					dc.delete();
					break;							
				case 3:
					uc.Update();
					break;
				case 4:
					slc.orderdate();
					break;
				case 5:
					slc.allPrint();
					break;				
				
			}
		}
	}
}
