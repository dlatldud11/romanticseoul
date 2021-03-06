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
import bean.Eat;
import bean.Store;

public class EatAPI {
//RDNWHLADDR 도로명주소 SITEWHLADDR 지번주소

    // tag값의 정보를 가져오는 메소드
   private String getTagValue(String tag, Element eElement) {
       NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
       Node nValue = (Node) nlList.item(0);
       if(nValue == null) 
           return null;
       return nValue.getNodeValue();
   }

//   public static void main(String[] args) {
//	   ArrayList<String> list = geteatdistinct();
//	   for (String bean : list) {
//		   System.out.println(bean);
//	   }
//      int page = 1;   // 페이지 초기값 
//      try{
//         while(true){
//            // parsing할 url 지정(API 키 포함해서)
//            String url = "http://openapi.seoul.go.kr:8088/5876546e6a6e6e6d313035734d716c50/xml/LOCALDATA_072404/1/5/"+page;
//            
//            DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
//            DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
//            Document doc = dBuilder.parse(url);
//            
//            // root tag 
//            doc.getDocumentElement().normalize();
//            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
//            
//            // 파싱할 tag
//            NodeList nList = doc.getElementsByTagName("row");
//            System.out.println("파싱할 리스트 수 : "+ nList.getLength());
//            
//            ArrayList<String> eatlist = new ArrayList<String>();
//            
//            for(int temp = 0; temp < nList.getLength(); temp++){
//               Node nNode = nList.item(temp);
//               if(nNode.getNodeType() == Node.ELEMENT_NODE){
//                  
//                  Element eElement = (Element) nNode;
//                  System.out.println("######################");
//                  //System.out.println(eElement.getTextContent());
//                  System.out.println("관리번호  : " + getTagValue("MGTNO", eElement));
//                  eatlist.add(getTagValue("MGTNO", eElement));
//                  System.out.println("eatlist 에 들어옴"+eatlist.get(temp));
//                  
//               }   // for end
//            }   // if end
//            
//            page += 1;
//            System.out.println("page number : "+page);
//            if(page > 12){   
//               break;
//            }
//         }   // while end
//         
//      } catch (Exception e){   
//         e.printStackTrace();
//      }   // try~catch end
//	   geteatlist();
//   }   // main end
   
   public ArrayList<Eat> geteatlist(List<CheckBean> gulists){
	   int a = 1;   // 페이지 초기값 
	   ArrayList<Eat> eatlists = new ArrayList<Eat>();
	      try{
	         while(true){
	            // parsing할 url 지정(API 키 포함해서)
	            String url = "http://openapi.seoul.go.kr:8088/5876546e6a6e6e6d313035734d716c50/xml/LOCALDATA_072404/"+a+"/"+(a*1000)+"/"+a;
	            
	            DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
	            DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
	            Document doc = dBuilder.parse(url);
	            
	            // root tag 
	            doc.getDocumentElement().normalize();
	            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	            
	            // 파싱할 tag
	            NodeList nList = doc.getElementsByTagName("row");
	            System.out.println("파싱할 리스트 수 : "+ nList.getLength());
	            
	            
	            for(int temp = 0; temp < nList.getLength(); temp++){
	               Node nNode = nList.item(temp);
	               if(nNode.getNodeType() == Node.ELEMENT_NODE){
	                  Eat bean = new Eat();
	                  Element eElement = (Element) nNode;
	                  System.out.println("######################");
	                  //System.out.println(eElement.getTextContent());
	                  System.out.println("관리번호  : " + getTagValue("MGTNO", eElement));
	                  String b = getTagValue("RDNWHLADDR", eElement); //도로명주소
	                  String c = getTagValue("SITEWHLADDR", eElement); //지번주소
	                  String d = b+c; // 주소 합침
	                  bean.setEatid(getTagValue("MGTNO", eElement));//기본키
	                  for(int i=0; i < gulists.size(); i++) {
	                	  if(d.contains((String)gulists.get(i).getMykey())) {
	                		  bean.setRemark((String)gulists.get(i).getMykey());
	                	  }
	                  }
	                  eatlists.add(bean);
	               }   // for end
	            }   // if end
	            
	            a += 1;
	            System.out.println("page number : "+a);
	            if(a > 6){   
	               break;
	            }
	         }   // while end
	         
	      } catch (Exception e){   
	         e.printStackTrace();
	      }   // try~catch end
	      return eatlists;
   }
   
