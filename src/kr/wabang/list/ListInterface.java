package kr.wabang.list;

import java.util.List;

import kr.wabang.answer.AnswerVO;

public interface ListInterface {
	
	//회원목록
	public List<MemberListVO> getAllMember();
	
	//주문목록
	public List<OrderListVO> getAllOrder();
	
	//입금and배송목록
	public List<OrderListVO> getAllPayment();
	
	//문의목록
	public List<QuestionListVO> getAllQuestion();
		
	//배송완료
	public int updateDelivery(String deliveryOk,String i_code,String o_num,String m_id);
	
}
