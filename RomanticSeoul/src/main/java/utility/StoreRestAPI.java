package utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StoreRestAPI {
	
	public static void main(String[] args) {
		JSONObject result = action();
	}
	
	private static StoreRestAPI instance = null;
	
	public static StoreRestAPI getInstance() {
		if (instance == null) {
			instance = new StoreRestAPI();
		}
		return instance;
	}
	
	
	// POST /action
	//	X-Auth-Token: {Token}
	//	Content-Type: application/json
	public static JSONObject action() {
		HttpURLConnection conn = null;
		JSONObject responseJson = null;
		
		try {
			
			URL url = new URL("https://dapi.kakao.com/v2/local/search/address.json");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Host", "dapi.kakao.com");
			conn.setRequestProperty("Authorization", "KakaoAK {53236e461131e490cbc76f5734eed8b3}");
			conn.setRequestProperty("query", "전북 삼성동 100");
			conn.setDoOutput(true);
//			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
//			JSONObject commands = new JSONObject();
//			commands.put("query", "전북 삼성동 100");
//			bw.write(commands.toString());
//			bw.flush();
//			bw.close();
			
			int responseCode = conn.getResponseCode();
			if (responseCode == 400) {
				System.out.println("400:: 해당 명령을 실행할 수 없음 (실행할 수 없는 상태일 때, 엘리베이터 수와 Command 수가 일치하지 않을 때, 엘리베이터 정원을 초과하여 태울 때)");
			} else if (responseCode == 401) {
				System.out.println("401:: X-Auth-Token Header가 잘못됨");
			} else if (responseCode == 500) {
				System.out.println("500:: 서버 에러, 문의 필요");
			} else { // 성공
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				StringBuilder sb = new StringBuilder();
				String line = "";
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				
				responseJson = new JSONObject(sb.toString());
				
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			System.out.println("not JSON Format response");
			e.printStackTrace();
		}
		return responseJson;
	}
		
	
	
	// GET /oncalls
	//	X-Auth-Token: {Token}
	public JSONObject onCalls() {
		HttpURLConnection conn = null;
		JSONObject responseJson = null;
		
		try {
			URL url = new URL(GlobalData.HOST_URL + GlobalData.GET_ONCALLS);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("X-Auth-Token", TokenManger.getInstance().getToken());
			
			int responseCode = conn.getResponseCode();
			if (responseCode == 401) {
				System.out.println("401:: X-Auth-Token Header가 잘못됨");
			} else if (responseCode == 500) {
				System.out.println("500:: 서버 에러, 문의 필요");
			} else { // 성공
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				StringBuilder sb = new StringBuilder();
				String line = "";
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				
				responseJson = new JSONObject(sb.toString());
				
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			System.out.println("not JSON Format response");
			e.printStackTrace();
		}
		return responseJson;
	}
	
	
	
	// POST /start/{user_key}/{problem_id}/{number_of_elevators}
	public String start(String userKey, int problemId, int numOfElevators) {
		HttpURLConnection conn = null;
		JSONObject responseJson = null;
		String response = null;
		String startParams = "/" + userKey + "/" + Integer.toString(problemId) + "/" + Integer.toString(numOfElevators);
		
		try {
			URL url = new URL(GlobalData.HOST_URL + GlobalData.POST_START + startParams);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			
			int responseCode = conn.getResponseCode();
			if (responseCode == 200) { // 성공
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				StringBuilder sb = new StringBuilder();
				String line = "";
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				
				responseJson = new JSONObject(sb.toString());
				response = responseJson.getString("token");
			} else {
				response = String.valueOf(responseCode);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			System.out.println("not JSON Format response");
			e.printStackTrace();
		}
		
		return response;
	}
	
	
}