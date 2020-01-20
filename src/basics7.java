import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Files.ReuseableMethods;
import Files.resources;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class basics7 {
	Properties prop = new Properties();
	@BeforeTest
	public void getData() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\s335shar\\eclipse-workspace\\DemoRestAPI\\src\\Files\\env.properties");
		prop.load(fis);
	}
	
	@Test
	public void JiraAPI()
	{
		RestAssured.baseURI="http://localhost:8080";
		Response res = given().header("Content-Type","application/json").header("cookie","JSESSIONID"+ReuseableMethods.sessionKeyID()).
				body("{\r\n" + 
						"	\"fields\":{\r\n" + 
						"		\"project\":\r\n" + 
						"			{\r\n" + 
						"				\"key\":\"RES\"\r\n" + 
						"			},\r\n" + 
						"			\"summary\":\"Credit Card defect\",\r\n" + 
						"			\r\n" + 
						"			\"issuetype\":{\r\n" + 
						"				\"name\":\"Bug\"\r\n" + 
						"			}\r\n" + 
						"		}\r\n" + 
						"	}").when().post("/rest/api/2/issue").then().statusCode(201).extract().response();
		
		JsonPath js = ReuseableMethods.rawtoJson(res);
		String id = js.get("ID");
		System.out.println(id);
				
	}


}
