import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import Files.resources;
import Files.PayLoad;
import Files.ReuseableMethods;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class basics6 {
	
	
	
	public static void main(String[] args) throws IOException 
	{
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\s335shar\\eclipse-workspace\\DemoRestAPI\\src\\Files\\env.properties");
		prop.load(fis);
		
		RestAssured.baseURI=prop.getProperty("JIRAHOST");
		Response res = given().header("Content-Type","application/json").body("{ \"username\": \"sumeetgarg04\", \"password\": \"Jaishreeram@123\" }").
		when().
		post(resources.JiraPostData()).then().statusCode(200).extract().response();
		
		JsonPath js = ReuseableMethods.rawtoJson(res);
		String sessionID = js.get("session.value");
		System.out.println(sessionID);
	}

}
