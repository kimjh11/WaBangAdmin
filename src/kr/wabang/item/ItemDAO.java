package kr.wabang.item;

import java.util.ArrayList;
import java.util.List;

import kr.wabang.util.DBConnection;

public class ItemDAO extends DBConnection implements ItemIterface {

	@Override
	public int itemWrtie(ItemVO vo) {
		// 상품등록하는 곳
		int cnt = 0;
		dbCon();						
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
	public List<ItemVO> itemList() {
		List<ItemVO> list = new ArrayList<ItemVO>();
		try {
			dbCon();
			String sql = "select i_code, i_name, i_category, i_detail, i_opt, i_color"
					+ ", i_price, i_discount, i_thumbnail, to_char(i_regdate,'YY-MM-DD HH:MI') from item";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ItemVO vo = new ItemVO();				
				vo.setCode(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setCategory(rs.getString(3));
				vo.setDetail(rs.getString(4));
				vo.setOption(rs.getString(5));
				vo.setColor(rs.getString(6));
				vo.setPrice(rs.getInt(7));
				vo.setDiscount(rs.getInt(8));
				vo.setThumbnail(rs.getString(9));
				vo.setRegdate(rs.getString(10));
				
				list.add(vo);
			}
			
		}catch(Exception e) {
			System.out.println("상품리스트뽑는데 에러;;"+e.getMessage());
		}finally {
			dbClose();
		}
		return list;
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
	@Override
	public List<ItemVO> selectItem(ItemVO vo) {
		// 상품리스트에서 상품 자세히 보기
		List<ItemVO> list = new ArrayList<ItemVO>();
		try {
			dbCon();
			String sql = "select i_code, i_name, i_category, i_detail, i_opt, "
					+ " i_color, i_price, i_discount, i_thumbnail, to_char(i_regdate,'YY-MM-DD HH:MI') from item where i_code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getCode());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setCode(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setCategory(rs.getString(3));
				vo.setDetail(rs.getString(4));
				vo.setOption(rs.getString(5));
				vo.setColor(rs.getString(6));
				vo.setPrice(rs.getInt(7));
				vo.setDiscount(rs.getInt(8));
				vo.setThumbnail(rs.getString(9));
				vo.setRegdate(rs.getString(10));	
				list.add(vo);
			}
		}catch(Exception e) {
			System.out.println("아이템 셀렉트 실패;;"+e.getMessage());
		}finally {
			dbClose();
		}
		return list;
	}

}
