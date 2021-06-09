import java.io.*;

public class File_Writer {
	File file=new File("D:\\GIT_Project\\OpenSourceProject\\자료분석\\버스정류소좌표(1차가공).csv");
	void write(String code,String address) {
		try {
			FileOutputStream fos=new FileOutputStream(file,true);
			String data=code+","+address+"\r\n";
			byte[] content=data.getBytes();
			fos.write(content);
			fos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void writecsv(File file) {//2차 데이터 가공
		try {
File_Reader fr=new File_Reader();
			
			FileOutputStream fos=new FileOutputStream(file);
			String format="버스정류장ARS번호,역명,주소,아침,점심,오후,저녁\r\n";
			byte[] fo=format.getBytes();
			fos.write(fo);
			for(int i=0;i<fr.busdata.size();i++) {
				if(fr.busdata.get(i).address==null);
				else {
					String data=fr.busdata.get(i).Code+","+fr.busdata.get(i).Bus+","+
					fr.busdata.get(i).address+","+fr.busdata.get(i).morning+","+
					fr.busdata.get(i).lunch+","+fr.busdata.get(i).afternoon+","+fr.busdata.get(i).dinner+"\r\n";
					byte[] content=data.getBytes();
					fos.write(content);
				}
			}
			fos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void finbus(String data) {//3차 데이터 가공
		File file=new File("D:\\GIT_Project\\OpenSourceProject\\자료분석\\버스정류소좌표(3차가공).csv");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file,true);
			
			byte[] fo=data.getBytes();
			fos.write(fo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
