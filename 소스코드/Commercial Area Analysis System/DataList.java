import java.util.*;

public class DataList {
	String district;
	String Sectors;
	String Subclass;
	String [] dis= {"종로구","중구","용산구","성동구","광진구","동대문구","중랑구","성북구","강북구","도봉구",
			"노원구","은평구","서대문구","마포구","양천구","강서구","구로구","금천구","영등포구","동작구",
			"관악구","서초구","강남구","송파구","강동구"
	};
void ShowList(String originalData,ArrayList<SectorsCode> Codata){
	StringTokenizer st=new StringTokenizer(originalData,"|");
	while(st.hasMoreTokens()) {
		String token=st.nextToken();

		for(int i=0;i<Codata.size();i++) {//분류를 저장
		if(token.equals(Codata.get(i).Sectors))
			Sectors=token;//token과 분류와 같다면 저장
		else if(token.equals(Codata.get(i).Subclass))
				Subclass=token;//token과 소분류와 같다면 저장
		}
		for(int j=0;j<dis.length;j++) {//주소를 저장
			if(token.equals(dis[j])) {
				district=dis[j];
			}
		}
	}
	}

}
