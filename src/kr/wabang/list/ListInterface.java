package kr.wabang.list;

import java.util.List;

public interface ListInterface {
	
	//ȸ�����
	public List<MemberListVO> getAllMember();
	//�ֹ����
	public List<OrderListVO> getAllOrder();
	//�Ա�and��۸��
	public List<OrderListVO> getAllPayment();
	//���Ǹ��
	public List<QuestionListVO> getAllQuestion();
	
}
