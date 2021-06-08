import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class GetAddress {
	String getCoordination() throws Exception{
		Main m =new Main();
		String encodeAddress = "";  // �ѱ� �ּҴ� encoding �ؼ� ������ ��
		//try { encodeAddress = URLEncoder.encode( address, "UTF-8" ); } 
		//catch ( UnsupportedEncodingException e ) { e.printStackTrace(); }
		String apiUrl = "https://dapi.kakao.com/v2/local/geo/coord2address.json?x="+126.9877861534+"&y="+37.5697641508+"&input_coord=WGS84";
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
	    String stringLine;
	    jsonString=br.readLine();
	    /*while ( ( stringLine= br.readLine()) != null ) {
	        jsonString += stringLine;
	    }*/
	    System.out.println(jsonString);
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
	    return jsonString;
	    
	}
}
