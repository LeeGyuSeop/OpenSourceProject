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
	String morning;
	String lunch;
	String afternoon;
	String dinner;
	int check=0;
	static ArrayList<Bus_Data>busdata=new ArrayList<Bus_Data>();
	void Station(File data,File code) {//1차가공데이터
		try 
		{ 
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(data),"UTF-8"));
		while((originalData=br.readLine())!=null) {
			if(check==0);
			else {
			String [] a=originalData.split(",");
			File_Reader fr=new File_Reader();
			
			fr.location(a[0], code);
			int m=0;
			int l=0;
			int af=0;
			int d=0;
			for(int i=9;i<14;i++) {
				m+=Integer.parseInt(a[i]);
			}
			for(int i=14;i<16;i++) {
				l+=Integer.parseInt(a[i]);
			}
			for(int i=16;i<21;i++) {
				af+=Integer.parseInt(a[i]);
			}
			for(int i=21;i<26;i++) {
				d+=Integer.parseInt(a[i]);
			}
			Bus_Data bd=new Bus_Data(a[0],a[1],fr.location,m,l,af,d);
			busdata.add(bd);
			}
			check++;
		}
		
		}catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException");
	}catch (Exception e) {
		e.printStackTrace(); 
	}
	}
	void location(String code,File data) {//코드-주소 데이터
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(data),"UTF-8"));
			while((originalData=br.readLine())!=null) {
				String [] a=originalData.split(",");
				int coint=Integer.parseInt(code);
				int fileint=Integer.parseInt(a[0]);
				if(coint==fileint) {
					location=a[1];
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	void Code(File data) {//좌표데이터
		int i=0;
		try 
		{ 
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(data),"EUC-KR"));
		while((originalData=br.readLine())!=null) {
			if(i==0);
			else {
			String [] a=originalData.split(",");
			code=a[1];
			x=a[3];
			y=a[4];
			//System.out.println(a[1]+" "+a[3]+" "+a[4]);
			GetAddress ga=new GetAddress();
			ga.getCoordination(a[1],a[3],a[4]);
			
			}
			i++;
		}
		}catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException");
	}catch (IOException e) {
		System.err.println("IOException"); 
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
}
