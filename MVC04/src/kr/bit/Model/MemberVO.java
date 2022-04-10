package kr.bit.Model;

public class MemberVO {
	private int num;
	private String id;
	private String pass;
	private String name;
	private int age;
	private String email;
	private String phone;
	public int getNum() {
		return num;
	}
	
	public MemberVO() {}
	
	// num은 자동증분이므로 회원가입할때 사용하기 위해서 뺀다.
	public MemberVO(String id, String pass, String name, int age, String email, String phone) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
	}
	// 데이터베이스에서 데이터를 가지고 와서 VO로 묶을 때에는 자동증분값까지 필요해서 넣어준다.
	public MemberVO(int num, String id, String pass, String name, int age, String email, String phone) {
		super();
		this.num = num;
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "MemberVO [num=" + num + ", id=" + id + ", pass=" + pass + ", name=" + name + ", age=" + age + ", email="
				+ email + ", phone=" + phone + "]";
	}
}