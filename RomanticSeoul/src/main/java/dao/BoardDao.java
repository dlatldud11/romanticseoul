package dao;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.Menu;
import bean.QnaBoard;
import bean.Reply;

@Component("bdao")
public class BoardDao {
	private final String namespace = "MapBoard." ;	
	
	@Autowired
	SqlSessionTemplate abcd;
	
	public BoardDao() { }		
	
	public int SelectTotalCount(String mode, String keyword) {
		// 해당 모드와 키워드를 이용하여 조건에 맞는 데이터의 건수를 구해줍니다.
		Map<String, String> map = new HashMap<String, String>() ;
		map.put("mode", mode) ;
		map.put("keyword", "%" + keyword + "%") ;		
		return this.abcd.selectOne(namespace + "SelectTotalCount", map);
	} 	
	
	public List<QnaBoard> SelectDataList(int offset, int limit, String mode, String keyword) {
		// 랭킹을 이용하여 해당 페이지의 데이터를 컬렉션으로 반환합니다.
		RowBounds rowBounds = new RowBounds(offset, limit);
		Map<String, String> map = new HashMap<String, String>() ;
		map.put("mode", mode) ;
		map.put("keyword", "%" + keyword + "%") ;	
		return this.abcd.selectList(namespace + "SelectDataList", map, rowBounds);
	}
	
	public QnaBoard SelectDataByPk(int qnaseq) {
		// 해당 게시물 번호의 Bean 객체를 구합니다.
		return this.abcd.selectOne(namespace + "SelectDataByPk", qnaseq);
	}
	
	public int UpdateReadhit(int no) {
		// 조회수를 1증가 시킵니다.
		return this.abcd.insert(namespace + "UpdateReadhit", no);
	}		
	
	public int UpdateData(QnaBoard bean) {
		// 해당 게시물을 수정합니다.   
		System.out.println(bean.toString());
		return this.abcd.update(namespace + "UpdateData", bean);
	}	
	
	public int DeleteData(int qnaseq) {
		return this.abcd.delete(namespace + "DeleteData", qnaseq);
	}
	
	public int InsertData(QnaBoard bean) {
		// 넘겨진 Bean 데이터를 이용하여 추가합니다.
		System.out.println(this.getClass() + " InsertData 메소드");
		System.out.println(bean.toString());
		return this.abcd.insert(namespace + "InsertData", bean);
	}
	
	public List<QnaBoard> ListData(QnaBoard bean) {
		System.out.println(this.ListData(bean));
		return this.abcd.selectList(namespace + "ListData", bean); 
	}
	public int ReplyInsertData(QnaBoard bean) {
		return this.abcd.insert(namespace + "ReplyInsertData", bean);
	}

	
	

}