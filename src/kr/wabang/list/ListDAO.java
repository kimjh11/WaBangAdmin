package kr.wabang.list;

import java.util.ArrayList;
import java.util.List;


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
					+ " o.o_price, o.o_payment, m.m_zipCode, m.m_addr, m.m_addrDetail, "
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
				vo.setO_price(rs.getInt(6));
				vo.setO_payment(rs.getInt(7));
				vo.setM_zipCode(rs.getInt(8));
				vo.setM_addr(rs.getString(9));
				vo.setM_addrDetail(rs.getString(10));
				vo.setO_date(rs.getString(11));
				
								
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
			String sql = " select o.m_id, o.o_num, "
					+ " o.o_payment, o_deposit, o_delivery, "
					+ " to_char(o.o_date,'YYYY-MM-DD'),"
					+ " to_char(o.o_fix, 'YYYY-MM-DD') "
					+ " from member m join orderList o "
					+ " on m.m_id=o.m_id "
					+ " order by o.o_date desc ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderListVO vo = new OrderListVO();
				vo.setM_id(rs.getString(1));
				vo.setO_num(rs.getString(2));
				vo.setO_payment(rs.getInt(3));
				vo.setO_deposit(rs.getString(4));
				vo.setO_delivery(rs.getString(5));
				vo.setO_date(rs.getString(6));
				vo.setO_fix(rs.getString(7));
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
			String sql = " select q_num, q.m_id, q_title, q_content, to_char(q_regdate,'YYYY-MM-DD') "
					+ " from question q join member m "
					+ " on m.m_id=q.m_id "
					+ " order by q_regdate desc ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QuestionListVO vo = new QuestionListVO();
				vo.setQ_num(rs.getInt(1));
				vo.setM_id(rs.getString(2));
				vo.setQ_title(rs.getString(3));
				vo.setQ_content(rs.getString(4));
				vo.setQ_regdate(rs.getString(5));
				list.add(vo);
			}
			
		}catch(Exception e){
			System.out.println("질문 목록 불러오기 에러..."+e.getMessage());
		}finally {
			dbClose();
		}
		return list;
	}


}
