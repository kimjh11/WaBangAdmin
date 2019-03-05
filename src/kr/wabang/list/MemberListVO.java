package kr.wabang.list;

public class MemberListVO {
	private String m_id;
	private String m_pwd;
	private String m_name;
	private String m_tel;
	private String m_email;
	private int m_zipCode;
	private String m_addr;
	private String m_addrDetail;
	private String m_regdate;
	
		//paging 변수
		private int num=1;//현제페이지
		private int totalRecord=0;//총레코드수
		private int totalPage=1;//총페이지수
		private int onePageRecord=5;//한페이지당 표시할 레코드수
		private int startPage= 1;//시작페이지
		private int pageNumCount=5;//한번에 출력할 페이지번호수
		
		private String searchKey=null;
		private String searchWord=null;
		
	public MemberListVO(){}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pwd() {
		return m_pwd;
	}

	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_tel() {
		return m_tel;
	}

	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
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

	public String getM_regdate() {
		return m_regdate;
	}

	public void setM_regdate(String m_regdate) {
		this.m_regdate = m_regdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
		if(num%pageNumCount==0) {//5의 배수일때
			startPage = (num/pageNumCount-1)*pageNumCount+1;
		}else {//5의 배수 아닐때
			startPage = (num/pageNumCount)*pageNumCount+1;
		}
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getOnePageRecord() {
		return onePageRecord;
	}

	public void setOnePageRecord(int onePageRecord) {
		this.onePageRecord = onePageRecord;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getPageNumCount() {
		return pageNumCount;
	}

	public void setPageNumCount(int pageNumCount) {
		this.pageNumCount = pageNumCount;
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
