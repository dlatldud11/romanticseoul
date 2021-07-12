package utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import bean.Myplan;
import bean.Store;

public class MyplanList {
	private List<Myplan> myplanlist = null;
	
	public MyplanList() {
		this.myplanlist = new ArrayList<Myplan>();
	}

		@Override
	public String toString() {
		return "MyplanList [myplanlist=" + myplanlist + "]";
	}

		// 장바구니 내역을 모두 삭제합니다.
		// 주로 결재가 이루어질 때 사용이 됩니다.
		public void RemoveAllProductInfo() {
			this.myplanlist.clear();
		}
		
		// 장바구니 내역 정보를 반환해줍니다.
		public List<Myplan> GetAllmyplanlist(){
			return this.myplanlist ;
		}
		
		// 장바구니 내역 정보를 수정합니다.
		public void EditOrder(String storeseq, int stock,String mode,String id) {
			// pnum는 수정될 상품 번호, stock은 수정할 수량
			this.AddOrder(storeseq, stock, mode,id);
		}
		
		// 장바구니에 들어 있는 해당 상품을 삭제합니다.
		public void DeleteOrder(String storeseq, String mode) {
			Iterator it = this.myplanlist.iterator();
			while(it.hasNext()){
			    Myplan bean = (Myplan)it.next();
			    if(!(mode == null || mode.isBlank())){ //mode 값이 넘어갔다면
			    	switch(mode) {
			    	case "eat":
			    		if(bean.getEatid() != null && bean.getEatid().equals(storeseq)) { // 장바구니에 같은 아이디인 가게가 있으면
			    			it.remove();
			    		}
			    		break;
			    	case "drink":
			    		if(bean.getDrinkid() != null && bean.getDrinkid().equals(storeseq)) { // 장바구니에 같은 아이디인 가게가 있으면
			    			it.remove();
			    		}
			    		break;
			    	case "look":
			    		if(bean.getLookid() != null && bean.getLookid().equals(storeseq)) { // 장바구니에 같은 아이디인 가게가 있으면
			    			it.remove();
			    		}
			    		break;
			    	}
			    }
			}
		}
		
		// 장바구니에 상품을 추가합니다.
		public void AddOrder(String storeseq, int stock, String mode,String id) {
			System.out.println("AddOrder 실행함");
			if(this.myplanlist.isEmpty()) { // 장바구니에 아무것도 없으면
				System.out.println("장바구니에 아무것도 없다");
				switch(mode) {
				case("eat"):
						Myplan myplan = new Myplan();
						myplan.setEatid(storeseq);
						myplan.setQty(stock);
						myplan.setId(id);
						this.myplanlist.add(myplan);
				break;
				case("drink"):
						Myplan myplan2 = new Myplan();
						myplan2.setDrinkid(storeseq);
						myplan2.setQty(stock);
						myplan2.setId(id);
						this.myplanlist.add(myplan2);
				break;
				case("look"):
						Myplan myplan3 = new Myplan();
						myplan3.setLookid(storeseq);
						myplan3.setQty(stock);
						myplan3.setId(id);
						this.myplanlist.add(myplan3);
				break;
				}
			}else { // 이미 장바구니가 있었을 때
				List<Myplan> add = new ArrayList<Myplan>();
				System.out.println("이미 장바구니가 있다.");
				for(Myplan bean : myplanlist) { 
					switch(mode) {
					case("eat"):
						if(bean.getEatid() != null && bean.getEatid().equals(storeseq)) {// eat이미 있으면
							bean.setQty(bean.getQty()+stock); 
							System.out.println("eat 장바구니 추가 이미 있다. 수량 추가");
						}else {
							Myplan myplan = new Myplan();
							myplan.setEatid(storeseq);
							myplan.setQty(stock);
							myplan.setId(id);
							add.add(myplan);
							System.out.println("장바구니에 없다");
						}
					break;
					case("drink"):
						if(bean.getDrinkid() != null && bean.getDrinkid().equals(storeseq)) {// eat이미 있으면
							bean.setQty(bean.getQty()+stock); // 수량 더해주기
							System.out.println("drink 장바구니 추가 이미 있다. 수량 추가");
						}else {
							Myplan myplan = new Myplan();
							myplan.setDrinkid(storeseq);
							myplan.setQty(stock);
							myplan.setId(id);
							add.add(myplan);
							System.out.println("drink 장바구니에 없다");
						}
					break;
					case("look"):
						if(bean.getLookid() != null && bean.getLookid().equals(storeseq)) {// eat이미 있으면
							bean.setQty(bean.getQty()+stock); // 수량 더해주기
						}else {
							Myplan myplan = new Myplan();
							myplan.setLookid(storeseq);
							myplan.setQty(stock);
							myplan.setId(id);
							add.add(myplan);
						}
					break;
					}
				}//for문 끝
				this.myplanlist.addAll(add); // 담아놓은거 합치기
			}
		}
}
