package kr.wabang.list;

public class QuestionListVO {
	private int q_num;
	private String m_id;
	private String q_title;
	private String q_content;
	private String q_regdate;
	
	//답변 관련 변수
	private int a_num;
	private String a_regdate;
	
	public QuestionListVO() {}

	public int getQ_num() {
		return q_num;
	}

	public void setQ_num(int q_num) {
		this.q_num = q_num;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getQ_title() {
		return q_title;
	}

	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}

	public String getQ_content() {
		return q_content;
	}

	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}

	public String getQ_regdate() {
		return q_regdate;
	}

	public void setQ_regdate(String q_regdate) {
		this.q_regdate = q_regdate;
	}

	public String getA_regdate() {
		return a_regdate;
	}

	public void setA_regdate(String a_regdate) {
		this.a_regdate = a_regdate;
	}

	public int getA_num() {
		return a_num;
	}

	public void setA_num(int a_num) {
		this.a_num = a_num;
	}
	
	
	
}
