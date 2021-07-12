package bean;

public class Reservation {
	private int resseq;
	private String id;
	private int coseq;
	private int first; //menuseq
	private int second;
	private int third;
	private int price;
	private String regdate;
	private String redate;
	private String remark;
	
	
	@Override
	public String toString() {
		return "Reservation [resseq=" + resseq + ", id=" + id + ", coseq=" + coseq + ", first=" + first + ", second="
				+ second + ", third=" + third + ", price=" + price + ", regdate=" + regdate + ", redate=" + redate
				+ ", remark=" + remark + "]";
	}



	public int getFirst() {
		return first;
	}



	public void setFirst(int first) {
		this.first = first;
	}



	public int getSecond() {
		return second;
	}



	public void setSecond(int second) {
		this.second = second;
	}



	public int getThird() {
		return third;
	}



	public void setThird(int third) {
		this.third = third;
	}



	public int getResseq() {
		return resseq;
	}


	
	public void setResseq(int resseq) {
		this.resseq = resseq;
	}


	
	public String getId() {
		return id;
	}


	
	public void setId(String id) {
		this.id = id;
	}


	
	public int getCoseq() {
		return coseq;
	}


	
	public void setCoseq(int coseq) {
		this.coseq = coseq;
	}
	
	
	public int getPrice() {
		return price;
	}


	
	public void setPrice(int price) {
		this.price = price;
	}


	
	public String getRegdate() {
		return regdate;
	}


	
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}


	
	public String getRedate() {
		return redate;
	}


	
	public void setRedate(String redate) {
		this.redate = redate;
	}


	
	public String getRemark() {
		return remark;
	}


	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
