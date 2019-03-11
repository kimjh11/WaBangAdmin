package kr.wabang.answer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;
import kr.wabang.list.QuestionListVO;

public class CommandAnswerUpdate implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 답변 수정 폼(선택)
		//질문
		QuestionListVO vo = new QuestionListVO();
		//답변
		AnswerVO answervo = new AnswerVO();
		
		//질문 번호
		vo.setQ_num(Integer.parseInt(req.getParameter("q_num")));
		answervo.setQ_num(Integer.parseInt(req.getParameter("q_num")));
		
		AnswerDAO dao = new AnswerDAO();
		
		//질문
		dao.selectQuestion(vo);
		//답변
		dao.selectAnswerView(answervo);
		
		req.setAttribute("vo", vo);
		req.setAttribute("answervo", answervo);
		
		return "answerUpdateForm.jsp";
	}
}
