import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class File_Reader {
	File data = new File("D:\\GIT_Project\\OpenSourceProject\\자료분석\\21년_상권정보(원시).csv");
	File CodeData=new File("D:\\GIT_Project\\OpenSourceProject\\자료분석\\상권업종코드.csv");
	String originalData;//상권정보데이터를 읽어들이는 String
	String originalCode;//업종코드를 읽어들이는 String

	static ArrayList<DataList> dataList=new ArrayList<DataList>();//각 가게의 정보 저장
	static ArrayList<SectorsCode> Codata=new ArrayList<SectorsCode>(); //업종 코드 저장
	void Reading(){
		try 
		{ 
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(CodeData),"UTF-8"));
			while((originalCode=br.readLine())!=null) {
				int check=0;
				SectorsCode sc=new SectorsCode();//
				sc.Reading(originalCode);
				String [] a=originalCode.split(",");
				for(int i=0;i<Codata.size();i++) {//소분류가 중복된다면 저장하지 않는다.
					if(a[4].equals(Codata.get(i).Subclass))
						check=1;
				}
				if(check==0)
					Codata.add(sc);
			}
			System.out.println("Complete");
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream(data),"UTF-8"));
			while((originalData = bufferedReader.readLine()) != null) {
				DataList createList = new DataList();
				createList.ShowList(originalData,Codata);
				dataList.add(createList); 

			}
			System.out.println("Complete");
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
