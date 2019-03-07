package kr.wabang.list;

public class OrderListVO {
	private String m_id;
	private String o_num;
	private String i_code;
	private int o_count;
	private String o_selectOpt;
	private int i_price;
	private int o_price;
	private int o_payment;
	private String o_deposit;
	private String o_date;
	private String o_fix;
	private String o_delivery;
	private String o_deliverydate;
	//회원주소
	private int m_zipCode;
	private String m_addr;
	private String m_addrDetail;
	
	//검색어
	private String searchKey=null;
	private String searchWord=null;
	
	public OrderListVO() {}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getO_num() {
		return o_num;
	}

	public void setO_num(String o_num) {
		this.o_num = o_num;
	}

	public String getI_code() {
		return i_code;
	}

	public void setI_code(String i_code) {
		this.i_code = i_code;
	}

	public int getO_count() {
		return o_count;
	}

	public void setO_count(int o_count) {
		this.o_count = o_count;
	}

	public String getO_selectOpt() {
		return o_selectOpt;
	}

	public void setO_selectOpt(String o_selectOpt) {
		this.o_selectOpt = o_selectOpt;
	}

	public int getO_price() {
		return o_price;
	}

	public void setO_price(int o_price) {
		this.o_price = o_price;
	}

	public int getO_payment() {
		return o_payment;
	}

	public void setO_payment(int o_payment) {
		this.o_payment = o_payment;
	}

	public String getO_deposit() {
		return o_deposit;
	}

	public void setO_deposit(String o_deposit) {
		this.o_deposit = o_deposit;
	}

	public String getO_date() {
		return o_date;
	}

	public void setO_date(String o_date) {
		this.o_date = o_date;
	}

	public String getO_fix() {
		return o_fix;
	}

	public void setO_fix(String o_fix) {
		this.o_fix = o_fix;
	}

	public String getO_delivery() {
		return o_delivery;
	}

	public void setO_delivery(String o_delivery) {
		this.o_delivery = o_delivery;
	}

	public int getM_zipCode() {
		return m_zipCode;
	}

	public void setM_zipCode(int m_zipCode) {
		this.m_zipCode = m_zipCode;
	}

	public String getM_addr() {
		return m_addr;
	}

	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}

	public String getM_addrDetail() {
		return m_addrDetail;
	}

	public void setM_addrDetail(String m_addrDetail) {
		this.m_addrDetail = m_addrDetail;
	}

	public int getI_price() {
		return i_price;
	}

	public void setI_price(int i_price) {
		this.i_price = i_price;
	}

	public String getO_deliverydate() {
		return o_deliverydate;
	}

	public void setO_deliverydate(String o_deliverydate) {
		this.o_deliverydate = o_deliverydate;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	
}
