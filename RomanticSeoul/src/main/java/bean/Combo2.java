package bean;

public class Combo2 {
	private int resseq; // 기본키(예약테이블)
	private int price; // 총 액수
	private int qty;
	private String regdate; // 주문 일자
	private String redate; // 예약 일자
	private int first; //메뉴 시퀀스
	private String firstmname;
	private int firstprice;
	private int second;
	private String secondmname;
	private int secondprice;
	private String id;
	private int third;
	

	@Override
	public String toString() {
		return "Combo2 [resseq=" + resseq + ", price=" + price + ", qty=" + qty + ", regdate=" + regdate + ", redate="
				+ redate + ", first=" + first + ", firstmname=" + firstmname + ", firstprice=" + firstprice
				+ ", second=" + second + ", secondmname=" + secondmname + ", secondprice=" + secondprice + ", id=" + id
				+ ", third=" + third + "]";
	}

	public int getThird() {
		return third;
	}

	public void setThird(int third) {
		this.third = third;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getResseq() {
		return resseq;
	}
	public void setResseq(int resseq) {
		this.resseq = resseq;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
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
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public String getFirstmname() {
		return firstmname;
	}
	public void setFirstmname(String firstmname) {
		this.firstmname = firstmname;
	}
	public int getFirstprice() {
		return firstprice;
	}
	public void setFirstprice(int firstprice) {
		this.firstprice = firstprice;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	public String getSecondmname() {
		return secondmname;
	}
	public void setSecondmname(String secondmname) {
		this.secondmname = secondmname;
	}
	public int getSecondprice() {
		return secondprice;
	}
	public void setSecondprice(int secondprice) {
		this.secondprice = secondprice;
	}
	
	
}
