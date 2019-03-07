package kr.wabang.login;

import kr.wabang.util.DBConnection;

public class AdminDAO extends DBConnection {
	
	public void loginCheck(AdminVO vo){
		//���� �α��� üũ(���̵�/��й�ȣ)
		try{
			dbCon();
			String sql ="select adminId from admin where adminId=? and adminPwd=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getAdminId());
			pstmt.setString(2, vo.getAdminPwd());
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				vo.setAdminId(rs.getString(1));
				vo.setLoginStatus("Y");
			}
			
		}catch(Exception e){
			System.out.println("���� �α��� ����"+e.getMessage());
		}finally{
			dbClose();
		}
	}
}
