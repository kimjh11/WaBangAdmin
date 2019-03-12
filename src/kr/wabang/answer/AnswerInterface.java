package kr.wabang.answer;

import kr.wabang.list.QuestionListVO;

public interface AnswerInterface {
	//질문 select
	public void selectQuestion(QuestionListVO vo);
	
	//글 쓰기
	public int answerInsert(AnswerVO vo);
	
	//글 보기
	public void selectAnswerView(AnswerVO answervo);
	
	//글 수정
	public int updateAnswer(AnswerVO vo);
	
	//글 삭제
	public int deleteAnswer(AnswerVO vo);
}
