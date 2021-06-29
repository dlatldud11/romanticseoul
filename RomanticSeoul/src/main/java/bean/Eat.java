package bean;

public class Eat extends StoreList{
	String eatid; // 기본키

	public String getEatid() {
		return eatid;
	}

	public void setEatid(String eatid) {
		this.eatid = eatid;
	}

	@Override
	public String toString() {
		return "Eat [eatid=" + eatid + "]";
	}
	
	
}
