package kr.wabang.list;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.answer.AnswerVO;
import kr.wabang.controller.CommandService;

public class CommandQuestionLi implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//질문목록
		ListDAO dao = new ListDAO();
		List<QuestionListVO> list = dao.getAllQuestion();
		
		req.setAttribute("list", list);
		
		return "questionList.jsp";
	}

}
