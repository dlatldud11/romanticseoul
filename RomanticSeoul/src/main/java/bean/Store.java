package bean;

public class Store {
	private int storeseq;
	private String category; // 업태구분
	private String name; // 상세영업상태명
	private String address1; // 지번주소
	private String address2; // 도로명 주소
	private String hp; // 전화번호
	private String explain;
	private String x;
	private String y;
	private String gu; 
	private int likes;
	private String remark; // 상세영업상태명
	private int zipcode; // 도로명 우편번호
	
	
	@Override
	public String toString() {
		return "Store [storeseq=" + storeseq + ", category=" + category + ", name=" + name + ", address1=" + address1
				+ ", address2=" + address2 + ", hp=" + hp + ", explain=" + explain + ", x=" + x + ", y=" + y + ", gu="
				+ gu + ", likes=" + likes + ", remark=" + remark + ", zipcode=" + zipcode + "]";
	}


	
	public int getStoreseq() {
		return storeseq;
	}


	
	public void setStoreseq(int storeseq) {
		this.storeseq = storeseq;
	}


	
	public String getCategory() {
		return category;
	}


	
	public void setCategory(String category) {
		this.category = category;
	}


	
	public String getName() {
		return name;
	}


	
	public void setName(String name) {
		this.name = name;
	}


	
	public String getAddress1() {
		return address1;
	}


	
	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	
	public String getAddress2() {
		return address2;
	}


	
	public void setAddress2(String address2) {
		this.address2 = address2;
	}


	
	public String getHp() {
		return hp;
	}


	
	public void setHp(String hp) {
		this.hp = hp;
	}


	
	public String getExplain() {
		return explain;
	}


	
	public void setExplain(String explain) {
		this.explain = explain;
	}


	
	public String getX() {
		return x;
	}


	
	public void setX(String x) {
		this.x = x;
	}


	
	public String getY() {
		return y;
	}


	
	public void setY(String y) {
		this.y = y;
	}


	
	public String getGu() {
		return gu;
	}


	
	public void setGu(String gu) {
		this.gu = gu;
	}


	
	public int getLikes() {
		return likes;
	}


	
	public void setLikes(int likes) {
		this.likes = likes;
	}


	
	public String getRemark() {
		return remark;
	}


	
	public void setRemark(String remark) {
		this.remark = remark;
	}


	
	public int getZipcode() {
		return zipcode;
	}


	
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	
	
}
