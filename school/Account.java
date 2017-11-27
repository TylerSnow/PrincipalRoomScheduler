package school;

public class Account {
	private String user;
	private String password;
	
	public Account(String nUser, String nPass) {
		user = nUser;
		password = nPass;
	}
	
	public String getUser() {
		return user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String newPass) {
		password = newPass;
	}
	
	public void setUser(String newUser) {
		user = newUser;
	}
	
	public boolean matches(Account a) {
		return (a.getUser().equals(user) && a.getPassword().equals(password));
	}
}
