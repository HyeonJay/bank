package ams;

import java.util.Scanner;

public class BankMain {
	public static void main( String[] args ) {
		Bank bank = new Bank(100);
		Scanner scanner = new Scanner(System.in);

		int accountNo = (int) ((Math.random() * 999999) + 111110);
		//6자리 정수형 랜덤 숫자 발생
		// valueOf( )는 자바 API에 있는 java.lang.String 클래스의 메소드로 숫자형을 문자열로 바꿔주는 역할을 한다.

		String strAccountNo = String.valueOf(accountNo);
		System.out.print("예금주 이름 : ");
		String name = scanner.nextLine();

		System.out.print("비밀번호 : ");
		String pass = scanner.nextLine();

		System.out.print("예금액 : ");
		int inputMoney = scanner.nextInt();

		bank.openAccount(strAccountNo, name, pass, inputMoney);

		bank.openAccount("123-963", "아이언맨", "123", 5500);
		bank.openAccount("113-943", "헐크", "123", 3300);
		bank.openAccount("123-363", "스파이더", "123", 77);
		bank.openAccount("133-953", "톰", "123", 210);

		//	searchByName(bank, scanner);

		//searchByNo(bank, scanner);

		System.out.println("=== 계좌 삭제 ===");
		System.out.print("삭제하려는 계좌번호 입력 : ");
		String deleteAccount = scanner.next();
		Account account = bank.searchAccountByAccountNo(deleteAccount);
		if (account != null) {
			boolean isClose = bank.closeAccount(deleteAccount);
			if (isClose) {
				System.out.println("삭제 완료");
			}
			else {
				System.out.println("삭제가 불가능합니다. 전산팀에 문의바랍니다.");
			}
		}
		else {
			System.out.println("삭제하려고 조회한 계좌가 존재하지 않습니다.");
		}
		searchList(bank);
	}

	private static void searchList( Bank bank ) {
		System.out.println("===계좌번호 전체 목록 출력 ===");
		BankBook[] list = bank.getBankBookList();
		if (list != null) {
			for (int i = 0; i < bank.getCount(); i++) {
				System.out.println(list[i].toString());

			}
		}
		else {
			System.out.println("계좌가 하나도 없습니다.");
		}
	}

	private static void searchByNo( Bank bank, Scanner scanner ) {
		System.out.println("===계좌번호 조회( 번호 입력 ) ===");
		System.out.println("계좌번호 입력 : ");
		String searchAccountNo = scanner.next();
		Account account = bank.searchAccountByAccountNo(searchAccountNo);

		if (account != null) {
			System.out.println(account.toString());
		}
		else {
			System.out.println("조회결과가 없습니다.");
		}
	}

	//메소드 리팩토링 기법
	// 복잡한 스파게티 소스를 가독성 있게 분리시키고 메소드를 재사용할 수 있도록 모듈화 시키는 작업
	// ALT + SHIFT + M
	private static void searchByName( Bank bank, Scanner scanner ) {
		System.out.println("===계좌번호 조회( 이름 입력 ) ===");
		System.out.println("조회하려는 이름을 입력 : ");
		String inputName = scanner.next();
		//BankBook[] list = bank.getBankBookList();
		BankBook[] bankBooks = (BankBook[]) bank.searAccountsByAccountsByName(inputName);

		if (bankBooks != null) {
			for (int i = 0; i < bank.getCount(); i++) {
				System.out.println(bankBooks[i].toString());
			}
		}
		else {
			System.out.println("조회 이름 없음");
		}
	}
}
