import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import Files.resources;
import Files.PayLoad;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Basics3 {

	Properties prop = new Properties();
	
	@BeforeTest
	public void getData() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\s335shar\\eclipse-workspace\\DemoRestAPI\\src\\Files\\env.properties");
		prop.load(fis);
	}
	
	
	
	@Test
	public void DeleteData() {
		// TODO Auto-generated method stub
		RestAssured.baseURI=prop.getProperty("HOST");
		 
		Response res = given().
		     queryParam("key",prop.getProperty("key")).
		     body(PayLoad.geBodyData()).
		     when().
		     post(resources.getPostData()).
		     then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("status", equalTo("OK")).extract().response();
		String responseString = res.asString();
		
		System.out.println(responseString);
		
		JsonPath js = new JsonPath(responseString);
		String PlaceID = js.get("place_id");
		
		System.out.println(PlaceID);
		
		given().queryParam("key","qaclick123").body("{" + 
				"\"place_id\":\""+PlaceID+"\""+ 
				"}"  
				).when().post("/maps/api/place/delete/json").then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("status", equalTo("OK"));
				
	}

	}


