package dao;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.Board;
import bean.BoardBoard;
import bean.Reply;

@Component("bbdao")
public class BoardBoardDao {
	private final String namespace = "MapBoardBoard." ;	
	
	@Autowired
	SqlSessionTemplate abcd;
	
	public BoardBoardDao() { }		
	
	public int SelectTotalCount(String mode, String keyword) {
		// 해당 모드와 키워드를 이용하여 조건에 맞는 데이터의 건수를 구해줍니다.
		Map<String, String> map = new HashMap<String, String>() ;
		map.put("mode", mode) ;
		map.put("keyword", "%" + keyword + "%") ;		
		return this.abcd.selectOne(namespace + "SelectTotalCount", map);		
	} 	
	
	public List<Board> SelectDataList(int offset, int limit, String mode, String keyword) {
		// 랭킹을 이용하여 해당 페이지의 데이터를 컬렉션으로 반환합니다.
		RowBounds rowBounds = new RowBounds(offset, limit);
		Map<String, String> map = new HashMap<String, String>() ;
		map.put("mode", mode) ;
		map.put("keyword", "%" + keyword + "%") ;	
		return this.abcd.selectList(namespace + "SelectDataList", map, rowBounds);
	}
	
	public Board SelectDataByPk(int no) {
		// 해당 게시물 번호의 Bean 객체를 구합니다.
		return this.abcd.selectOne(namespace + "SelectDataByPk", no);
	}
	
	public int UpdateReadhit(int no) {
		// 조회수를 1증가 시킵니다.
		return this.abcd.insert(namespace + "UpdateReadhit", no);
	}		
	
	public int UpdateData(Board bean) {
		// 해당 게시물을 수정합니다.   
		System.out.println(bean.toString());
		return this.abcd.update(namespace + "UpdateData", bean);
	}	
	
	public int DeleteData(int no) {
		return this.abcd.delete(namespace + "DeleteData", no);
	}
	
	public int InsertData(Board bean) {
		// 넘겨진 Bean 데이터를 이용하여 추가합니다.
		System.out.println(this.getClass() + " InsertData 메소드");
		System.out.println(bean.toString());
		return this.abcd.insert(namespace + "InsertData", bean);
	}
	
	public List<Board> ListData(Board bean) {
		System.out.println(this.ListData(bean));
		return this.abcd.selectList(namespace + "ListData", bean); 
	}
//	public int ReplyData(QnaBoard bean) {
////		-- 다음 문장으로 업데이트를 수행한다.
////		-- update sample set orderno = orderno + 1 where groupno = 부모의groupno and orderno > 부모의orderno ; 
//		int groupno = bean.get() ;
//		int orderno = bean.getOrderno() ;
//		
//		int cnt = -99999 ;
//		
//		Map<String, Integer> map = new HashMap<String, Integer>() ;
//		map.put("groupno", groupno) ;
//		map.put("orderno", orderno) ;
//		cnt = this.abcd.update(namespace + "ReplyDataUpdate", map);
//		
////		-- 다음의 값으로 인서트한다.
////		-- num : 시퀀스.nextval, groupno : 부모의groupno사용, orderno은 1증가, depth는 1증가 시켜서 인서트한다.
//		bean.setOrderno(bean.getOrderno() + 1 );
//		bean.setDepth(bean.getDepth() + 1);		
//
//		return this.abcd.insert(namespace + "ReplyDataInsert", bean);
//	}

	public List<BoardBoard> SelectDataList() {
		return this.abcd.selectList(namespace + "SelectDataList");
	}

	public int DeleteDataByBoseq(Map<String, Object> param) {
		return this.abcd.delete(namespace + "DeleteDataByBoseq", param);
	}
	public List<Reply> SelectReply(){
		return this.abcd.selectList(namespace + "SelectReply"); 
	}
	public int DeleteDataByReplyseq (int replyseq) {
		return this.abcd.delete(namespace + "DeleteDataByReplyseq", replyseq);
	}
	public int InsertReply(Reply reply) {
		return this.abcd.insert(namespace + "InsertReply", reply);
	}
	public int UpdateReply(Reply reply) {
		return this.abcd.update(namespace + "UpdateReply", reply);
	}
}