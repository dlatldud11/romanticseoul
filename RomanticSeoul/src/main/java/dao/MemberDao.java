package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.CheckBean;
import bean.Combo1;
import bean.Member;
//import shopping.ShoppingInfo 
import bean.QnaBoard;

@Component("mdao")
public class MemberDao {
	private final String namespace = "MapMember." ;	
	
	@Autowired 
	SqlSessionTemplate abcd;
	
	public MemberDao() { }	
	
	//아이디와 비번을 사용하여 해당 회원이 존재하나요?
	public Member SelectData(String id, String password) {
		Map<String, String> map = new HashMap<String, String>() ;
		map.put("id", id) ;
		map.put("password", password) ;
		return this.abcd.selectOne(namespace + "SelectData", map);
	}	

	public Member SelectDataByPk(String id) {
		// 아이디 정보를 이용하여 회원을 찾아 줍니다.
		return this.abcd.selectOne(namespace + "SelectDataByPk", id);
	}
	
	public Member SelectDataByNickname(String nickname) {
		// 아이디 정보를 이용하여 회원을 찾아 줍니다.
		return this.abcd.selectOne(namespace + "SelectDataByNickname", nickname);
	}
	
	public int InsertData(Member bean) {
		System.out.println("MemberDao"+bean.toString());
		return this.abcd.insert(namespace + "InsertData", bean);
	}	

	public int UpdateData(Member bean) {
		System.out.println("MemberUpdate"+bean.toString());
		return this.abcd.update(namespace + "UpdateData", bean) ;
	}

	public List<Member> SelectDataList(int offset, int limit, String mode, String keyword) {
		// RowBounds 객체를 사용한 페이징 처리입니다.
		RowBounds rbs = new RowBounds(offset, limit) ;
		return this.abcd.selectList(namespace + "SelectDataList", null, rbs);	
	}

	public int SelectTotalCount(String mode, String keyword) {
		return this.abcd.selectOne(namespace + "SelectTotalCount");
	}
	

	public int DeleteData(Member bean) {
		/*
		 * // boards.remark 수정, orders.remark 수정 // 해당 id를 이용하여 회원 탈퇴를 수행합니다.
		 * 
		 * // 탈퇴할 회원이 남긴 게시물 정보의 remark 컬럼 정보를 수정합니다. Map<String, String> map = new
		 * HashMap<String, String>() ;
		 * 
		 * // 심형래(sim09)가 회원 탈퇴를 하였습니다. String remark = bean.getName() + "(" +
		 * bean.getId() + ")가 회원 탈퇴를 하였습니다." ;
		 * 
		 * map.put("id", bean.getId()) ;
		 * 
		 * map.put("remark", remark) ;
		 * 
		 * this.abcd.update(namespace + "UpdateBoardRemark", map);
		 * 
		 * // orders.remark 수정 map.clear(); map.put("remark", remark) ; map.put("mid",
		 * bean.getId()) ; this.abcd.update(namespace + "UpdateOrderRemark", map);
		 */

		// 회원 탈퇴하기			
		return this.abcd.delete(namespace + "DeleteData", bean.getId());
	}
	
	    // 아이디 찾기
		public Member findEmail(String email){
			return this.abcd.selectOne(namespace + "findEmail", email);
		}
//	public void InsertCartData(Member mem, List<ShoppingInfo> lists) {
//		// 1. 장바구니 테이블에 혹시 남아 있을 수 있는 회원의 행을 모두 삭제합니다. 
//		this.abcd.delete(namespace + "DeleteShoppingInfo", mem.getId());
//		
//		// 2.반복문을 사용하여 테이블에 인서트 합니다.
//		for(ShoppingInfo shpInfo : lists){
//			this.abcd.insert(namespace + "InsertShoppingInfo", shpInfo);
//		}
//	}

		public Member findId(String id) {
			// TODO Auto-generated method stub
			return null;
		}

		public Member findPassword(String id, String email) {
			Map<String, String> map = new HashMap<String, String>() ;
			map.put("id", id) ;
			map.put("email", email) ;
			return this.abcd.selectOne(namespace + "findPassword", map);
		}
}
