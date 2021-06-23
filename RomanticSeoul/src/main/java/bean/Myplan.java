package bean;

public class Myplan {
	private int planseq;
	private String id;
	private int storeseq;
	private int qty;
	private String remark;
	private int menuseq;
	private int coseq;
	
	@Override
	public String toString() {
		return "Myplan [planseq=" + planseq + ", id=" + id + ", storeseq=" + storeseq + ", qty=" + qty + ", remark="
				+ remark + ", menuseq=" + menuseq + ", coseq=" + coseq + "]";
	}

	
	public int getPlanseq() {
		return planseq;
	}


	public void setPlanseq(int planseq) {
		this.planseq = planseq;
	}

	
	public String getId() {
		return id;
	}

	
	public void setId(String id) {
		this.id = id;
	}

	
	public int getStoreseq() {
		return storeseq;
	}

	
	public void setStoreseq(int storeseq) {
		this.storeseq = storeseq;
	}

	
	public int getQty() {
		return qty;
	}

	
	public void setQty(int qty) {
		this.qty = qty;
	}

	
	public String getRemark() {
		return remark;
	}

	
	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	public int getMenuseq() {
		return menuseq;
	}

	
	public void setMenuseq(int menuseq) {
		this.menuseq = menuseq;
	}

	
	public int getCoseq() {
		return coseq;
	}

	
	public void setCoseq(int coseq) {
		this.coseq = coseq;
	}
	
	
}
