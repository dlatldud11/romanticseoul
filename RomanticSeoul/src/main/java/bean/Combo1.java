package bean;

import org.springframework.web.multipart.MultipartFile;

// stock + menu
public class Combo1 {
	// stock 필드
	private int qtyseq;
	private int qty;
	private int coseq;
	private String remark;
	private String starts;
	private String ends;
	// menu 필드
	private int menuseq;
	private int storeseq;
	private String mname;
	private int price;
	private String image;
	private MultipartFile file;
	private String drinkid;
	private String eatid;
	private String lookid;
	/**
	 * @return the qtyseq
	 */
	public int getQtyseq() {
		return qtyseq;
	}
	/**
	 * @param qtyseq the qtyseq to set
	 */
	public void setQtyseq(int qtyseq) {
		this.qtyseq = qtyseq;
	}
	/**
	 * @return the qty
	 */
	public int getQty() {
		return qty;
	}
	/**
	 * @param qty the qty to set
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}
	/**
	 * @return the coseq
	 */
	public int getCoseq() {
		return coseq;
	}
	/**
	 * @param coseq the coseq to set
	 */
	public void setCoseq(int coseq) {
		this.coseq = coseq;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the starts
	 */
	public String getStarts() {
		return starts;
	}
	/**
	 * @param starts the starts to set
	 */
	public void setStarts(String starts) {
		this.starts = starts;
	}
	/**
	 * @return the ends
	 */
	public String getEnds() {
		return ends;
	}
	/**
	 * @param ends the ends to set
	 */
	public void setEnds(String ends) {
		this.ends = ends;
	}
	/**
	 * @return the menuseq
	 */
	public int getMenuseq() {
		return menuseq;
	}
	/**
	 * @param menuseq the menuseq to set
	 */
	public void setMenuseq(int menuseq) {
		this.menuseq = menuseq;
	}
	/**
	 * @return the storeseq
	 */
	public int getStoreseq() {
		return storeseq;
	}
	/**
	 * @param storeseq the storeseq to set
	 */
	public void setStoreseq(int storeseq) {
		this.storeseq = storeseq;
	}
	/**
	 * @return the mname
	 */
	public String getMname() {
		return mname;
	}
	/**
	 * @param mname the mname to set
	 */
	public void setMname(String mname) {
		this.mname = mname;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return the file
	 */
	public MultipartFile getFile() {
		return file;
	}
	/**
	 * @param file the file to set
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	/**
	 * @return the drinkid
	 */
	public String getDrinkid() {
		return drinkid;
	}
	/**
	 * @param drinkid the drinkid to set
	 */
	public void setDrinkid(String drinkid) {
		this.drinkid = drinkid;
	}
	/**
	 * @return the eatid
	 */
	public String getEatid() {
		return eatid;
	}
	/**
	 * @param eatid the eatid to set
	 */
	public void setEatid(String eatid) {
		this.eatid = eatid;
	}
	/**
	 * @return the lookid
	 */
	public String getLookid() {
		return lookid;
	}
	/**
	 * @param lookid the lookid to set
	 */
	public void setLookid(String lookid) {
		this.lookid = lookid;
	}
	@Override
	public String toString() {
		return "Combo1 [qtyseq=" + qtyseq + ", qty=" + qty + ", coseq=" + coseq + ", remark=" + remark + ", starts="
				+ starts + ", ends=" + ends + ", menuseq=" + menuseq + ", storeseq=" + storeseq + ", mname=" + mname
				+ ", price=" + price + ", image=" + image + ", file=" + file + ", drinkid=" + drinkid + ", eatid="
				+ eatid + ", lookid=" + lookid + "]";
	}
	
	
}
