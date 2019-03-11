package kr.wabang.answer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;
import kr.wabang.list.QuestionListVO;

public class CommandAnswerWrite implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 답변 쓰기 폼으로.
		QuestionListVO vo = new QuestionListVO();
		
		//글 번호
		vo.setQ_num(Integer.parseInt(req.getParameter("q_num")));
		
		AnswerDAO dao = new AnswerDAO();
		dao.selectQuestion(vo);
		
		req.setAttribute("vo", vo);
		
		return "answerWriteForm.jsp";
	}
}
