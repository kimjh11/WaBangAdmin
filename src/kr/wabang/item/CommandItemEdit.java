package kr.wabang.item;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandItemEdit implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ItemVO vo = new ItemVO();
		vo.setCode(req.getParameter("code"));
		
		ItemDAO dao = new ItemDAO();
		dao.selectItem(vo);
		
		req.setAttribute("vo", vo);
		return "itemEdit.jsp";
	}

}
