package kr.wabang.item;

import java.util.List;

public interface ItemIterface {
	
	public int itemWrtie(ItemVO vo);
	
	public int editItem();
	
	public int deleteItem();
	
	public List<ItemVO> itemList();
	
	public List<ItemVO> selectItem(ItemVO vo);
}
