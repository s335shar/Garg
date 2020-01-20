package Files;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ReuseableMethods {

	public static XmlPath rawtoXML(Response r)
	{
		String response = r.asString();
		XmlPath x = new XmlPath(response);
		return x;
		
	}
	public static JsonPath rawtoJson(Response r)
	{
		String response = r.asString();
		JsonPath x = new JsonPath(response);
		return x;
		
	}
	
	public static String sessionKeyID()
	{
		RestAssured.baseURI="http://localhost:8080";
		Response res = given().header("Content-Type","application/json").body("{ \"username\": \"sumeetgarg04\", \"password\": \"Jaishreeram@123\" }").
		when().
		post(resources.JiraPostData()).then().statusCode(200).extract().response();
		
		JsonPath js = ReuseableMethods.rawtoJson(res);
		String sessionID = js.get("session.value");
		
		return sessionID;
	}
	
	public static String CommentKeyID()
	{
		RestAssured.baseURI="http://localhost:8080";
		Response res = given().header("Content-Type","application/json").body("{ \"username\": \"sumeetgarg04\", \"password\": \"Jaishreeram@123\" }").
		when().
		post(resources.JiraPostData()).then().statusCode(200).extract().response();
		
		JsonPath js = ReuseableMethods.rawtoJson(res);
		String CommentID = js.get(".id");
		
		return CommentID;
	}
}
