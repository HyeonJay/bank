package ams;

import java.util.Scanner;

// 컨트롤러 패턴( 공항의 관제탑 )
public class ProcessMain {
	public static void main( String[] args ) {
		Bank bank = new Bank(1000);
		Scanner scanner = new Scanner(System.in);

		int input = 0, key = 0;

		while (true) { // 무한 루프
			try {
				System.out.println("1. 계좌개설 2. 계좌조회(번호) 3. 계좌조회(이름) 4. 전체조회 5. 계좌삭제");
				input = scanner.nextInt();
				key = inputCheck(input, 1, 5);
			}
			catch (Exception e) {
				e.printStackTrace(); // 에러를 쫓아가는 기능
				System.out.println("숫자만 입력 가능합니다.");
				System.out.println("ProcessMain의 try.catch 에러 발생");
			}
			switch (key) {
				case 1:
					int accountNo = (int) ((Math.random() * 999999) + 111110);
					//6자리 정수형 랜덤 숫자 발생
					// valueOf( )는 자바 API에 있는 java.lang.String 클래스의 메소드로 숫자형을 문자열로 바꿔주는 역할을 한다.

					String strAccountNo = String.valueOf(accountNo);
					System.out.print("예금주 이름 : ");
					String name = scanner.next();

					System.out.print("비밀번호 : ");
					String pass = scanner.next();

					System.out.print("예금액 : ");
					int inputMoney = scanner.nextInt();

					bank.openAccount(strAccountNo, name, pass, inputMoney);
					break;

				case 2:
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
					break;
				case 3:
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

					break;
				case 4:
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

					break;

				case 5:
					System.out.println("=== 계좌 삭제 ===");
					System.out.print("삭제하려는 계좌번호 입력 : ");
					String deleteAccount = scanner.next();
					Account account2 = bank.searchAccountByAccountNo(deleteAccount);
					if (account2 != null) {
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
					break;
				default:
					break;
			}
		}
	}

	private static int inputCheck( int input, int first, int last ) {
		int key = input;
		if (key < first || key > last) {
			System.out.println("초기 메뉴의 선택 범위를 넘어섰습니다.");
			return 0;
		}
		else {
			return key;
		}
	}
}
