package bean;

public class Eat implements StoreList{
	String eatid; // 기본키
	String remark;
	

	public String getEatid() {
		return eatid;
	}

	public void setEatid(String eatid) {
		this.eatid = eatid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
