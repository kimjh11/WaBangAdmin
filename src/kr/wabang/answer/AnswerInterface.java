package kr.wabang.answer;

import kr.wabang.list.QuestionListVO;

public interface AnswerInterface {
	//���� select
	public void selectQuestion(QuestionListVO vo);
	
	//�� ����
	public int answerInsert(AnswerVO vo);
	
	//�� ����
	public void selectAnswerView(AnswerVO answervo);
	
	//�� ����
	public int updateAnswer(AnswerVO vo);
	
	//�� ����
	public int deleteAnswer(AnswerVO vo);
}
