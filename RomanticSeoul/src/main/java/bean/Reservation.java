package bean;

public class Reservation {
	private int resseq;
	private String id;
	private int coseq;
	private int menuseq;
	private int price;
	private String regdate;
	private String redate;
	private String remark;
	
	
	@Override
	public String toString() {
		return "Reservation [resseq=" + resseq + ", id=" + id + ", coseq=" + coseq + ", menuseq=" + menuseq + ", price="
				+ price + ", regdate=" + regdate + ", redate=" + redate + ", remark=" + remark + "]";
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


	
	public int getMenuseq() {
		return menuseq;
	}


	
	public void setMenuseq(int menuseq) {
		this.menuseq = menuseq;
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
