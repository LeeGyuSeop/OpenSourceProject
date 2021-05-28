import java.io.*;
import java.util.ArrayList;
public class CSVWrite {
	String file="D:\\GIT_Project\\OpenSourceProject\\자료분석\\21년_상권정보(1차가공).csv";

	void write(ArrayList<SectorsCode> Codata) {
		DataList da=new DataList();
		try {
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"euc-kr"));
			for(int i=1;i<Codata.size();i++) {
				for(int j=0;j<25;j++) {//저장된 정보를 csv파일로 저장
					bw.write(da.dis[j]+","+Codata.get(i).Subclass+","+Codata.get(i).distCount[j]);
					bw.newLine();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
