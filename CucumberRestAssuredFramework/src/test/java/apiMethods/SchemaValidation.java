package apiMethods;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;;

public class SchemaValidation {
	
	
	public static void validateSchema() {
		
		
		given().get("https://reqres.in/api/users?page=2").
		then().assertThat().body(matchesJsonSchemaInClasspath("schema.json"));
		
	}
	

}
