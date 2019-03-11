package kr.wabang.answer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.wabang.controller.CommandService;

public class CommandAnswerDelete implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 답변 삭제하기
		AnswerVO vo = new AnswerVO();
		vo.setQ_num(Integer.parseInt(req.getParameter("q_num")));
		
		HttpSession session = req.getSession();
		vo.setAdminId((String)session.getAttribute("adminid"));
		
		AnswerDAO dao = new AnswerDAO();
		int cnt = dao.deleteAnswer(vo);
		
		req.setAttribute("cnt", cnt);
		req.setAttribute("vo", vo);
		
		return "answerDelete.jsp";
	}

}
