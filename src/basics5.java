import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import Files.ReuseableMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

public class basics5 {

	@Test
	public void getData()
	{
		RestAssured.baseURI="http://216.10.245.166";
		
		Response res = given().
	       param("location","-33.8670522,151.1957362").
	       param("radius","1500").
	       param("key","qaclick123").
	       when().
	       get("/maps/api/place/nearbysearch/json").
	       then().assertThat().statusCode(404).and().contentType(ContentType.JSON).and().body("results[0].name", equalTo("Sydney")).and().
	       body("results[0].place_id",equalTo("d7ec4237e0885f99255c27b0e0477bba")).and().header("server", "Apache").extract().response();
		
		System.out.println(res);
		JsonPath js = ReuseableMethods.rawtoJson(res);
		int count = js.get("results.size()");
		
		for(int i =0; i<count; i++)
		{
			
		}
	}
}
