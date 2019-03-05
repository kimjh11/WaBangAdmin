package kr.wabang.list;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandMemberLi implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//회원목록
		ListDAO dao = new ListDAO();
		List<MemberListVO> list = dao.getAllMember();
		
		req.setAttribute("list", list);
		
		return "memberList.jsp";
	}

}
