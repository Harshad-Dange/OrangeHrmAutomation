package automateAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import static  org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

import java.io.InputStream;

public class CreateUserUsingPost {
	
	public static String addUser()
	{
		
		String s= "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//then().extract().asPrettyString()-- method return string value  in pretty format
		//then().log().all()-- method returns ValidatableResponse 
		//then().extract().response().asString() -- return response in string 
		
		RestAssured.baseURI= "https://reqres.in";
		
		
		  String response= given().log().all() .body(addUser())
		  .when().post("api/users") 
		  .then().log().all()
		  .assertThat().statusCode(201).header("Server","cloudflare")
		  .extract().response().asString();
		  System.out.println("-------------");
		  
		  System.out.println("response : -->\n "+response+"\n\n");
		  
		  
		  
		  JsonPath js = new JsonPath(response);
		  System.out.println("id value--->  "+js.getString("id"));
		  System.out.println("created date--->  "+ js.getString("createdAt"));
		 
		System.out.println("\n\n\n\n *************");
		
		/*
		 * String s= given().log().all().body(addUser()).when().post("api/users")
		 * .then().log().all().extract().response().asString();
		 * 
		 * JsonPath js1 = new JsonPath(s);
		 * System.out.println("Server: "+js1.getString("Server"));
		 */
	
	}

}	
