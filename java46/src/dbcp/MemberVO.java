package dbcp;

public class MemberVO {
	//private ������ ����� Ŭ������ ��� �޼��常 ������ �� �ִ�
	private String id;
	private String pw;
	private String name;
	private String tel;
	
	// source > generate getters and setters�� �ڵ�����
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setter(String id, String pw, String name, String tel) {
		setId(id);
		setPw(pw);
		setName(name);
		setTel(tel);
	};
}
