package collectionreview;

public class Account {
	String name;
	String field;
	int money;
	//���°�ü ������ name, field, money�� �־�� ��ü������ �� �ְ� �� ���̴�
	
	//�Է°��� �����鼭 Ŭ�����̸��� ������ �޼��� "�⺻������"
	//�⺻�����ڴ� �����ڸ� ���� �������� ������ �ڵ����� ���ǵȴ�.
	
	public Account () {
		System.out.println("��ü���� ȣ��Ǿ���.");
		System.out.println("������ ������� �ʱ�ȭ�Ѵ�");
	}
	
	public Account(String name, String field, int money) {
		super();
		this.name = name;
		this.field = field;
		this.money = money;
	}
	
	@Override
	public String toString() {
		return "���� [�̸�=" + name+ ", ��������=" + field + ", �ܾ�=" + money + "]";
	}
}
