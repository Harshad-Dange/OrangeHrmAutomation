package automateAPI;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class RestAPIAutomate {

	public static void main(String[] args) {
		
		//given - all input details that we give to API
		//when- Submit the API - resource and http method
		// then - we get response using this we can validate response over here
		
		
		// log()-- fetch the requested API info 
		// all()-- all API info

		RestAssured.baseURI= "https://gorest.co.in";
		String response=given().log().all().queryParam("page", "2").header("Connection","keep-alive")
		.when().get("public/v2/users")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("______________");
		System.out.println("response : \n\n "+response);
		
	}

}
