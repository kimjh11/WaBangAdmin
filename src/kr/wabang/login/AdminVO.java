package kr.wabang.login;

public class AdminVO {
	private String adminId;
	private String adminPwd;
	
	//�α��� ����(Y:�α��� ����, N:�α��� ����)
	private String loginStatus = "N";
	
	//
	public AdminVO(){
		
	}
	
	//
	public AdminVO(String adminId, String adminPwd){
		this.adminId = adminId;
		this.adminPwd = adminPwd;
	}

	//getter/setter
	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
}
