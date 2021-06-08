import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class File_Reader {
	String originalData;
	String station;
	String code;
	String x;
	String y;
	void Station(File data) {
		try 
		{ 
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(data),"EUC-KR"));
		while((originalData=br.readLine())!=null) {
			String [] a=originalData.split(",");
			station+=a[1]+",";
		}
		}catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException");
	}catch (IOException e) {
		System.err.println("IOException"); 
	}
	}
	void Code(File data) {
		try 
		{ 
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(data),"EUC-KR"));
		while((originalData=br.readLine())!=null) {
			String [] a=originalData.split(",");
			code+=a[1]+",";
			x+=a[3]+",";
			y+=a[4]+",";
		}
		}catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException");
	}catch (IOException e) {
		System.err.println("IOException"); 
	}
	}
}
