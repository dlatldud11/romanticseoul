package bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Member {
	private final String MUST_INPUT = "필수 입력 사항입니다.";
  
	@Length(min=3, max=10, message="아이디는 최소 3자리 최대 10자리 입니다.")	
	private String id;

	@NotEmpty(message="비밀번호는 " + MUST_INPUT )
	@Length(min=3, max=10, message="비밀번호는 최소 3자리 최대 10자리 입니다.")	
    private String password;
	
	@NotEmpty(message="이름은 " + MUST_INPUT )
    private String name;
	
	@NotEmpty(message="닉네임은 " + MUST_INPUT )
    private String nickname;
	
	@NotEmpty(message="email은 " + MUST_INPUT )
	@Email(message = "email 형식으로 작성해 주세요.")
    private String email;
	
	@NotNull(message="성별은 반드시 선택해 주셔야 합니다.")
	private String gender;
	
	@NotEmpty(message="휴대전화 번호는 " + MUST_INPUT )
	@Length(min=10, max=11, message="번호를 정확히 입력해 주세요.")	
	@Pattern(regexp = "^\\d{10,11}$", message = "휴대폰 번호는 숫자만 입력해 주세요.")
	private String hp;
	
	@NotEmpty(message="주소는 " + MUST_INPUT )
    private String address1;
	 
	@NotEmpty(message="주소는 " + MUST_INPUT )
    private String address2;
	 
	@NotEmpty(message="우편번호는 " + MUST_INPUT )
    private String zipcode;
	 
	@NotNull(message="마시기 취향은 반드시 선택해 주셔야 합니다.")
    private String drink;
	
	@NotNull(message="먹기 취향은 반드시 선택해 주셔야 합니다.")
    private String eat;
	
	@NotNull(message="놀기 취향은 반드시 선택해 주셔야 합니다.")
    private String play;
	 
	@NotNull(message="걷기 취향은 반드시 선택해 주셔야 합니다.")
    private String walk;
	 
	@NotNull(message="보기 취향은 반드시 선택해 주셔야 합니다.")
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

