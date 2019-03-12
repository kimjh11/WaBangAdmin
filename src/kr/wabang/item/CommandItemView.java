package kr.wabang.item;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandItemView implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//코드번호로 상품 선택하기
		ItemVO vo = new ItemVO();
		vo.setCode(req.getParameter("code"));
		
		ItemDAO dao = new ItemDAO();
		dao.selectItem(vo);
		
		req.setAttribute("vo", vo);
		
		return "itemView.jsp";
	}

}
