package collectionreview;

import java.util.ArrayList;

public class Bank {

	public static void main(String[] args) {
		Account account1 = new Account("ȫ�浿", "��������", 1000);
		Account account2 = new Account("�����", "����", 2000);
		Account account3 = new Account("Ȳȭ��", "��ī������", 3000);
		Account account4 = new Account("������", "�ݴ�����", 4000);
		Account account5 = new Account("�����", "���������� �����", 5000);
		
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
