package kr.wabang.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.wabang.controller.CommandService;

public class CommandLoginOk implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//���� �α���
		AdminVO vo = new AdminVO();
		vo.setAdminId(req.getParameter("adminid"));
		System.out.println(req.getParameter("adminid"));
		vo.setAdminPwd(req.getParameter("adminpwd"));
		System.out.println(req.getParameter("adminpwd"));
		
		AdminDAO dao = new AdminDAO();
		dao.loginCheck(vo);
		
		req.setAttribute("vo", vo);
		
		//�α��� ������ ���ǿ� �ʿ��� ������ ���
		if(vo.getLoginStatus().equals("Y")){
			HttpSession session = req.getSession();
			session.setAttribute("adminid", vo.getAdminId());
			System.out.println(vo.getAdminId());
			session.setAttribute("loginStatus", vo.getLoginStatus());
			System.out.println(vo.getLoginStatus());
		}
		return "loginOk.jsp";
	}

}
