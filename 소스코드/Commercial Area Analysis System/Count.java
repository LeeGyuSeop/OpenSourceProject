import java.util.*;

public class Count {

	int SecCou[]=new int[25];
	int SubcCou[]=new int[25];
	void cal(ArrayList<DataList> data,ArrayList<SectorsCode> Sector) {
		DataList da=new DataList();
		for(int i=1;i<data.size();i++) {
			for(int j=1;j<Sector.size();j++) {
				if(data.get(i).Subclass.equals(Sector.get(j).Subclass)) {
					//datalist의 분류와sectorscode의 분류가 같다면 가게의 수를 추가함
					for(int k=0;k<da.dis.length;k++) {//25개의 구를 넘버링해 저장함
						
						if(da.dis[k].equals(data.get(i).district))
							Sector.get(j).distCount[k]+=1;
					}
				}
					
			}
		}
	}
}