   public ArrayList<String> geteatdistinct(){
	   int a = 1;   // 페이지 초기값 
	   ArrayList<String> eatlists = new ArrayList<String>();
	   try{
		   while(true){
			   // parsing할 url 지정(API 키 포함해서)
			   String url = "http://openapi.seoul.go.kr:8088/5876546e6a6e6e6d313035734d716c50/xml/LOCALDATA_072404/"+a+"/"+(a*1000)+"/"+a;
			   
			   DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
			   DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
			   Document doc = dBuilder.parse(url);
			   
			   // root tag 
			   doc.getDocumentElement().normalize();
			   System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			   
			   // 파싱할 tag
			   NodeList nList = doc.getElementsByTagName("row");
			   System.out.println("파싱할 리스트 수 : "+ nList.getLength());
			   
			   
			   for(int temp = 0; temp < nList.getLength(); temp++){
				   Node nNode = nList.item(temp);
				   if(nNode.getNodeType() == Node.ELEMENT_NODE){
					   
					   Element eElement = (Element) nNode;
					   System.out.println("######################");
					   //System.out.println(eElement.getTextContent());
					   System.out.println("업태구분  : " + getTagValue("UPTAENM", eElement));
					   if(!eatlists.contains(getTagValue("UPTAENM", eElement))) {
						   eatlists.add(getTagValue("UPTAENM", eElement));
					   }else {
						   System.out.println("중복된 업태구분명");
					   }
					   
				   }   // for end
			   }   // if end
			   
			   a += 1;
			   System.out.println("page number : "+a);
			   if(a > 6){   
				   break;
			   }
		   }   // while end
		   
	   } catch (Exception e){   
		   e.printStackTrace();
	   }   // try~catch end
	   return eatlists;
   }
   
   public ArrayList<Store> geteatGulist(String gu){
	   int a = 1;   // 페이지 초기값 
	   ArrayList<Store> eatlists = new ArrayList<Store>();
	      try{
	         while(true){
	            // parsing할 url 지정(API 키 포함해서)
	            String url = "http://openapi.seoul.go.kr:8088/5876546e6a6e6e6d313035734d716c50/xml/LOCALDATA_072404/"+a+"/"+(a*1000)+"/"+a;
	            
	            DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
	            DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
	            Document doc = dBuilder.parse(url);
	            
	            // root tag 
	            doc.getDocumentElement().normalize();
	            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	            
	            // 파싱할 tag
	            NodeList nList = doc.getElementsByTagName("row");
	            System.out.println("파싱할 리스트 수 : "+ nList.getLength());
	            
	            
	            for(int temp = 0; temp < nList.getLength(); temp++){
	               Node nNode = nList.item(temp);
	               if(nNode.getNodeType() == Node.ELEMENT_NODE){
	                  
	                  Element eElement = (Element) nNode;
//	                  System.out.println("######################");
	                  //System.out.println(eElement.getTextContent());
//	                  System.out.println("도로명주소  : " + getTagValue("RDNWHLADDR", eElement));
//	                  System.out.println("지번주소  : " + getTagValue("SITEWHLADDR", eElement));
	                  String b = getTagValue("RDNWHLADDR", eElement); //도로명주소
	                  String c = getTagValue("SITEWHLADDR", eElement); //지번주소
	                  String d = b+c; // 주소 합침
	                  if(d.contains(gu) && !(getTagValue("DTLSTATENM", eElement).equals("폐업"))) {
	                	  System.out.println("원하는 구 값이 나옴");
	                	  Store bean = new Store();
	                	  bean.setStoreseq(getTagValue("MGTNO", eElement)); //기본키
	                	  bean.setCategory(getTagValue("UPTAENM", eElement)); //업태구분
	                	  bean.setName(getTagValue("BPLCNM", eElement)); //사업장명
	                	  bean.setAddress1(c); //지번주소
	                	  bean.setAddress2(b); //도로명주소
	                	  bean.setHp(getTagValue("SITETEL", eElement)); //전화번호
	                	  bean.setRemark(getTagValue("DTLSTATENM", eElement)); //상세영업상태명
	                	  
	                	  eatlists.add(bean);
	                  }
	             
	               }   // for end
	            }   // if end
	            
	            a += 1;
	            System.out.println("page number : "+a);
	            if(a >1){   
	               break;
	            }
	         }   // while end
	         
	      } catch (Exception e){   
	         e.printStackTrace();
	      }   // try~catch end
	      return eatlists;
   }
   public Store geteatByPk(String pk){
	   int a = 1;   // 페이지 초기값 
	   Store bean = new Store();
	   try{
		   while(true){
			   // parsing할 url 지정(API 키 포함해서)
			   String url = "http://openapi.seoul.go.kr:8088/5876546e6a6e6e6d313035734d716c50/xml/LOCALDATA_072404/"+a+"/"+(a*1000)+"/"+a;
			   
			   DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
			   DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
			   Document doc = dBuilder.parse(url);
			   
			   // root tag 
			   doc.getDocumentElement().normalize();
			   System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			   
			   // 파싱할 tag
			   NodeList nList = doc.getElementsByTagName("row");
			   System.out.println("파싱할 리스트 수 : "+ nList.getLength());
			   
			   
			   for(int temp = 0; temp < nList.getLength(); temp++){
				   Node nNode = nList.item(temp);
				   if(nNode.getNodeType() == Node.ELEMENT_NODE){
					   
					   Element eElement = (Element) nNode;
//	                  System.out.println("######################");
					   //System.out.println(eElement.getTextContent());
//	                  System.out.println("도로명주소  : " + getTagValue("RDNWHLADDR", eElement));
//	                  System.out.println("지번주소  : " + getTagValue("SITEWHLADDR", eElement));
					   String b = getTagValue("RDNWHLADDR", eElement);
					   String c = getTagValue("SITEWHLADDR", eElement);
					   if((getTagValue("MGTNO", eElement).equals(pk))) {
						   bean.setStoreseq(getTagValue("MGTNO", eElement)); //기본키
						   bean.setCategory(getTagValue("UPTAENM", eElement)); //업태구분
						   bean.setName(getTagValue("BPLCNM", eElement)); //사업장명
						   bean.setAddress1(c); //지번주소
						   bean.setAddress2(b); //도로명주소
						   bean.setHp(getTagValue("SITETEL", eElement)); //전화번호
						   bean.setRemark(getTagValue("DTLSTATENM", eElement)); //상세영업상태명
					   }
					   
				   }   // for end
			   }   // if end
			   
			   a += 1;
			   System.out.println("page number : "+a);
			   if(a >1){   
				   break;
			   }
		   }   // while end
		   
	   } catch (Exception e){   
		   e.printStackTrace();
	   }   // try~catch end
	   return bean;
   }

