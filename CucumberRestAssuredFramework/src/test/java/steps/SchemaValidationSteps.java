package steps;

import apiMethods.SchemaValidation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;

public class SchemaValidationSteps {

	@Given("Given I want to execute getUserList endpoint")
	public void given_i_want_to_execute_get_user_list_endpoint() {
		RestAssured.baseURI = "https://reqres.in/api"; 
	}

	@Then("i should validate the json schema for get endpoint")
	public void i_should_validate_the_json_schema_for_get_endpoint() {
		SchemaValidation.validateSchema();
	}
}
