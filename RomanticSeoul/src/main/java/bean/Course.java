package bean;

public class Course {
   private int coseq;
   private int first;
   private int second;
   private int third;
   private int fourth;
   private int fifth;
   private String remark;
   
   @Override
   public String toString() {
      return "Course [coseq=" + coseq + ", first=" + first + ", second=" + second + ", third=" + third + ", fourth="
            + fourth + ", fifth=" + fifth + ", remark=" + remark + "]";
   }

   public int getCoseq() {
      return coseq;
   }

   public void setCoseq(int coseq) {
      this.coseq = coseq;
   }

   public int getFirst() {
      return first;
   }

   public void setFirst(int first) {
      this.first = first;
   }

   public int getSecond() {
      return second;
   }

   public void setSecond(int second) {
      this.second = second;
   }

   public int getThird() {
      return third;
   }

   public void setThird(int third) {
      this.third = third;
   }

   public int getFourth() {
      return fourth;
   }

   public void setFourth(int fourth) {
      this.fourth = fourth;
   }

   public int getFifth() {
      return fifth;
   }

   public void setFifth(int fifth) {
      this.fifth = fifth;
   }

   public String getRemark() {
      return remark;
   }

   public void setRemark(String remark) {
      this.remark = remark;
   }   
}