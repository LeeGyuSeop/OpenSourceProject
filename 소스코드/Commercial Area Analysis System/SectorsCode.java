import java.io.*;
import java.util.*;
public class SectorsCode {
	String Sectors;
	String Subclass;
	int distCount[]=new int[25];
	void Reading(String Data){
		StringTokenizer st=new StringTokenizer(Data,",");
		while(st.hasMoreTokens()) {
			for(int i=0;i<7;i++) {
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
