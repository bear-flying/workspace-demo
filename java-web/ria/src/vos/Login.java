package vos;

public class Login {

	private int id;
	private int rank;
	private String user;
	private String pass;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return "Login [user=" + user + ", pass=" + pass + "]";
	}
	public Login(String user) {
		super();
		this.user = user;
	}
	public Login(String user, String pass) {
		super();
		this.user = user;
		this.pass = pass;
	}
	public Login(int rank, String user, String pass) {
		super();
		this.rank = rank;
		this.user = user;
		this.pass = pass;
	}
	public Login(String user, String pass,int id, int rank ) {
		super();
		this.id = id;
		this.rank = rank;
		this.user = user;
		this.pass = pass;
	}
	
	
}
