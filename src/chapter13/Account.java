package chapter13;

import java.util.Comparator;

public class Account implements Comparable<Account>, Comparator<Account>{
	private String accountNumber = "";
	private int balance = 0;
	
	@Override
	public int compare(Account obj1, Account obj2) {
		if (obj1.balance < obj2.balance) {
			return -1;	// this가 더 작은 경우
		}
		if (obj1.balance > obj2.balance) {
			return 1;	// this가 더 큰 경우
		}
		return 0;	// 같은 경우
	}
	@Override
	public int compareTo(Account obj) {
		if (this.balance < obj.balance) {
			return -1;	// this가 더 작은 경우
		}
		if (this.balance > obj.balance) {
			return 1;	// this가 더 큰 경우
		}
		return 0;	// 같은 경우
	}	
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
