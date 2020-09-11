package collectionreview;

import java.util.ArrayList;

public class Bank {

	public static void main(String[] args) {
		Account account1 = new Account("홍길동", "정기적금", 1000);
		Account account2 = new Account("김박진", "예금", 2000);
		Account account3 = new Account("황화진", "방카슈랑스", 3000);
		Account account4 = new Account("현수아", "펀더멘털", 4000);
		Account account5 = new Account("선우완", "서브프라임 모기지", 5000);
		
		ArrayList<Account> list = new ArrayList<Account>();
		list.add(account1);
		list.add(account2);
		list.add(account3);
		list.add(account4);
		list.add(account5);
		
		SaveAccounts s = new SaveAccounts();
		s.save(list);
	}

}
