// 오픈소스 프로젝트 데이터 분류 시스템
// 개발자 : Jeong Won Woo
// 최초 작성일 : 2021 . 05 . 17
// 최종 수정일 : 2021 . 05 . 18

import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Scanner;

public class ClassifySystem {

	private static ArrayList<DataList> dataList = new ArrayList<DataList>(); // 데이터 리스트
	
	public static void main(String[] args) {
		
		// 파일을 절대경로로 지정했는데 상대경로로 하니까 실행이 안되는 현상 발생
		
		File data = new File("C:\\Users\\ok\\Documents\\OpenSourceProject\\자치구별 지하철역 승하차.csv"); // 파일 경로 지정
		String originalData; // 파일에서 가져올 원본 데이터
		String commend; // 명령어
		String sellectcommend; // 세부 명령
		int sellectTime; // 시간대 선택
		
		try {
			FileReader fileReader = new FileReader(data);
			BufferedReader bufferedReader = new BufferedReader(fileReader); // 파일 가져오기
			
			while((originalData = bufferedReader.readLine()) != null) {
				DataList createList = new DataList(originalData);
				dataList.add(createList); // 리스트에 추가
			}
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException"); // 파일을 찾을 수 없을경우
		} catch (IOException e) {
			System.err.println("IOException"); // 입출력 예외가 발생 할 경우
		}
		while(true) {
			System.out.print("Enter commend : ");
			Scanner scanner = new Scanner(System.in); // 명령어 입력
			commend = scanner.nextLine();
			StringTokenizer stringTokenizer = new StringTokenizer(commend,"_");
			if(stringTokenizer.nextToken().equals("#get")) {
				sellectcommend = stringTokenizer.nextToken(); // 세부명령
				sellectTime = Integer.parseInt(stringTokenizer.nextToken()) - 6; // 시간대 선택 ( 리스트의 인덱스를 고려해 구간 시작 시간을 기준으로 -6 적용 )
				rideAndQuitCommend(sellectcommend,sellectTime); // 결과값 출력
			}
			else if(commend.equals("#exit")) {
				System.out.println("System Exit");
				break;
			}
		}
	}
	
	public static void rideAndQuitCommend(String sellect, int dataIndex) {
		int listIndex = 0; // 리스트 인덱스 초기값 0
		
		while(listIndex < dataList.size()) { // 리스트의 크기까지 루프
			System.out.print(dataList.get(listIndex).date + "/" + dataList.get(listIndex).district + "/" + dataList.get(listIndex).station + 
					"/");
			if(sellect.equals("ride")) System.out.println(dataList.get(listIndex).ride.get(dataIndex));
			else if(sellect.equals("quit")) System.out.println(dataList.get(listIndex).quit.get(dataIndex));
			listIndex++;
		}
	}
}
class DataList {
	
	// 데이터 필드
	String date; // 날짜
	String line; // 노선
	String district; // 자치구
	String station; // 역명
	
	ArrayList<String> ride = new ArrayList<String>(); // 승차량
	ArrayList<String> quit = new ArrayList<String>(); // 하차량
	
	DataList(String originalData){
		dataExtraction(originalData);
	}
	
	public void dataExtraction(String originalData){

		StringTokenizer stringTokenizer = new StringTokenizer(originalData,","); // csv파일을 가져와 라인별로 읽으면서 ,로 분할
		
		date = stringTokenizer.nextToken(); // 날짜 저장
		line = stringTokenizer.nextToken(); // 노선 저장
		district = stringTokenizer.nextToken(); // 자치구 저장
		station = stringTokenizer.nextToken(); // 역명 저장
		while(stringTokenizer.hasMoreTokens()) { // 더이상 가져올 토큰이 있을경우 루프
			ride.add(stringTokenizer.nextToken()); // 승차량 리스트에 추가
			if(!stringTokenizer.hasMoreTokens()) break; // 더이상 가져올 토큰이 없을경우 루프 아웃
			quit.add(stringTokenizer.nextToken()); // 하차량 리스트에 추가
		}			
	}
}