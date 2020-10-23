package cn.malong.domin;
//模型类
public class User {
		
	private int id;
	private String userId;
	private String userName;
	private String userpassword;
	private String sex;
	private String userData;
	private String userphone;
	private String userAddress;
	private String userlei;
	public int getId() {
		return id;
	}
	public User(int id, String userId, String userName, String userpassword, String sex, String userData,
			String userphone, String userAddress, String userlei) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.userpassword = userpassword;
		this.sex = sex;
		this.userData = userData;
		this.userphone = userphone;
		this.userAddress = userAddress;
		this.userlei = userlei;
	}
	
	public User(String userId, String userName, String userpassword, String sex, String userData, String userphone,
			String userAddress, String userlei) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userpassword = userpassword;
		this.sex = sex;
		this.userData = userData;
		this.userphone = userphone;
		this.userAddress = userAddress;
		this.userlei = userlei;
	}
	public User() {
		super();
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getUserData() {
		return userData;
	}
	public void setUserData(String userData) {
		this.userData = userData;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserlei() {
		return userlei;
	}
	public void setUserlei(String userlei) {
		this.userlei = userlei;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", userName=" + userName + ", userpassword=" + userpassword
				+ ", sex=" + sex + ", userData=" + userData + ", userphone=" + userphone + ", userAddress="
				+ userAddress + ", userlei=" + userlei + "]";
	}
	public User(int id, String userName, String sex, String userData, String userphone, String userAddress) {
		super();
		this.id = id;
		this.userName = userName;
		this.sex = sex;
		this.userData = userData;
		this.userphone = userphone;
		this.userAddress = userAddress;
	}
	
	
	

}
