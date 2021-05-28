import java.util.*;

public class Count {
	String [] dis= {"종로구","중구","용산구","성동구","광진구","동대문구","중랑구","성북구","강북구","도봉구",
			"노원구","은평구","서대문구","마포구","양천구","강서구","구로구","금천구","영등포구","동작구",
			"관악구","서초구","강남구","송파구","강동구"
	};
	int SecCou[]=new int[25];
	int SubcCou[]=new int[25];
	void cal(ArrayList<DataList> data,ArrayList<SectorsCode> Sector) {
		for(int i=1;i<data.size();i++) {
			for(int j=1;j<Sector.size();j++) {
				if(data.get(i).Subclass.equals(Sector.get(j).Subclass)) { 
					for(int k=0;k<dis.length;k++) {
						if(dis[k].equals(data.get(i).district))
							Sector.get(j).distCount[k]+=1;
					}
				}
					
			}
		}
	}
}
