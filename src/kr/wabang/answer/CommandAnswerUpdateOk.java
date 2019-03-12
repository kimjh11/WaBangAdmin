package kr.wabang.answer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandAnswerUpdateOk implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 답변 수정하기
		req.setCharacterEncoding("UTF-8");
		
		AnswerVO vo = new AnswerVO();
		vo.setQ_num(Integer.parseInt(req.getParameter("q_num")));
		
		vo.setA_comment(req.getParameter("comment"));
		vo.setM_id(req.getParameter("m_id"));
		vo.setAdminId(req.getParameter("adminid"));
		
		AnswerDAO dao = new AnswerDAO();
		int cnt = dao.updateAnswer(vo);
		
		req.setAttribute("cnt", cnt);
		
		//
		req.setAttribute("q_num", vo.getQ_num());
		
		return "answerUpdateOk.jsp";
	}

}
