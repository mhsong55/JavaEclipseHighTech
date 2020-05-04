package chapter13;

public class Account {
	private String accountNumber = "";
	private int balance = 0;
	
	public Account(String accountNumber, int balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toString(balance)).append("원 (계좌번호=");
		sb.append(accountNumber).append(")");
		return sb.toString();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Account) {
			Account account = (Account) obj;
			if (this.accountNumber.equals(account.getAccountNumber().trim())) {
				return true;
			}
		}
		return false;
	}
}
