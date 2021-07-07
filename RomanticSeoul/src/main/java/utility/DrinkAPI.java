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
import bean.Drink;
import bean.Store;

public class DrinkAPI {
//   public static void main(String[] args) {
//	   List<String> list = getDrinkdistinct();
//	   for ( String bean : list) {
//		   System.out.println(bean);
//	   }
//      int page = 1;
//      try {
//         while(true)
//         {
//            String url = "http://openapi.seoul.go.kr:8088/7571686f456e6e6d3430446f4d637a/xml/LOCALDATA_072405/1/1000/"+page;
//            
//            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//            Document doc = dBuilder.parse(url);
//            doc.getDocumentElement().normalize();
//            
//            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
//            
//            NodeList nList = doc.getElementsByTagName("row");
//            
//            System.out.println("파싱할 리스트 수 : "+nList.getLength());
//            
//            for(int temp = 0; temp < nList.getLength(); temp++) {
//               Node nNode = nList.item(temp);
//               
//               if(nNode.getNodeType() == Node.ELEMENT_NODE) {
//                  Element eElement = (Element) nNode;
//                  
//                  System.out.println("--------------------------------------------");
//                  System.out.println("주소 : " + getTagValue("SITEWHLADDR" ,eElement));
//                  System.out.println("상세주소 : " + getTagValue("RDNWHLADDR" ,eElement));
//                  System.out.println("이름 : " + getTagValue("BPLCNM" ,eElement));
//               }
//            }
//            page += 1;
//            System.out.println("page number " + page);
//            if(page > 1) {
//               break;
//            }
//         }
//      }catch(Exception e) {
//         e.printStackTrace();
//      }
//   }
   
   private String getTagValue(String tag, Element eElement) {
      NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
      
      Node nValue = (Node) nlList.item(0);
      if(nValue == null) {
         return null;
      }
      return nValue.getNodeValue();
   }
   
