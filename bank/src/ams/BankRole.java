package ams;

// @Date : 2015. 6. 25
// @Story : ���� �����ڿ� ���� ��� ����
public interface BankRole {

	public void openAccount( String accountNo, String ownerName, String password, int restMoney ); // ���� ���� ���

	public Account searchAccountByAccountNo( String accountNo );//���¹�ȣ�� Ư�� ���� ��ȸ, �˻� ���

	public Account[] searAccountsByAccountsByName( String ownerName );// �����ַ� �� ����� ������ �ִ� ���� ��ȸ
	// ���´� �������� �� �����ϱ� �迭�� ����

	public boolean closeAccount( String accountNo );// ���¹�ȣ�� Ư������ ���( ���� ) ���
}
