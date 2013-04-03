package model.system;

public class PageList {
	int first = 0;// 记录开始数
	int fetch = 10;// 显示记录条数
	int totalnum;
	int totalpage;
	int pagenum = 1;

	// 定义查询条件
	String q1 = "";
	String q2 = "";
	String q3 = "";
	String q4 = "";
	String q5 = "";
	String q6 = "";
	String q7 = "";
	String q8 = "";
	String q9 = "";
	String q10 = "";
	String q11="";
	String q12="";
	String q13="";

	

	public void setParameters(int count) {
		totalnum = count;
		if (fetch == 0)
			totalpage = 0;
		else {
			if (totalnum % fetch == 0)
				totalpage = totalnum / fetch;
			else
				totalpage = (int) Math.floor(totalnum / fetch) + 1;
		}
		if (totalpage == 0)
			totalpage = 1;

	}

	public String getQ1() {
		return q1;
	}

	public void setQ1(String q1) {
		this.q1 = q1;
	}

	public String getQ10() {
		return q10;
	}

	public void setQ10(String q10) {
		this.q10 = q10;
	}

	public String getQ2() {
		return q2;
	}

	public void setQ2(String q2) {
		this.q2 = q2;
	}

	public String getQ3() {
		return q3;
	}

	public void setQ3(String q3) {
		this.q3 = q3;
	}

	public String getQ4() {
		return q4;
	}

	public void setQ4(String q4) {
		this.q4 = q4;
	}

	public String getQ5() {
		return q5;
	}

	public void setQ5(String q5) {
		this.q5 = q5;
	}

	public String getQ6() {
		return q6;
	}

	public void setQ6(String q6) {
		this.q6 = q6;
	}

	public String getQ7() {
		return q7;
	}

	public void setQ7(String q7) {
		this.q7 = q7;
	}

	public String getQ8() {
		return q8;
	}

	public void setQ8(String q8) {
		this.q8 = q8;
	}

	public String getQ9() {
		return q9;
	}

	public void setQ9(String q9) {
		this.q9 = q9;
	}

	public String getQ11() {
		return q11;
	}

	public void setQ11(String q11) {
		this.q11 = q11;
	}

	public String getQ12() {
		return q12;
	}

	public void setQ12(String q12) {
		this.q12 = q12;
	}

	public String getQ13() {
		return q13;
	}

	public void setQ13(String q13) {
		this.q13 = q13;
	}

	public int getFetch() {
		return fetch;
	}

	public void setFetch(int fetch) {
		this.fetch = fetch;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
		// this.first = (pagenum - 1) * fetch;
	}

	public int getTotalnum() {
		return totalnum;
	}

	public void setTotalnum(int totalnum) {
		this.totalnum = totalnum;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

}
