package services;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import org.hamcrest.Matchers;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class QATeamAPITest {
	
	final static String ROOT_URI = "https://petstore.swagger.io/v2/pet";
	final static String STORE_ROOT_URI = "https://petstore.swagger.io/v2/store/order";
	
public void verifyGetPet(int id) throws Exception {
		
		String URI = ROOT_URI+"/"+id;
		
		Response response = get(URI);
		response.then()
	      		.assertThat()
	      		.statusCode(200)
	      		.body("id", Matchers.is(id));
		
		System.out.println("ID : "+response.asString());
		response.then().body("id", Matchers.is(id));
				
	}

public void verifyCreatePet(int id, String categoryId, String categoryName, String name, String photoURL, String tagId, String tagName) {
	
	Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body("{\"id\":"+id+",\"category\":{\"id\":"+categoryId+",\"name\":\""+categoryName+"\"},\"name\": \""+name+"\",\"photoUrls\":[\""+photoURL+"\"],\"tags\":[{\"id\":"+tagId+",\"name\": \""+tagName+"\"}],\"status\":\"available\"}")
			.when()
			.post(ROOT_URI);
	
	System.out.println("POST Response\n" + response.asString());
	
	response.then().body("id", Matchers.is(id));
}

public void verifyGetStore(int id) throws Exception {
	
	String URI = STORE_ROOT_URI+"/"+id;
	
	Response response = get(URI);
	response.then()
      		.assertThat()
      		.statusCode(200)
      		.body("id", Matchers.is(id));
	
	System.out.println("ID : "+response.asString());
	response.then().body("id", Matchers.is(id));
			
}

}

