package kr.wabang.list;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandDepositLi implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//결제목록
		ListDAO dao = new ListDAO();
		List<OrderListVO> list = dao.getAllPayment();
		OrderListVO vo = new OrderListVO();
		//검색어
		vo.setSearchWord(req.getParameter("searchWord"));
						
						
		req.setAttribute("vo", vo);			
		req.setAttribute("list", list);
				
		return "depositList.jsp";
	}

}
