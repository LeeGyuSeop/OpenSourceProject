import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class File_Reader {
	File data = new File("D:\\GIT_Project\\OpenSourceProject\\자료분석\\21년_상권정보(원시).csv");
	File CodeData=new File("D:\\GIT_Project\\OpenSourceProject\\자료분석\\상권업종코드.csv");
	String originalData;
	String fullData;
	String [] dis= {"종로구","중구","용산구","성동구","광진구","동대문구","중랑구","성북구","강북구","도봉구",
			"노원구","은평구","서대문구","마포구","양천구","강서구","구로구","금천구","영등포구","동작구",
			"관악구","서초구","강남구","송파구","강동구"
	};
	static ArrayList<DataList> dataList=new ArrayList<DataList>();
	static ArrayList<SectorsCode> Codata=new ArrayList<SectorsCode>(); 
	void Reading(){
		try 
		{ 
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(CodeData),"UTF-8"));
			while((fullData=br.readLine())!=null) {
				int check=0;
				SectorsCode sc=new SectorsCode();
				sc.Reading(fullData);
				String [] a=fullData.split(",");
				for(int i=0;i<Codata.size();i++) {
					if(a[4].equals(Codata.get(i).Subclass))
						check=1;
				}
				if(check==0)
					Codata.add(sc);
			}
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream(data),"UTF-8"));
			while((originalData = bufferedReader.readLine()) != null) {
				DataList createList = new DataList();
				createList.ShowList(originalData,Codata);
				dataList.add(createList); 

			}
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException"); 
		} catch (IOException e) {
			System.err.println("IOException"); 
		}
		Count c=new Count();
		c.cal(dataList, Codata);
		CSVWrite cw=new CSVWrite();
		cw.write(Codata);
		
	}
}
