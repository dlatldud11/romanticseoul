package utility;

import java.util.ArrayList;
import java.util.List;

import bean.Store;

public class CombineAPI {
	private EatAPI eapi;
	private LookAPI lapi;
	private DrinkAPI dapi;
	
	public CombineAPI() {
		this.eapi = new EatAPI();
		this.lapi = new LookAPI();
		this.dapi = new DrinkAPI();
	}
	
	public List<Store> getMeCoLists(String s,String gu){
//		System.out.println("combineAPI 들어옴");
		List<Store> lists = new ArrayList<Store>();
		String[] s1 = s.split("/");
		
		if(s1[0].equals("eat")) {
			lists = this.eapi.getlistbyCategory(s1[1],gu);
		}
		if(s1[0].equals("drink")) {
			lists = this.dapi.getlistbyCategory(s1[1],gu);
		}
		if(s1[0].equals("look")) {
			lists = this.lapi.getlistbyCategory(s1[1],gu);
		}
		return lists;
	}
	public Store getByPk(String mode, String pk) { // mode로 pk 분기처리해서 가져오기
		Store bean = new Store();
		switch(mode) {
		case "eat" :
			bean = this.eapi.geteatByPk(pk);
			break;
		case "drink" :
			bean = this.dapi.getDrinkByPk(pk);
			break;
		case "look" :
			bean = this.lapi.getLookByPk(pk);
			break;
		}
		return bean;
	}
}
