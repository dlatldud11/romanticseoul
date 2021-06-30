package bean;

import org.springframework.web.multipart.MultipartFile;

public class Menu {
	private int menuseq;
	private int storeseq;
	private String mname;
	private int price;
	private String image;
	private String remark;
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;

		if (this.file != null) {
			this.image = this.file.getOriginalFilename();
		}
	}
	
	
	@Override
	public String toString() {
		return "Menu [menuseq=" + menuseq + ", storeseq=" + storeseq + ", mname=" + mname + ", price=" + price
				+ ", image=" + image + ", remark=" + remark + "]";
	}


	
	public int getMenuseq() {
		return menuseq;
	}


	
	public void setMenuseq(int menuseq) {
		this.menuseq = menuseq;
	}


	
	public int getStoreseq() {
		return storeseq;
	}


	
	public void setStoreseq(int storeseq) {
		this.storeseq = storeseq;
	}


	public String getMname() {
		return mname;
	}


	public void setMname(String mname) {
		this.mname = mname;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}

	
}
