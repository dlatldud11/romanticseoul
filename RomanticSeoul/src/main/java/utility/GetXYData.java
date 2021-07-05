package utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;



public class GetXYData{
//	public static void main(String[] args) {
//		Map<String,Object> answer = addToCoord("서울 동대문구 서울시립대로29길 45");
//		System.out.println(answer);
//		
//	}
	
	public static Map<String,Object> addToCoord(String add){

		String url = "https://dapi.kakao.com/v2/local/search/address.json?page=1&size=10&query=";
		Map<String,Object> addr = new HashMap<String,Object>();
		try{
			String address = URLEncoder.encode(add, "UTF-8");
			addr = getRegionAddress(getJSONData(url+address));
		}catch(Exception e){
			e.printStackTrace();
		}
		return addr;
	}
	private static String getJSONData(String apiUrl) throws Exception {
        String jsonString = new String();
        String buf;
        URL url = new URL(apiUrl);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        String auth = "KakaoAK "+"53236e461131e490cbc76f5734eed8b3";
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", auth);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(
                conn.getInputStream(), "UTF-8"));
        while ((buf = br.readLine()) != null) {
            jsonString += buf;
        }
        return jsonString;
    }
	private static Map<String,Object> getRegionAddress(String jsonString) {
        Map<String,Object> value = new HashMap<String,Object>();
        JSONObject jObj = (JSONObject) JSONValue.parse(jsonString);
        JSONObject meta = (JSONObject) jObj.get("meta");
        long size = (long) meta.get("total_count");
        if(size>0){
            JSONArray jArray = (JSONArray) jObj.get("documents");
            JSONObject subJobj = (JSONObject) jArray.get(0);
            value.put("x", subJobj.get("x"));
            value.put("y", subJobj.get("y"));
            
//            if(value.equals("") || value==null){
//                subJobj = (JSONObject) jArray.get(1);
//                subJobj = (JSONObject) subJobj.get("address");
//                value =(String) subJobj.get("address_name");    
//            }
        }
        return value;
    }
}
