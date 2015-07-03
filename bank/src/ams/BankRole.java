package ams;

// @Date : 2015. 6. 25
// @Story : 은행 관리자에 대한 기능 정의
public interface BankRole {

	public void openAccount( String accountNo, String ownerName, String password, int restMoney ); // 계좌 개설 기능

	public Account searchAccountByAccountNo( String accountNo );//계좌번호로 특정 계좌 조회, 검색 기능

	public Account[] searAccountsByAccountsByName( String ownerName );// 예금주로 그 사람이 가지고 있는 계좌 조회
	// 계좌는 여러개일 수 있으니까 배열로 설정

	public boolean closeAccount( String accountNo );// 계좌번호로 특정계좌 폐기( 삭제 ) 기능
}
