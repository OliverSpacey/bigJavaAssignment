package businessLogicLayer;

public class Address {
	
	public static char[] toCharArrayCustom(String str){
  
        char[] chars = new char[str.length()];
  
        for (int i = 0; i < str.length(); i++) {
        	chars[i] = str.toCharArray()[i];
        }
  
        return chars;
    }
	
	
	
	public int houseNum;
	public String streetName;
	public String cityName;
	public String postcode;
	
	public Address(String[] addressArray) {
		houseNum = Integer.parseInt(addressArray[0]);
		streetName = addressArray[1];
		cityName = addressArray[2];
		postcode = addressArray[3];
		
	}
	
}
