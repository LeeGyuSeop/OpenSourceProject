/*
 * 버스정류소 정제 프로그램
 * 개발자 : 박영우
 * 최초 작성일 :2021.06.04
 * 최종 수정일 :2021.06.10
 */
import java.io.File;

import org.apache.tomcat.util.json.JSONParser;

public class Main {
	public static void main(String[] args) throws Exception {
		File data = new File("D:\\GIT_Project\\OpenSourceProject\\자료분석\\21년_버스노선(1차가공, 승하차인원및 역 합체).csv");
		File Codata=new File("D:\\GIT_Project\\OpenSourceProject\\자료분석\\서울시버스정류소좌표데이터(2021.01.14.).csv");
		File ProCode = new File("D:\\GIT_Project\\OpenSourceProject\\자료분석\\버스정류소좌표(1차가공).csv");
		File busdata = new File("D:\\GIT_Project\\OpenSourceProject\\자료분석\\버스정류소(2차가공).csv");
		File_Reader fr=new File_Reader();
		//fr.Station(data,ProCode);//1차가공데이터 정리
		//File_Writer fw=new File_Writer();
		//fw.writecsv(busdata); //2차 데이터 작성
		fr.borough(busdata);//3차 데이터 작성
		//fr.Code(Codata);	//좌표로 주소 얻어오기
		System.out.println("Success");
	}
	
}
