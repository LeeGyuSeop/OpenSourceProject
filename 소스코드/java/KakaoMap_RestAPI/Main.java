import java.io.File;

import org.apache.tomcat.util.json.JSONParser;

public class Main {
	static int count=0;
	static int count1=0;
	
	public static void main(String[] args) throws Exception {
		File data = new File("D:\\GIT_Project\\OpenSourceProject\\자료분석\\21년_버스노선(1차가공, 승하차인원및 역 합체).csv");
		File Codata=new File("D:\\GIT_Project\\OpenSourceProject\\자료분석\\서울시버스정류소좌표데이터(2021.01.14.).csv");
		File_Reader fr=new File_Reader();
		fr.Code(Codata);
		//System.out.println(fr.code);
		String []x=fr.x.split(",");
		String []y=fr.y.split(",");
		System.out.println(y[2]);
		//String []name=station.split(",");
		//GetAddress ga=new GetAddress();
		//ga.getCoordination();
	}
	
}
