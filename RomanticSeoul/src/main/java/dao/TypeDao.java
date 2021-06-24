package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.CheckBean;
//import shopping.ShoppingInfo;

@Component("tdao")
public class TypeDao {
	private final String namespace = "MapperCommon." ;	
	
	@Autowired
	SqlSessionTemplate abcd;
	
	public TypeDao() { }	
	
	public List<CheckBean> GetList(String module, String field) {		
		// 체크 박스, 라디오 버튼, 콤보 박스의 내용들을 가져옵니다.
		Map<String, String> map = new HashMap<String, String>() ;
		map.put("module", module) ;
		map.put("field", field) ;
		return this.abcd.selectList(namespace + "GetList", map);	
	}	
}
