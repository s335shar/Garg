package Files;

public class PayLoad {
	
	public static String geBodyData()
	{
		String b= "{\r\n" + 
	     		"\r\n" + 
	     		"    \"location\":{\r\n" + 
	     		"\r\n" + 
	     		"        \"lat\" : -38.383494,\r\n" + 
	     		"\r\n" + 
	     		"        \"lng\" : 33.427362\r\n" + 
	     		"\r\n" + 
	     		"    },\r\n" + 
	     		"\r\n" + 
	     		"    \"accuracy\":50,\r\n" + 
	     		"\r\n" + 
	     		"    \"name\":\"Frontline house\",\r\n" + 
	     		"\r\n" + 
	     		"    \"phone_number\":\"(+91) 983 893 3937\",\r\n" + 
	     		"\r\n" + 
	     		"    \"address\" : \"29, side layout, cohen 09\",\r\n" + 
	     		"\r\n" + 
	     		"    \"types\": [\"shoe park\",\"shop\"],\r\n" + 
	     		"\r\n" + 
	     		"    \"website\" : \"http://google.com\",\r\n" + 
	     		"\r\n" + 
	     		"    \"language\" : \"French-IN\"\r\n" + 
	     		"\r\n" + 
	     		"}";
		return b;
	}
	public static String AddBook(String isbn, String aisle)
	{
		String c = "{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
				"\"isbn\":\""+isbn
				+ "\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}";
		return c;
	}
	

}
