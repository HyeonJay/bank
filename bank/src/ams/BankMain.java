package ams;

import java.util.Scanner;

public class BankMain {
	public static void main( String[] args ) {
		Bank bank = new Bank(100);
		Scanner scanner = new Scanner(System.in);

		int accountNo = (int) ((Math.random() * 999999) + 111110);
		//6�ڸ� ������ ���� ���� �߻�
		// valueOf( )�� �ڹ� API�� �ִ� java.lang.String Ŭ������ �޼ҵ�� �������� ���ڿ��� �ٲ��ִ� ������ �Ѵ�.

		String strAccountNo = String.valueOf(accountNo);
		System.out.print("������ �̸� : ");
		String name = scanner.nextLine();

		System.out.print("��й�ȣ : ");
		String pass = scanner.nextLine();

		System.out.print("���ݾ� : ");
		int inputMoney = scanner.nextInt();

		bank.openAccount(strAccountNo, name, pass, inputMoney);

		bank.openAccount("123-963", "���̾��", "123", 5500);
		bank.openAccount("113-943", "��ũ", "123", 3300);
		bank.openAccount("123-363", "�����̴�", "123", 77);
		bank.openAccount("133-953", "��", "123", 210);

		//	searchByName(bank, scanner);

		//searchByNo(bank, scanner);

		System.out.println("=== ���� ���� ===");
		System.out.print("�����Ϸ��� ���¹�ȣ �Է� : ");
		String deleteAccount = scanner.next();
		Account account = bank.searchAccountByAccountNo(deleteAccount);
		if (account != null) {
			boolean isClose = bank.closeAccount(deleteAccount);
			if (isClose) {
				System.out.println("���� �Ϸ�");
			}
			else {
				System.out.println("������ �Ұ����մϴ�. �������� ���ǹٶ��ϴ�.");
			}
		}
		else {
			System.out.println("�����Ϸ��� ��ȸ�� ���°� �������� �ʽ��ϴ�.");
		}
		searchList(bank);
	}

	private static void searchList( Bank bank ) {
		System.out.println("===���¹�ȣ ��ü ��� ��� ===");
		BankBook[] list = bank.getBankBookList();
		if (list != null) {
			for (int i = 0; i < bank.getCount(); i++) {
				System.out.println(list[i].toString());

			}
		}
		else {
			System.out.println("���°� �ϳ��� �����ϴ�.");
		}
	}

	private static void searchByNo( Bank bank, Scanner scanner ) {
		System.out.println("===���¹�ȣ ��ȸ( ��ȣ �Է� ) ===");
		System.out.println("���¹�ȣ �Է� : ");
		String searchAccountNo = scanner.next();
		Account account = bank.searchAccountByAccountNo(searchAccountNo);

		if (account != null) {
			System.out.println(account.toString());
		}
		else {
			System.out.println("��ȸ����� �����ϴ�.");
		}
	}

	//�޼ҵ� �����丵 ���
	// ������ ���İ�Ƽ �ҽ��� ������ �ְ� �и���Ű�� �޼ҵ带 ������ �� �ֵ��� ���ȭ ��Ű�� �۾�
	// ALT + SHIFT + M
	private static void searchByName( Bank bank, Scanner scanner ) {
		System.out.println("===���¹�ȣ ��ȸ( �̸� �Է� ) ===");
		System.out.println("��ȸ�Ϸ��� �̸��� �Է� : ");
		String inputName = scanner.next();
		//BankBook[] list = bank.getBankBookList();
		BankBook[] bankBooks = (BankBook[]) bank.searAccountsByAccountsByName(inputName);

		if (bankBooks != null) {
			for (int i = 0; i < bank.getCount(); i++) {
				System.out.println(bankBooks[i].toString());
			}
		}
		else {
			System.out.println("��ȸ �̸� ����");
		}
	}
}
