package kr.wabang.item;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandItemDelete implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 상품 삭제
		String code = req.getParameter("code");
		ItemDAO dao = new ItemDAO();
		String path = req.getServletContext().getRealPath("/item/itemImg");
		
		int cnt = dao.deleteItem(code,path);
		req.setAttribute("cnt", cnt);
		req.setAttribute("code", code);
		return "itemDelete.jsp";
	}

}
