package kr.wabang.list;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.wabang.controller.CommandService;

public class CommandDeliveryOk implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//배송완료
		ListDAO dao = new ListDAO();
		OrderListVO vo = new OrderListVO();
		
		String i_code = req.getParameter("i_code");
		String o_num = req.getParameter("o_num");
		String m_id = req.getParameter("m_id");
		String deliveryOk = "배송완료";
		//값들어왔는지 확인
		System.out.println("값들어왔는지 확인-------");
		System.out.println("아이디="+m_id);
		System.out.println("결제상태="+o_num);
		System.out.println("i_code="+i_code);
		
		int cnt = dao.updateDelivery(deliveryOk,i_code, o_num, m_id);
		req.setAttribute("cnt", cnt);
		
		return "deliveryOk.jsp";
	}

}
