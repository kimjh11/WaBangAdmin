package kr.wabang.list;

import java.util.List;

import kr.wabang.answer.AnswerVO;

public interface ListInterface {
	
	//ȸ�����
	public List<MemberListVO> getAllMember();
	
	//�ֹ����
	public List<OrderListVO> getAllOrder();
	
	//�Ա�and��۸��
	public List<OrderListVO> getAllPayment();
	
	//���Ǹ��
	public List<QuestionListVO> getAllQuestion();
		
	//��ۿϷ�
	public int updateDelivery(String deliveryOk,String i_code,String o_num,String m_id);
	
}
