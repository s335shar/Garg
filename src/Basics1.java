import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class Basics1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="http://216.10.245.166";
		
		given().
		       param("location","-33.8670522,151.1957362").
		       param("radius","1500").
		       param("key","AIzaSyD5FYD3ORhHgf-qAsRaxL_74ykGDD8DvOA").
		       when().
		       get("/maps/api/place/nearbysearch/json").
		       then().assertThat().statusCode(404).and().contentType(ContentType.HTML);

	}

}