   public List<Drink> getDrinkLists(List<CheckBean> gu){
	   ArrayList<Drink> drinklists = new ArrayList<Drink>();
	   int page = 1;
	      try {
	         while(true)
	         {
	            String url = "http://openapi.seoul.go.kr:8088/7571686f456e6e6d3430446f4d637a/xml/LOCALDATA_072405/1/1000/"+page;
	            
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
	                  Drink bean = new Drink();
	                  System.out.println("--------------------------------------------");
	                  System.out.println("기본키 : " + getTagValue("MGTNO" ,eElement));
	                  String a = getTagValue("SITEWHLADDR" ,eElement); //지번주소
	                  String b = getTagValue("RDNWHLADDR" ,eElement); //도로명주소
	                  String c = a+b;
	                  for(int i=0; i<gu.size(); i++) {
	                	  if(c.contains(gu.get(i).getMykey())) {
	                		  bean.setRemark(gu.get(i).getMykey());
	                	  }
	                  }
	                  bean.setDrinkid(getTagValue("MGTNO" ,eElement));
	                  drinklists.add(bean);
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
	      }
	   return drinklists;
   }
   
   public Store getDrinkByPk(String pk){
	   Store bean = new Store();
	   int page = 1;
	   try {
		   while(true)
		   {
			   String url = "http://openapi.seoul.go.kr:8088/7571686f456e6e6d3430446f4d637a/xml/LOCALDATA_072405/1/1000/"+page;
			   
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
					   System.out.println("기본키 : " + getTagValue("MGTNO" ,eElement));
					   String a = getTagValue("SITEWHLADDR" ,eElement); //지번주소
					   String b = getTagValue("RDNWHLADDR" ,eElement); //도로명주소
					   if(getTagValue("MGTNO" ,eElement).equals(pk)) {
						   bean.setStoreseq(getTagValue("MGTNO" ,eElement)); //기본키
							bean.setCategory(getTagValue("UPTAENM" ,eElement)); //업태구분
							bean.setName(getTagValue("BPLCNM" ,eElement)); //사업장명
							bean.setAddress1(a); //지번주소
							bean.setAddress2(b); //도로명주소
							bean.setHp(getTagValue("SITETEL" ,eElement)); //전화번호
							bean.setRemark(getTagValue("DTLSTATENM" ,eElement)); //상세영업상태명
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
	   }
	   return bean;
   }
   
   
   public List<String> getDrinkdistinct(){
	   ArrayList<String> drinklists = new ArrayList<String>();
	   int page = 1;
	   try {
		   while(true)
		   {
			   String url = "http://openapi.seoul.go.kr:8088/7571686f456e6e6d3430446f4d637a/xml/LOCALDATA_072405/1/1000/"+page;
			   
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
					   System.out.println("업태구분명 : " + getTagValue("UPTAENM" ,eElement));
					   if(!drinklists.contains(getTagValue("UPTAENM" ,eElement))) {
						   drinklists.add(getTagValue("UPTAENM" ,eElement));
					   }else {
						   System.out.println("중복된 업태구분명");
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
	   }
	   return drinklists;
   }
public ArrayList<Store> getdrinkGulist(String gu) {
	ArrayList<Store> drinklists = new ArrayList<Store>();
	int page = 1;
	try {
		while(true)
		{
			String url = "http://openapi.seoul.go.kr:8088/7571686f456e6e6d3430446f4d637a/xml/LOCALDATA_072405/1/1000/"+page;
			
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
					Store bean = new Store();
					String a = getTagValue("SITEWHLADDR" ,eElement); //지번주소
					String b = getTagValue("RDNWHLADDR" ,eElement); //도로명주소
					String c = a+b;
					if(c.contains(gu)) {
					System.out.println("drink gu와 일치");
					bean.setStoreseq(getTagValue("MGTNO" ,eElement)); //기본키
					bean.setCategory(getTagValue("UPTAENM" ,eElement)); //업태구분
					bean.setName(getTagValue("BPLCNM" ,eElement)); //사업장명
					bean.setAddress1(a); //지번주소
					bean.setAddress2(b); //도로명주소
					bean.setHp(getTagValue("SITETEL" ,eElement)); //전화번호
					bean.setRemark(getTagValue("DTLSTATENM" ,eElement)); //상세영업상태명
//					bean.setZipcode(Integer.parseInt(getTagValue("RDNPOSTNO" ,eElement))); //도로명 우편번호
					drinklists.add(bean);
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
	}
	return drinklists;
}

public List<Store> getlistbyCategory(String cate, String gu) { // 구와 카테고리별로 가져오기
	ArrayList<Store> drinklists = new ArrayList<Store>();
	int page = 1;
	try {
		while(true)
		{
			String url = "http://openapi.seoul.go.kr:8088/7571686f456e6e6d3430446f4d637a/xml/LOCALDATA_072405/1/1000/"+page;
			
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
					Store bean = new Store();
					String a = getTagValue("SITEWHLADDR" ,eElement); //지번주소
					String b = getTagValue("RDNWHLADDR" ,eElement); //도로명주소
					String c = a+b;
					if(c.contains(gu) && getTagValue("UPTAENM" ,eElement).equals(cate) && !(getTagValue("DTLSTATENM" ,eElement).equals("폐업"))) { //구가 같고 카테고리가 같으면
					System.out.println("drink gu와 일치");
					bean.setStoreseq(getTagValue("MGTNO" ,eElement)); //기본키
					bean.setCategory(getTagValue("UPTAENM" ,eElement)); //업태구분
					bean.setName(getTagValue("BPLCNM" ,eElement)); //사업장명
					bean.setAddress1(a); //지번주소
					bean.setAddress2(b); //도로명주소
					bean.setHp(getTagValue("SITETEL" ,eElement)); //전화번호
					bean.setRemark(getTagValue("DTLSTATENM" ,eElement)); //상세영업상태명
//					bean.setZipcode(Integer.parseInt(getTagValue("RDNPOSTNO" ,eElement))); //도로명 우편번호
					drinklists.add(bean);
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
	}
	return drinklists;
}
}