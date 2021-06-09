import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GetAddress {
	String getCoordination(String code,String x,String y) throws Exception{
		String encodeAddress = "";  
		//try { encodeAddress = URLEncoder.encode( address, "UTF-8" ); } 	//주소검색시 인코딩
		//catch ( UnsupportedEncodingException e ) { e.printStackTrace(); }
		String apiUrl = "https://dapi.kakao.com/v2/local/geo/coord2address.json?x="+x+"&y="+y+"&input_coord=WGS84";
		String auth = "KakaoAK " + "08f0ea1ef4bdc4c4e4e85d6b69cf4dfe";//api Ű
		
		URL url = new URL( apiUrl );
	    HttpsURLConnection conn = ( HttpsURLConnection ) url.openConnection();
		conn.setRequestMethod( "GET" );
		conn.setRequestProperty("X-Requested-With", "curl");
	    conn.setRequestProperty( "Authorization", auth );
	    
	    BufferedReader br;

	    int responseCode = conn.getResponseCode();
	    if( responseCode == 200 ) {  // ȣ�� OK
	    	br = new BufferedReader( new InputStreamReader(conn.getInputStream(), "UTF-8") );
	    } else {  // ����
	    	br = new BufferedReader( new InputStreamReader(conn.getErrorStream(), "UTF-8") );
	    }
	    String jsonString = new String();
	    try {
	    
	    jsonString=br.readLine();
	    //json 데이터 자치구 파싱
	    JSONParser jsonParse=new JSONParser();
		JSONObject jsonObj=(JSONObject)jsonParse.parse(jsonString);
		JSONArray personArray=(JSONArray)jsonObj.get("documents");
		JSONObject personObject=(JSONObject)personArray.get(0);
		JSONObject address=(JSONObject)personObject.get("address");
		
		String depth=(String)address.get("region_2depth_name");
		//System.out.println(depth+" : "+code);
		File_Writer fw=new File_Writer();
		fw.write(code,depth);
	    }catch(Exception e) {
	    	System.out.println(jsonString);
	    	e.printStackTrace();
	    }
	    
	    return jsonString;
	    
	}
}
