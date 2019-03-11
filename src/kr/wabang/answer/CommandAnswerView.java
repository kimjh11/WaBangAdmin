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
		// �亯 �����ִ� ��
		AnswerVO answervo = new AnswerVO();
		// ���� ����/���� ��������
		QuestionListVO vo= new QuestionListVO();
		
		//�� ��ȣ
		vo.setQ_num(Integer.parseInt(req.getParameter("q_num")));
		answervo.setQ_num(Integer.parseInt(req.getParameter("q_num")));
		
		AnswerDAO dao = new AnswerDAO();
		
		// ����
		dao.selectQuestion(vo);
		// �亯
		dao.selectAnswerView(answervo);
		
		req.setAttribute("vo", vo);
		req.setAttribute("answervo", answervo);
		
		return "answerView.jsp";
	}

}
