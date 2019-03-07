package kr.wabang.list;

import java.util.List;

public interface ListInterface {
	
	//회원목록
	public List<MemberListVO> getAllMember();
	//주문목록
	public List<OrderListVO> getAllOrder();
	//입금and배송목록
	public List<OrderListVO> getAllPayment();
	//문의목록
	public List<QuestionListVO> getAllQuestion();
	
}