   public List<Store> getlistbyCategory(String cate, String gu) {
	int a = 1;   // 페이지 초기값 
	   ArrayList<Store> eatlists = new ArrayList<Store>();
	      try{
	         while(true){
	            // parsing할 url 지정(API 키 포함해서)
	            String url = "http://openapi.seoul.go.kr:8088/5876546e6a6e6e6d313035734d716c50/xml/LOCALDATA_072404/"+a+"/"+(a*1000)+"/"+a;
	            
	            DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
	            DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
	            Document doc = dBuilder.parse(url);
	            
	            // root tag 
	            doc.getDocumentElement().normalize();
	            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	            
	            // 파싱할 tag
	            NodeList nList = doc.getElementsByTagName("row");
	            System.out.println("파싱할 리스트 수 : "+ nList.getLength());
	            
	            
	            for(int temp = 0; temp < nList.getLength(); temp++){
	               Node nNode = nList.item(temp);
	               if(nNode.getNodeType() == Node.ELEMENT_NODE){
	                  
	                  Element eElement = (Element) nNode;
//	                  System.out.println("######################");
	                  //System.out.println(eElement.getTextContent());
//	                  System.out.println("도로명주소  : " + getTagValue("RDNWHLADDR", eElement));
//	                  System.out.println("지번주소  : " + getTagValue("SITEWHLADDR", eElement));
	                  String b = getTagValue("RDNWHLADDR", eElement); //도로명주소
	                  String c = getTagValue("SITEWHLADDR", eElement); //지번주소
	                  String d = b+c; // 주소 합침
	                  if(d.contains(gu) && !(getTagValue("DTLSTATENM", eElement).equals("폐업"))
	                		  && getTagValue("UPTAENM", eElement).equals(cate) ) { //구가 같고 카테고리가 같으면 담는다.
	                	  Store bean = new Store();
	                	  bean.setStoreseq(getTagValue("MGTNO", eElement)); //기본키
	                	  bean.setCategory(getTagValue("UPTAENM", eElement)); //업태구분
	                	  bean.setName(getTagValue("BPLCNM", eElement)); //사업장명
	                	  bean.setAddress1(c); //지번주소
	                	  bean.setAddress2(b); //도로명주소
	                	  bean.setHp(getTagValue("SITETEL", eElement)); //전화번호
	                	  bean.setRemark(getTagValue("DTLSTATENM", eElement)); //상세영업상태명
	                	  
	                	  eatlists.add(bean);
	                  }
	             
	               }   // for end
	            }   // if end
	            
	            a += 1;
	            System.out.println("page number : "+a);
	            if(a >1){   
	               break;
	            }
	         }   // while end
	         
	      } catch (Exception e){   
	         e.printStackTrace();
	      }   // try~catch end
	      return eatlists;
}
}   // class end