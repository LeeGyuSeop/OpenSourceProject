import java.io.*;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject; // JSON객체 생성
import org.json.simple.parser.JSONParser; // JSON객체 파싱
import org.json.simple.parser.ParseException; // 예외처리
public class GetAddressKeyword {
	String miss;
	GetAddressKeyword(String miss){
		this.miss=miss;
	}
	String getCoordination(String address) throws Exception{
		Main m =new Main();
		String encodeAddress = "";  // �ѱ� �ּҴ� encoding �ؼ� ������ ��
		try { encodeAddress = URLEncoder.encode( address, "UTF-8" ); } 
		catch ( UnsupportedEncodingException e ) { e.printStackTrace(); }
		String apiUrl = "https://dapi.kakao.com/v2/local/search/keyword.json?query=" 
	                                                                     + encodeAddress;
		String auth = "KakaoAK " + "08f0ea1ef4bdc4c4e4e85d6b69cf4dfe";//api Ű
		
		URL url = new URL( apiUrl );
	    HttpsURLConnection conn = ( HttpsURLConnection ) url.openConnection();
		conn.setRequestMethod( "GET" );
	    conn.setRequestProperty( "Authorization", auth );
	    
	    BufferedReader br;

	    int responseCode = conn.getResponseCode();
	    if( responseCode == 200 ) {  // ȣ�� OK
	    	br = new BufferedReader( new InputStreamReader(conn.getInputStream(), "UTF-8") );
	    } else {  // ����
	    	br = new BufferedReader( new InputStreamReader(conn.getErrorStream(), "UTF-8") );
	    }
	    
	    String jsonString = new String();
	    String stringLine;
	    while ( ( stringLine= br.readLine()) != null ) {
	        jsonString += stringLine;
	    }
	    String []a=jsonString.split(":");
	     if(a[1].equals("[],\"meta\"")) {
	    	 m.count++;
	    	 System.out.println("gak : "+address);
	    	 miss=address+",";
	    	 return miss;
	     }
	    //System.out.println(jsonString);
	    /*try {
	    	Thread.sleep(1000);
	    }catch(Exception e) {
	    	
	    }*/
	    /*
	    JSONParser parser = new JSONParser();
	    JSONObject json = (JSONObject)parser.parse(jsonString); // String json을 파싱받은 뒤, JSONObject 형태로 저장함
	    JSONObject inf = (JSONObject)json.get("documents");
        
        String name=(String)inf.get("address_name");
        System.out.println(name);*/
	    return null;
	    
	}
}
