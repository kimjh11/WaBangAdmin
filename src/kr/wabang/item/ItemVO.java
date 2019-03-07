package kr.wabang.item;

public class ItemVO {
	private String code;
	private String category;
	private String name;
	private int price;
	private int discount;
	private String thumbnail="";
	private String option;
	private String color;
	private String detail="";
	private String regdate;
	private String newFileName[];
	
	public String setVO() {
		String allVO = "code = "+code+"\n";
			   allVO += "category = "+category+"\n";
			   allVO += "name = "+name+"\n";
			   allVO += "price = "+price+"\n";
			   allVO += "discount = "+discount+"\n";
			   allVO += "thumbnail = "+thumbnail+"\n";
			   allVO += "option = "+option+"\n";
			   allVO += "color = "+color+"\n";
			   allVO += "detail = "+detail+"\n";
			   allVO += "regdate = "+regdate+"\n";
			   allVO += "newFileName = "+newFileName+"\n";
		return allVO;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String[] getNewFileName() {
		return newFileName;
	}
	public void setNewFileName(String[] newFileName) {
		this.newFileName = newFileName;
		//조건문으로 null은 받지 마라라
	
		if(newFileName[3] !=null) {
			this.thumbnail += newFileName[3]+"|";
		}if(newFileName[2] !=null) {
			this.thumbnail += newFileName[2]+"|";
		}if(newFileName[1] !=null) {
			this.thumbnail += newFileName[1];
		}if(newFileName[0] !=null) {
			this.detail += newFileName[0];
		}
	}
	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	
	
};
