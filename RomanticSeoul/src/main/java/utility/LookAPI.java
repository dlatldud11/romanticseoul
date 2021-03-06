package utility;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import bean.CheckBean;
import bean.Look;
import bean.Store;

public class LookAPI {
//   public static void main(String[] args) {
//	   List<String> list = getLookdistinct();
//	   for(String bean : list) {
//		   System.out.println(bean);
//	   }
//	   ArrayList<Store> lists = getlookGulist("동대문구");
//	   int page = 1;
//		ArrayList<String> looklists = new ArrayList<String>();
//	    try {
//	       while(true)
//	       {
//	          String url = "http://openapi.seoul.go.kr:8088/787771684d6e6e6d3930576a5a4e6a/xml/SebcArtGalleryKor/1/240/";
//	          /*
//	           * String url =
//	           * "http://openapi.seoul.go.kr:8088/sample/xml/LOCALDATA_072405/1/5/" +
//	           * "ServiceKey=7571686f456e6e6d3430446f4d637a" + "&strSrch=3"+page;
//	           */            
//	          DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//	          DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//	          Document doc = dBuilder.parse(url);
//	          doc.getDocumentElement().normalize();
//	          
//	          System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
//	          
//	          NodeList nList = doc.getElementsByTagName("row");
//	          
//	          System.out.println("파싱할 리스트 수 : "+nList.getLength());
//	          
//	          for(int temp = 0; temp < nList.getLength(); temp++) {
//	             Node nNode = nList.item(temp);
//	             
//	             if(nNode.getNodeType() == Node.ELEMENT_NODE) {
//	                Element eElement = (Element) nNode;
//	                
//	                System.out.println("--------------------------------------------");
//	                System.out.println("기본키 : " + getTagValue("MAIN_KEY" ,eElement));
//	                looklists.add(getTagValue("MAIN_KEY" ,eElement));
//	             }
//	          }
//	          page += 1;
//	          System.out.println("page number " + page);
//	          if(page > 1) {
//	             break;
//	          }
//	       }
//	    }catch(Exception e) {
//	       e.printStackTrace();
//	    }
//
//   }
   
   private String getTagValue(String tag, Element eElement) {
      NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
      
      Node nValue = (Node) nlList.item(0);
      if(nValue == null) {
         return null;
      }
      return nValue.getNodeValue();
   }

public ArrayList<Look> getLooklists(List<CheckBean> gu){
	int page = 1;
	ArrayList<Look> looklists = new ArrayList<Look>();
    try {
       while(true)
       {
          String url = "http://openapi.seoul.go.kr:8088/787771684d6e6e6d3930576a5a4e6a/xml/SebcArtGalleryKor/1/240/";
          /*
           * String url =
           * "http://openapi.seoul.go.kr:8088/sample/xml/LOCALDATA_072405/1/5/" +
           * "ServiceKey=7571686f456e6e6d3430446f4d637a" + "&strSrch=3"+page;
           */            
          DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
          DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
          Document doc = dBuilder.parse(url);
          doc.getDocumentElement().normalize();
          
          System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
          
          NodeList nList = doc.getElementsByTagName("row");
          
          System.out.println("파싱할 리스트 수 : "+nList.getLength());
          
          for(int temp = 0; temp < nList.getLength(); temp++) {
             Node nNode = nList.item(temp);
             if(nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                Look bean = new Look();
                System.out.println("--------------------------------------------");
                System.out.println("기본키 : " + getTagValue("MAIN_KEY" ,eElement));
                for(int i=0; i < gu.size(); i++) {
                	if((getTagValue("H_KOR_GU" ,eElement).equals(gu.get(i).getMykey()))) {
                		bean.setRemark(gu.get(i).getMykey());
                	}
                }
                bean.setLookid(getTagValue("MAIN_KEY" ,eElement));
                looklists.add(bean);
                System.out.println("looklist에 들어옴"+looklists.get(temp));
             }
          }
          page += 1;
          System.out.println("page number " + page);
          if(page > 1) {
             break;
          }
       }
    }catch(Exception e) {
       e.printStackTrace();
    }return looklists;
}

public Store getLookByPk(String pk){
	int page = 1;
	Store bean = new Store();
	try {
		while(true)
		{
			String url = "http://openapi.seoul.go.kr:8088/787771684d6e6e6d3930576a5a4e6a/xml/SebcArtGalleryKor/1/240/";
			/*
			 * String url =
			 * "http://openapi.seoul.go.kr:8088/sample/xml/LOCALDATA_072405/1/5/" +
			 * "ServiceKey=7571686f456e6e6d3430446f4d637a" + "&strSrch=3"+page;
			 */            
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url);
			doc.getDocumentElement().normalize();
			
			System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("row");
			
			System.out.println("파싱할 리스트 수 : "+nList.getLength());
			
			for(int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					System.out.println("--------------------------------------------");
					System.out.println("기본키 : " + getTagValue("MAIN_KEY" ,eElement));
					if(getTagValue("MAIN_KEY" ,eElement).equals(pk)) {
					bean.setStoreseq(getTagValue("MAIN_KEY" ,eElement)); //기본키
					bean.setCategory(getTagValue("CATE3_NAME" ,eElement)); //분류3
					bean.setName(getTagValue("NAME_KOR" ,eElement)); //명칭
					bean.setAddress2(getTagValue("H_KOR_CITY" ,eElement)+" "
							+getTagValue("H_KOR_GU" ,eElement)+" "+getTagValue("H_KOR_DONG" ,eElement)); // 행정시+구+동
					bean.setGu(getTagValue("H_KOR_GU" ,eElement)); //구
					}
				}
			}
			page += 1;
			System.out.println("page number " + page);
			if(page > 1) {
				break;
			}
		}
	}catch(Exception e) {
		e.printStackTrace();
	}return bean;
}

