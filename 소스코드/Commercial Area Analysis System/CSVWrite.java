import java.io.*;
import java.util.ArrayList;
public class CSVWrite {
	String file="D:\\GIT_Project\\OpenSourceProject\\자료분석\\21년_상권정보(1차가공).csv";
	String [] dis= {"종로구","중구","용산구","성동구","광진구","동대문구","중랑구","성북구","강북구","도봉구",
			"노원구","은평구","서대문구","마포구","양천구","강서구","구로구","금천구","영등포구","동작구",
			"관악구","서초구","강남구","송파구","강동구"
	};
	void write(ArrayList<SectorsCode> Codata) {
		
		try {
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"euc-kr"));
			for(int i=1;i<Codata.size();i++) {
				for(int c1=0;c1<25;c1++) {
					bw.write(dis[c1]+","+Codata.get(i).Subclass+","+Codata.get(i).distCount[c1]);
					bw.newLine();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Complete");
	}
}
