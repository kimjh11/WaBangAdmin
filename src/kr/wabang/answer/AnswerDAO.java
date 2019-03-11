package kr.wabang.answer;

import kr.wabang.list.QuestionListVO;
import kr.wabang.util.DBConnection;

public class AnswerDAO extends DBConnection implements AnswerInterface {

	@Override
	public void selectQuestion(QuestionListVO vo) {
		// 질문 select
		try{
			dbCon();
			String sql = "select * from question where q_num=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getQ_num());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				vo.setQ_num(rs.getInt(1));
				vo.setM_id(rs.getString(2));
				vo.setQ_title(rs.getString(3));
				vo.setQ_content(rs.getString(4));
				vo.setQ_regdate(rs.getString(5));
			}
		}catch(Exception e){
			System.out.println("질문 select 에러"+e.getMessage());
		}finally{
			dbClose();
		}
	}

	@Override
	public int answerInsert(AnswerVO vo) {
		// 답변 쓰기
		int cnt = 0;
		try{
			dbCon();
			String sql = "insert into answer(q_num, adminId, m_id, a_comment, a_regdate) "
					+ "values(?,?,?,?, sysdate)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getQ_num());
			pstmt.setString(2, vo.getAdminId());
			pstmt.setString(3, vo.getM_id());
			pstmt.setString(4, vo.getA_comment());
			
			cnt = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("답변 쓰기 에러"+e.getMessage());
		}finally{
			dbClose();
		}
		return cnt;
	}

	@Override
	public void selectAnswerView(AnswerVO answervo) {
		// 답변 글 보기
		try{
			dbCon();
			String sql = "select * from answer where q_num=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, answervo.getQ_num());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				answervo.setQ_num(rs.getInt(1));
				answervo.setAdminId(rs.getString(2));
				answervo.setM_id(rs.getString(3));
				answervo.setA_comment(rs.getString(4));
				answervo.setA_regdate(rs.getString(5));
			}
		}catch(Exception e){
			System.out.println("답변 글 보기 에러"+e.getMessage());
		}finally{
			dbClose();
		}
	}

	@Override
	public int updateAnswer(AnswerVO vo) {
		// 답변 수정
		int cnt =0;
		try{
			dbCon();
			String sql ="update answer set a_comment=? "
					+ "where q_num=? and m_id=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getA_comment());
			System.out.println(vo.getA_comment());
			pstmt.setInt(2, vo.getQ_num());
			System.out.println(vo.getQ_num());
			pstmt.setString(3, vo.getM_id());
			System.out.println(vo.getM_id());
			
			cnt =pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println("답변 수정 에러"+e.getMessage());
		}finally{
			dbClose();
		}
		return cnt;
	}

	@Override
	public int deleteAnswer(AnswerVO vo) {
		// 답변 글 삭제
		int cnt = 0;
		try{
			dbCon();
			String sql ="delete from answer where q_num=? and adminId=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getQ_num());
			pstmt.setString(2, vo.getAdminId());
			
			cnt = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("답변 글 삭제 에러"+e.getMessage());
		}finally{
			dbClose();
		}
		return cnt;
	}
}
