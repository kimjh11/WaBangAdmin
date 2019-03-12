package kr.wabang.answer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;
import kr.wabang.list.QuestionListVO;

public class CommandAnswerView implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 답변 보여주는 폼
		AnswerVO answervo = new AnswerVO();
		// 질문 제목/내용 가져오기
		QuestionListVO vo= new QuestionListVO();
		
		//글 번호
		vo.setQ_num(Integer.parseInt(req.getParameter("q_num")));
		answervo.setQ_num(Integer.parseInt(req.getParameter("q_num")));
		
		AnswerDAO dao = new AnswerDAO();
		
		// 질문
		dao.selectQuestion(vo);
		// 답변
		dao.selectAnswerView(answervo);
		
		req.setAttribute("vo", vo);
		req.setAttribute("answervo", answervo);
		
		return "answerView.jsp";
	}

}