public ArrayList<String> getLookdistinct(){
	int page = 1;
	ArrayList<String> looklists = new ArrayList<String>();
	try {
		while(true)
		{
			String url = "http://openapi.seoul.go.kr:8088/787771684d6e6e6d3930576a5a4e6a/xml/SebcArtGalleryKor/1/240/";
			/*
			 * String url =
			 * "http://openapi.seoul.go.kr:8088/sample/xml/LOCALDATA_072405/1/5/" +
			 * "ServiceKey=7571686f456e6e6d3430446f4d637a" + "&strSrch=3"+page;
			 */            
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url);
			doc.getDocumentElement().normalize();
			
			System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("row");
			
			System.out.println("파싱할 리스트 수 : "+nList.getLength());
			
			for(int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					System.out.println("--------------------------------------------");
					System.out.println("분류 : " + getTagValue("CATE3_NAME" ,eElement));
					if(!looklists.contains(getTagValue("CATE3_NAME" ,eElement))) {
						looklists.add(getTagValue("CATE3_NAME" ,eElement));
					}else {
						System.out.println("분류 중복");
					}
				}
			}
			page += 1;
			System.out.println("page number " + page);
			if(page > 1) {
				break;
			}
		}
	}catch(Exception e) {
		e.printStackTrace();
	}return looklists;
}

public ArrayList<Store> getlookGulist(String gu) {
	int page = 1;
	ArrayList<Store> looklists = new ArrayList<Store>();
	try {
		while(true)
		{
			String url = "http://openapi.seoul.go.kr:8088/787771684d6e6e6d3930576a5a4e6a/xml/SebcArtGalleryKor/1/240/";
			/*
			 * String url =
			 * "http://openapi.seoul.go.kr:8088/sample/xml/LOCALDATA_072405/1/5/" +
			 * "ServiceKey=7571686f456e6e6d3430446f4d637a" + "&strSrch=3"+page;
			 */            
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url);
			doc.getDocumentElement().normalize();
			
			System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("row");
			
			System.out.println("파싱할 리스트 수 : "+nList.getLength());
			
			for(int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					Store look = new Store();
					if(getTagValue("H_KOR_GU" ,eElement).equals(gu)) {
					System.out.println("look 일치하는 구 나옴");	
					look.setStoreseq(getTagValue("MAIN_KEY" ,eElement)); //기본키
					look.setCategory(getTagValue("CATE3_NAME" ,eElement)); //분류3
					look.setName(getTagValue("NAME_KOR" ,eElement)); //명칭
					look.setAddress2(getTagValue("H_KOR_CITY" ,eElement)+" "
							+getTagValue("H_KOR_GU" ,eElement)+" "+getTagValue("H_KOR_DONG" ,eElement)); // 행정시+구+동
					look.setGu(getTagValue("H_KOR_GU" ,eElement)); //구
					
					looklists.add(look);
					}
				}
			}
			page += 1;
			System.out.println("page number " + page);
			if(page > 1) {
				break;
			}
		}
	}catch(Exception e) {
		e.printStackTrace();
	}return looklists;
}

public List<Store> getlistbyCategory(String cate, String gu) { // 구별 카테고리별 리스트 가져오기
	int page = 1;
	ArrayList<Store> looklists = new ArrayList<Store>();
	try {
		while(true)
		{
			String url = "http://openapi.seoul.go.kr:8088/787771684d6e6e6d3930576a5a4e6a/xml/SebcArtGalleryKor/1/240/";
			/*
			 * String url =
			 * "http://openapi.seoul.go.kr:8088/sample/xml/LOCALDATA_072405/1/5/" +
			 * "ServiceKey=7571686f456e6e6d3430446f4d637a" + "&strSrch=3"+page;
			 */            
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url);
			doc.getDocumentElement().normalize();
			
			System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("row");
			
			System.out.println("파싱할 리스트 수 : "+nList.getLength());
			
			for(int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					Store look = new Store();
					if(getTagValue("H_KOR_GU" ,eElement).equals(gu) && getTagValue("CATE3_NAME" ,eElement).equals(cate)) {
					look.setStoreseq(getTagValue("MAIN_KEY" ,eElement)); //기본키
					look.setCategory(getTagValue("CATE3_NAME" ,eElement)); //분류3
					look.setName(getTagValue("NAME_KOR" ,eElement)); //명칭
					look.setAddress2(getTagValue("H_KOR_CITY" ,eElement)+" "
							+getTagValue("H_KOR_GU" ,eElement)+" "+getTagValue("H_KOR_DONG" ,eElement)); // 행정시+구+동
					look.setGu(getTagValue("H_KOR_GU" ,eElement)); //구
					
					looklists.add(look);
					}
				}
			}
			page += 1;
			System.out.println("page number " + page);
			if(page > 1) {
				break;
			}
		}
	}catch(Exception e) {
		e.printStackTrace();
	}return looklists;
}
}

