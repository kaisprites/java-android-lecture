package dbconnect;

public class MemberVO {
	//private 제한자 멤버는 클래스의 멤버 메서드만 접근할 수 있다
	private String id;
	private String pw;
	private String name;
	private String tel;
	
	// source > generate getters and setters로 자동생성
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
