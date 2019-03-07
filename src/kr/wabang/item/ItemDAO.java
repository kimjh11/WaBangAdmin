package kr.wabang.item;

import kr.wabang.util.DBConnection;

public class ItemDAO extends DBConnection implements ItemIterface {

	@Override
	public int itemWrtie(ItemVO vo) {
		// 처음 상품등록 하는 곳
		int cnt = 0;
		dbCon();								// | => 있을수도있고 없을수도있느것
		String sql = "insert into item(i_code, i_category, i_name,i_price,";
				if(vo.getDiscount()<=0) {
					sql += " i_thumbnail, i_opt, i_color, i_detail, i_regdate)"
							+ " values(? , ? , ? , ? , ? , ? , ? , ? , sysdate)";
				}else {
					sql += " i_discount , i_thumbnail , i_opt , i_color , i_detail , i_regdate)"
							+ " values(? , ? , ? , ? , ? , ? , ? , ? , ? , sysdate)";

				}
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getCode());
			pstmt.setString(2, vo.getCategory());
			pstmt.setString(3, vo.getName());
			pstmt.setInt(4, vo.getPrice());
			if(vo.getDiscount()<=0) {
				pstmt.setString(5, vo.getThumbnail());
				pstmt.setString(6, vo.getOption());
				pstmt.setString(7, vo.getColor());
				pstmt.setString(8, vo.getDetail());
			}else {
				pstmt.setInt(5, vo.getDiscount());
				pstmt.setString(6, vo.getThumbnail());
				pstmt.setString(7, vo.getOption());
				pstmt.setString(8, vo.getColor());
				pstmt.setString(9, vo.getDetail());
			}
		cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("상품등록에러;;"+e.getMessage());
		}finally {
			dbClose();
		}
			
		return cnt;
	}

	@Override
	public int editItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteItem() {
		// TODO Auto-generated method stub
		return 0;
	}

}
