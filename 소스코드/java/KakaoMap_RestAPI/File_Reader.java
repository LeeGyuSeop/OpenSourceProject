import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class File_Reader {
	String originalData;
	String station;
	String code;
	String x;
	String y;
	String location;
	int check = 0;
	static ArrayList<Bus_Data>busdata = new ArrayList<Bus_Data>();
	String [] dis = {"종로구","중구","용산구","성동구","광진구","동대문구","중랑구","성북구","강북구","도봉구",
			"노원구","은평구","서대문구","마포구","양천구","강서구","구로구","금천구","영등포구","동작구",
			"관악구","서초구","강남구","송파구","강동구"
	};
	String []district = new String[26];
	
	public static boolean isnum(String s) {
		try {
			Double.parseDouble(s);
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}
	void Station(File data, File code) {//1차가공데이터
		try { 
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(data), "UTF-8"));
			while((originalData = br.readLine()) != null) {
				String [] a = originalData.split(",");
				File_Reader fr = new File_Reader();
				if(isnum(a[0])) {	
					fr.location(a[0], code);
					int m = 0;
					int l = 0;
					int af = 0;
					int d = 0;
					for(int i = 9; i < 14; i++) {
						m+=Integer.parseInt(a[i]);
					}
					for(int i = 14; i < 16; i++) {
						l += Integer.parseInt(a[i]);
					}
					for(int i = 16; i < 21; i++) {
						af += Integer.parseInt(a[i]);
					}
					for(int i = 21; i < 26; i++) {
						d += Integer.parseInt(a[i]);
					}
					Bus_Data bd = new Bus_Data(a[0], a[1], fr.location, m, l, af, d);
					busdata.add(bd);
				}
			}
		}catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException");
		}catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
	void location(String code, File data) {//코드-주소 데이터
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(data), "UTF-8"));
			while((originalData = br.readLine()) != null) {
				String [] a = originalData.split(",");
				int coint = Integer.parseInt(code);
				int fileint = Integer.parseInt(a[0]);
				if(coint == fileint) {
					location = a[1];
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	void Code(File data) {//좌표데이터
		try { 
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(data), "EUC-KR"));
			originalData = br.readLine();
			while((originalData = br.readLine()) != null) {
				String [] a = originalData.split(",");
				code = a[1];
				x = a[3];
				y = a[4];
				GetAddress ga = new GetAddress();
				ga.getCoordination(a[1], a[3], a[4]);
			}
		}catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException");
		}catch (IOException e) {
			System.err.println("IOException"); 
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void borough(File file) {//2차 데이터를 불러와 3차 데이터 작성
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			originalData = br.readLine();
			int[] morning = new int[25];
			int[] lunch = new int[25];
			int[] afternoon = new int[25];
			int[] dinner = new int[25];
			while((originalData = br.readLine()) != null) {
				 String []data = originalData.split(",");
				 for(int i = 0; i < dis.length; i++) {
					 if(dis[i].equals(data[2])) {
						 morning[i] += Integer.parseInt(data[3]);
						 lunch[i] += Integer.parseInt(data[4]);
						 afternoon[i] += Integer.parseInt(data[5]);
						 dinner[i] += Integer.parseInt(data[6]);
					 }
				 }
			}
			File_Writer fw = new File_Writer();
			district[0] = "주소,아침,점심,오후,저녁\r\n";
			fw.finbus(district[0]);
			for(int i = 1; i < district.length - 1; i++) {
				district[i] = dis[i] + "," + morning[i] + "," + lunch[i] + "," + afternoon[i] + "," + dinner[i] + "\r\n";
				fw.finbus(district[i]);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
