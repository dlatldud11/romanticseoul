package bean;

public class Myplan {
	private int planseq;
	private String id;
	private int qty;
	private String remark;
	private int menuseq;
	private int coseq;
	private String eatid;
	private String drinkid;
	private String lookid;
	
	
	
	@Override
	public String toString() {
		return "Myplan [planseq=" + planseq + ", id=" + id + ", qty=" + qty + ", remark=" + remark + ", menuseq="
				+ menuseq + ", coseq=" + coseq + ", eatid=" + eatid + ", drinkid=" + drinkid + ", lookid=" + lookid
				+ "]";
	}


	public String getEatid() {
		return eatid;
	}


	public void setEatid(String eatid) {
		this.eatid = eatid;
	}


	public String getDrinkid() {
		return drinkid;
	}


	public void setDrinkid(String drinkid) {
		this.drinkid = drinkid;
	}


	public String getLookid() {
		return lookid;
	}


	public void setLookid(String lookid) {
		this.lookid = lookid;
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
