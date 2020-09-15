package classpackage;

public class Account {

	static public class FamilyAccount {
		String name;
		String accountName;
		int asset;

		public FamilyAccount(String name, String accountName, int asset) {
			this.name = name;
			this.accountName = accountName;
			this.asset = asset;
		}

		public void deposit() {
			System.out.println("입금하다");
		}

		public void withdraw() {
			System.out.println("출금하다");
		}
	}

	public static void main(String[] args) {
		FamilyAccount[] accounts = new FamilyAccount[3];
		accounts[0] = new FamilyAccount("홍길동", "튼튼적금", 1000);
		accounts[1] = new FamilyAccount("박길동", "튼튼얘금", 2000);
		accounts[2] = new FamilyAccount("홍기사", "다음작금", 3000);
		
		for(FamilyAccount e : accounts) {
			System.out.println(e.name + " " + e.accountName + " " + e.asset);
			e.deposit();
			e.withdraw();
		}
	}

}
