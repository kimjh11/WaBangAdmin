package kr.wabang.item;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandItemList implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//상품목록 뽑아내는 곳
		ItemVO vo = new ItemVO();
		ItemDAO dao = new ItemDAO();
		List<ItemVO> list= dao.itemList();
		
		req.setAttribute("list", list);
		req.setAttribute("vo", vo);
		return "itemList.jsp"; 
	}

}
