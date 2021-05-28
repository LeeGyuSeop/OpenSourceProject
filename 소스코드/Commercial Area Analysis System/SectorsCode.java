import java.io.*;
import java.util.*;
public class SectorsCode {
	String Sectors;
	String Subclass;
	int distCount[]=new int[25];
	void Reading(String Data){
		StringTokenizer st=new StringTokenizer(Data,",");
		while(st.hasMoreTokens()) {
			for(int i=0;i<7;i++) {//업종코드csv파일의 2번째와 4번째에 원하는 정보가 들어있다.
				if(i==2)
					Sectors=st.nextToken();
				else if(i==4) {
					Subclass=st.nextToken();
				}
				else st.nextToken();
			}
		}
	}
}
