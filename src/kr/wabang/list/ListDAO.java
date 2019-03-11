package kr.wabang.list;

import java.util.ArrayList;
import java.util.List;

import kr.wabang.answer.AnswerVO;
import kr.wabang.util.DBConnection;

public class ListDAO extends DBConnection implements ListInterface {
	
	//회원목록
	public List<MemberListVO> getAllMember() {
		List<MemberListVO> list = new ArrayList<MemberListVO>();
		try {
			dbCon();
			String sql = " select m_id, m_name, m_tel, m_email, m_zipCode, "
					+ " m_addr, m_addrDetail, to_char(m_regdate,'YYYY-MM-DD') "
					+ " from member order by m_regdate desc ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberListVO vo = new MemberListVO();
				vo.setM_id(rs.getString(1));
				vo.setM_name(rs.getString(2));
				vo.setM_tel(rs.getString(3));
				vo.setM_email(rs.getString(4));
				vo.setM_zipCode(rs.getInt(5));
				vo.setM_addr(rs.getString(6));
				vo.setM_addrDetail(rs.getString(7));
				vo.setM_regdate(rs.getString(8));
								
				list.add(vo);
			}
			
		}catch(Exception e){
			System.out.println("회원 목록 불러오기 에러..."+e.getMessage());
		}finally {
			dbClose();
		}
		return list;
	}

	//주문목록
	public List<OrderListVO> getAllOrder() {
		List<OrderListVO> list = new ArrayList<OrderListVO>();
		try {
			dbCon();
			String sql = " select o.m_id, o.o_num, o.i_code, o.o_selectOpt, o.o_count, "
					+ " o.i_price, o.o_price, o.o_payment, m.m_zipCode, m.m_addr, m.m_addrDetail, "
					+ " to_char(o.o_date,'YYYY-MM-DD') "
					+ " from member m join orderList o "
					+ " on m.m_id=o.m_id "
					+ " order by o.o_date desc ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderListVO vo = new OrderListVO();
				vo.setM_id(rs.getString(1));
				vo.setO_num(rs.getString(2));
				vo.setI_code(rs.getString(3));
				vo.setO_selectOpt(rs.getString(4));
				vo.setO_count(rs.getInt(5));
				vo.setI_price(rs.getInt(6));
				vo.setO_price(rs.getInt(7));
				vo.setO_payment(rs.getInt(8));
				vo.setM_zipCode(rs.getInt(9));
				vo.setM_addr(rs.getString(10));
				vo.setM_addrDetail(rs.getString(11));
				vo.setO_date(rs.getString(12));
				
								
				list.add(vo);
			}
			
		}catch(Exception e){
			System.out.println("주문 목록 불러오기 에러..."+e.getMessage());
		}finally {
			dbClose();
		}
		return list;
	}
	//결제목록
	public List<OrderListVO> getAllPayment() {
		List<OrderListVO> list = new ArrayList<OrderListVO>();
		try {
			dbCon();
			String sql = " select o.m_id, o.o_num, o.i_code , "
					+ " o.o_price, o_deposit, o_delivery, "
					+ " to_char(o.o_date,'YYYY-MM-DD'),"
					+ " to_char(o.o_fix, 'YYYY-MM-DD'),"
					+ " to_char(o.o_deliverydate, 'YYYY-MM-DD') "
					+ " from member m join orderList o "
					+ " on m.m_id=o.m_id "
					+ " order by o.o_date desc ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderListVO vo = new OrderListVO();
				vo.setM_id(rs.getString(1));
				vo.setO_num(rs.getString(2));
				vo.setI_code(rs.getString(3));
				vo.setO_price(rs.getInt(4));
				vo.setO_deposit(rs.getString(5));
				vo.setO_delivery(rs.getString(6));
				vo.setO_date(rs.getString(7));
				vo.setO_fix(rs.getString(8));
				vo.setO_deliverydate(rs.getString(9));
				list.add(vo);
			}
			
		}catch(Exception e){
			System.out.println("결제목록 불러오기 에러..."+e.getMessage());
		}finally {
			dbClose();
		}
		return list;
	}
	
	//질문목록
	public List<QuestionListVO> getAllQuestion() {
		List<QuestionListVO> list = new ArrayList<QuestionListVO>();
		try {
			dbCon();
			String sql = " select q.q_num, q.m_id, q_title, q_content, to_char(q.q_regdate,'YYYY-MM-DD'), a.q_num, to_char(a.a_regdate,'YYYY-MM-DD') " 
					+" from question q join member m "
					+" on m.m_id = q.m_id "
					+" full outer join answer a "
					+" on a.q_num = q.q_num " 
					+" order by q.q_regdate desc ";
			
			System.out.println(sql);
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				QuestionListVO vo = new QuestionListVO();
 				vo.setQ_num(rs.getInt(1));
				vo.setM_id(rs.getString(2));
				vo.setQ_title(rs.getString(3));
				vo.setQ_content(rs.getString(4));
				vo.setQ_regdate(rs.getString(5));
				vo.setA_num(rs.getInt(6));
				vo.setA_regdate(rs.getString(7));
				
				list.add(vo);
			}
			
		}catch(Exception e){
			System.out.println("질문 목록 불러오기 에러..."+e.getMessage());
		}finally {
			dbClose();
		}
		return list;
	}

	@Override
	public int updateDelivery(String deliveryOk,String i_code, String o_num, String m_id) {
		int cnt = 0;
		try {
		dbCon();
		String sql = " update orderList set o_delivery = ?, o_deliverydate = sysdate "
				+ " where m_id=? and i_code=? and o_num=? ";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, deliveryOk);
		pstmt.setString(2, m_id);
		pstmt.setString(3, i_code);
		pstmt.setString(4, o_num);
		pstmt.executeUpdate();
		cnt = pstmt.executeUpdate();
		
		}catch(Exception e){
			System.out.println("결제완료 하기 에러..."+e.getMessage());
		}finally {
			dbClose();
		}
		return cnt;
	}	
}



