package kr.wabang.item;

import java.io.File;
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
	public int editItem(ItemVO vo, String path) {
		// 상품 등록 수정
		int cnt = 0;
		String[] newDBFile = getFileList(vo.getCode());
		String[] dbFile = new String[newDBFile.length];
		//newDBFile[0] = DB에 저장된 Detail
		//newDBFile[1] = DB에 저장된 Thumbnail
		String[] thumbnail = newDBFile[1].split("|");
		System.out.println("newDBFile = "+newDBFile[0]+", "+newDBFile[1]);
		System.out.println("썸네일이다 = "+vo.getThumbnail());
		
		//이미지 수정을 안할 경우
		if(vo.getDelDetail() == null || vo.getDelDetail().equals("")) {
			dbFile[0] = newDBFile[0];
		}//이미지 수정을 할 경우
		else if(vo.getDelDetail() != null || !vo.getDelDetail().equals("")) {
			System.out.println("디테일 넘어온거  = "+vo.getDetail());
			dbFile[0] = vo.getDetail(); 
		}
		//썸네일 수정을 안할 경우
		if(vo.getDelThumb() == null || vo.getDelThumb().equals("")) {
			System.out.println("썸네일 수정 안함");
			dbFile[1] = newDBFile[1];
		}//수정을 하는 경우
		else if(vo.getDelThumb() != null || !vo.getDelThumb().equals("")){
			System.out.println("썸네일 수정할껑민");
				dbFile[1] = vo.getThumbnail();
		}
		
		System.out.println(vo.setVO());
	
			try {
				dbCon();
				String sql = "update item set i_name=?, i_category=?, i_detail=?, "
						+ "i_thumbnail=?, i_opt=?, i_color=?, i_price=?, i_discount=? where i_code=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getCategory());
				pstmt.setString(3, dbFile[0]);
				pstmt.setString(4, dbFile[1]);
				pstmt.setString(5, vo.getOption());
				pstmt.setString(6, vo.getColor());
				pstmt.setInt(7, vo.getPrice());
				pstmt.setInt(8, vo.getDiscount());
				pstmt.setString(9, vo.getCode());
				
				cnt = pstmt.executeUpdate();
				if(cnt>0) {
					if(rs.next()) {
							String del1 = rs.getString(1);
							String del2 = rs.getString(2);
							String del[] = del2.split("\\|");
								if(del1 != null && !del1.equals("")) {
									File f1 = new File(path, del1);
										f1.delete();
								}
								for(int i=0;i<=del.length-1;i++) {	
									if(del[i] !=null && !del[i].equals("")) {
										File f2 = new File(path, del[i]);
										f2.delete();
									}
								}
					}
				}
				
			
			}catch(Exception e) {
				System.out.println("수정 실패;;"+e.getMessage());
			}finally {
				dbClose();
			}
		return cnt;
	}

	@Override
	public int deleteItem(String code, String path) {
		// 상품 삭제
		int cnt = 0;
		try {
			dbCon();
			String sql = "select i_detail, i_thumbnail from item where i_code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			
			
			sql = "delete from item where i_code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, code);
			
			cnt = pstmt.executeUpdate();
			System.out.println("cnt = "+cnt);
			if(cnt>0) {
				if(rs.next()) {
						String del1 = rs.getString(1);
						String del2 = rs.getString(2);
						String del[] = del2.split("\\|");
							if(del1 != null && !del1.equals("")) {
								File f1 = new File(path, del1);
									f1.delete();
							}
							for(int i=0;i<=del.length-1;i++) {	
								if(del[i] !=null && !del[i].equals("")) {
									File f2 = new File(path, del[i]);
									f2.delete();
								}
							}
				}
			}
		}catch(Exception e) {
			System.out.println("삭제 실패;;"+e.getMessage());
		}finally {
			dbClose();
		}
		return cnt;
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
	@Override
	public String[] getFileList(String code) {
		String dbFile[] = new String[2];
		//DB에 저장되있는 File들
		try {
			dbCon();
			String sql = "select i_detail, i_thumbnail from item where i_code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, code);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dbFile[0] = rs.getString(1);
				dbFile[1]=rs.getString(2);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return dbFile;
	}

}
