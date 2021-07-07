package utility;

import java.util.ArrayList;
import java.util.List;

import bean.Myplan;
import bean.Store;

public class MyplanList {
	private List<Myplan> myplanlist;
	
	public MyplanList() {
		this.myplanlist = new ArrayList<Myplan>();
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
		public void EditOrder(Store store, int stock) {
			// pnum는 수정될 상품 번호, stock은 수정할 수량
			this.AddOrder(store, stock);
		}
		
		// 장바구니에 들어 있는 해당 상품을 삭제합니다.
		public void DeleteOrder(int pnum) {
			// pnum는 삭제될 상품 번호
			this.myplanlist.remove(pnum) ;
		}
		
		// 장바구니에 상품을 추가합니다.
		public void AddOrder(Store store, int stock) {
			if (this.myplanlist.contains(store)) { // 동일 상품이 이미 있는 경우
//				this.myplanlist.put(pnum, newstock);
			} else {
//				this.myplanlist.put(pnum, stock) ;
			}
		}
}
