
public class Bus_Data {
    String Code;
    String Bus;
    String morning;
    String lunch;
    String afternoon;
    String dinner;
    String address;
	
    Bus_Data(String Code, String Bus, String address,
			int morning, int lunch, int afternoon,
			int dinner){
	this.Code = Code;
	this.Bus = Bus;
	this.address = address;
	this.morning = String.valueOf(morning);
	this.lunch = String.valueOf(lunch);
	this.afternoon = String.valueOf(afternoon);
        this.dinner = String.valueOf(dinner);
    }
}
