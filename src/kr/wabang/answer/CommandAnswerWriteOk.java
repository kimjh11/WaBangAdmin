package kr.wabang.answer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandAnswerWriteOk implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 답변 쓰기
		req.setCharacterEncoding("UTF-8");
		
		AnswerVO vo = new AnswerVO();
		
		//글 번호
		vo.setQ_num(Integer.parseInt(req.getParameter("q_num")));
		System.out.println("");
		
		//어드민 아이디
		vo.setAdminId(req.getParameter("adminid"));
		System.out.println("adminId="+req.getParameter("adminid"));
		
		//아이디
		vo.setM_id(req.getParameter("m_id"));
		System.out.println("m_id="+req.getParameter("m_id"));
		
		//답변
		vo.setA_comment(req.getParameter("comment"));
		System.out.println("comment="+req.getParameter("comment"));
		
		AnswerDAO dao = new AnswerDAO();
		int cnt = dao.answerInsert(vo);
		
		req.setAttribute("cnt", cnt);
		
		return "answerWriteOk.jsp";
	}

}