import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Files.ReuseableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class basics8 {

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
						"    \"body\": \"Hi, These are my comments on this issue.\",\r\n" + 
						"    \"visibility\": {\r\n" + 
						"        \"type\": \"role\",\r\n" + 
						"        \"value\": \"Administrators\"\r\n" + 
						"    }\r\n" + 
						"}").when().post("/rest/api/2/issue/+ReuseableMethods.CommentID()/comment").then().statusCode(201).extract().response();
		
		JsonPath js = ReuseableMethods.rawtoJson(res);
		String id = js.get("ID");
		System.out.println(id);
				
	}
}
