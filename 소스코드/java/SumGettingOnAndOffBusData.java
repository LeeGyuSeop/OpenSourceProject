
import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class SumGettingOnAndOffBusData {
    public static void main(String[] args){
        //��ȯ�� ����Ʈ
        BufferedReader br = null;
        int repeat=1;
        String result="";
        String compare="����2����Ÿ�";
        String compare2="1001";
        int[] cal=new int[24];
        
        try{
            br = Files.newBufferedReader(Paths.get("D:\\����ȭ��\\21�� �°��� �� ����.csv"));
            //Charset.forName("UTF-8");
            String line = "";
            line = br.readLine();
            result +=line+"\n";
            while((line = br.readLine()) != null){
                //CSV 1���� �����ϴ� ����Ʈ
                String array[] = line.split(",");
                //�迭 ����
                if(array[1].equals(compare)==false) {
                	result+=compare2+","+compare;
                	for(int j=0;j<24;j++) {result+=","+cal[j];}
                	result+="\n";
                	compare=array[1];compare2=array[0];
                	cal = new int[24];
                }
                for(int i=0;i<24;i++) {cal[i]+=Integer.parseInt(array[2*i+2])+Integer.parseInt(array[2*i+3]);}
            	
                repeat++;
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(br != null){
                    br.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        result+=compare2+","+compare;
    	for(int j=0;j<24;j++) {result+=","+cal[j];}
        result = result.replace("[","");
        result = result.replace("]","");
        System.out.println(result);
        
        String filePath = "D:\\����ȭ��\\Setting.txt";
        try {
         FileWriter fileWriter = new FileWriter(filePath);
         fileWriter.write(result);
         
         fileWriter.close();
        } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
        }
    }
}

