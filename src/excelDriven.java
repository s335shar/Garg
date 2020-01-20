import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.PayLoad;
import Files.ReuseableMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class excelDriven {

	@Test(dataProvider = "BookData")
	public void LibraryAPI()
	{
		RestAssured.baseURI="http://216.10.245.166";
		
		Response res = given().header("Content-Type", "application/json").body(PayLoad.AddBook(isbn, aisle)).
				when().
			       get("/Library/Addbook.php").
			       then().assertThat().statusCode(200).and().extract().response();
				
				System.out.println(res);
				JsonPath js = ReuseableMethods.rawtoJson(res);
				String id = js.get("ID");
				System.out.println(id);
	}
	@DataProvider(name = "BookData")
	public Object[][] getData()
	{
		return new Object[][] {{"akhj","1234"},{"werf","3245"},{"qsdc","2345"}};
	}
}
