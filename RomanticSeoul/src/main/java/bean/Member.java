package bean;

import org.springframework.web.multipart.MultipartFile;

public class Member {
   private String id;
   private String password;
   private String name;
   private String nickname;
   private String email;
   private String gender;
   private String hp;
   private String address1;
   private String address2;
   private String zipcode;
   private String drink;
   private String eat;
   private String play;
   private String walk;
   private String look;
   private String image;
   private String remark;
   
   private MultipartFile file;

   public Member() {
   }
   

@Override
public String toString() {
	return "Member [id=" + id + ", password=" + password + ", name=" + name + ", nickname=" + nickname + ", email="
			+ email + ", gender=" + gender + ", hp=" + hp + ", address1=" + address1 + ", address2=" + address2
			+ ", zipcode=" + zipcode + ", drink=" + drink + ", eat=" + eat + ", play=" + play + ", walk=" + walk
			+ ", look=" + look + ", image=" + image + ", remark=" + remark + ", file=" + file + "]";
}

public MultipartFile getFile() {
	return file;
}

public void setFile(MultipartFile file) {
	this.file = file;
	
	if( this.file != null){ 
		this.image = this.file.getOriginalFilename();
	}
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getId() {
      return id;
   }
 
   public void setId(String id) {
      this.id = id;
   }
   public String getDrink() {
      return drink;
   }
   public void setDrink(String drink) {
      this.drink = drink;
   }
   public String getPassword() {
      return password;
   }
   public void setPassword(String password) {
      this.password = password;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getGender() {
      return gender;
   }
   public void setGender(String gender) {
      this.gender = gender;
   }
   public String getHp() {
      return hp;
   }
   public void setHp(String hp) {
      this.hp = hp;
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
   public String getZipcode() {
      return zipcode;
   }
   public void setZipcode(String zipcode) {
      this.zipcode = zipcode;
   }
   public String getEat() {
      return eat;
   }
   public void setEat(String eat) {
      this.eat = eat;
   }
   public String getPlay() {
      return play;
   }
   public void setPlay(String play) {
      this.play = play;
   }
   public String getWalk() {
      return walk;
   }
   public void setWalk(String walk) {
      this.walk = walk;
   }
   public String getLook() {
      return look;
   }
   public void setLook(String look) {
      this.look = look;
   }
   public String getImage() {
      return image;
   }
   public void setImage(String image) {
      this.image = image;
   }
   public String getNickname() {
      return nickname;
   }
   public void setNickname(String nickname) {
      this.nickname = nickname;
   }
   public String getRemark() {
      return remark;
   }
   public void setRemark(String remark) {
      this.remark = remark;
   }
   
   
}

