package team.adyn.bean;

public class Users {

	private Integer uid;
	private String uname;
	private String password1;
	private String password2;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public Users(String uname, String password1) {
		super();
		this.uname = uname;
		this.password1 = password1;
	}

	public Users(String uname, String password1, String password2) {
		super();
		this.uname = uname;
		this.password1 = password1;
		this.password2 = password2;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

}
