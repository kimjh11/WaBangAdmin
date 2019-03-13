package kr.wabang.item;

import java.util.List;

public interface ItemIterface {
	
	public int itemWrtie(ItemVO vo);
	
	public int editItem(ItemVO vo , String path);
	
	public int deleteItem(String code, String path);
	
	public List<ItemVO> itemList();
	
	public List<ItemVO> selectItem(ItemVO vo);
	
	public String[] getFileList(String code);
}
