package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import apiMethods.APIMethods;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIvalidationStepDefs {

	APIMethods methods = new APIMethods();

	@Given("I want to execute getUserList endpoint")
	public void i_want_to_execute_get_user_list_endpoint() {
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "api/users?page=2";
	}

	@When("I submit the GET request")
	public void i_submit_the_get_request() {
		methods.getUserDetails();
	}

	@When("i submit the GET request for invalid user")
	public void i_submit_the_get_request_for_invalid_user() {
		methods.getInvalidUserDetails();
	}

	@Then("I should get {int} success status code")
	public void i_should_get_success_status_code(int statusCode) {
		Response response = methods.getUserDetails();
		Assert.assertEquals(response.getStatusCode(), statusCode);

		Assert.assertTrue(response.asString().contains("Janet"));
	}

	@Then("I should get {int} success status code for invalid user")
	public void i_should_get_success_status_code_for_invalid_user(int statusCode) {
		Response response = methods.getInvalidUserDetails();
		Assert.assertEquals(response.getStatusCode(), statusCode);
	}

	@Given("I want to execute createUser endpoint")
	public void i_want_to_execute_create_user_endpoint() {
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api/login";
	}

	@When("i submit the POST request for create user")
	public void i_submit_the_post_request_for_create_user() {
		methods.postUserDetails();
	}

	@Then("I should get {int} success status code along with the response body")
	public void i_should_get_success_status_code_along_with_the_response_body(int statusCode) {
		Response response = methods.postUserDetails();
		Assert.assertEquals(response.getStatusCode(), statusCode);
	}

	@When("i submit the POST request for create user with only email")
	public void i_submit_the_post_request_for_create_user_with_only_email() {

		methods.postUserEmailOnly();
	}

	@Then("I should get {int} error status code along with the response body")
	public void i_should_get_error_status_code_along_with_the_response_body(int statusCode) {
		Response response = methods.postUserEmailOnly();
		Assert.assertEquals(response.getStatusCode(), statusCode);
	}

	@When("i submit the PUT request to update user")
	public void i_submit_the_put_request_to_update_user() {
		methods.putUserDetails();
	}

	@Then("I should get {int} success status code in the put response")
	public void i_should_get_success_status_code_in_the_put_response(int statusCode) {
		Response response = methods.putUserDetails();

		Assert.assertEquals(response.getStatusCode(), statusCode);
	}

	@Given("I want to delete createUser endpoint")
	public void i_want_to_delete_create_user_endpoint() {

	}

	@When("i submit the Delete request")
	public void i_submit_the_delete_request() {
		methods.deleteUser();
	}

	@Then("I should get {int} success status code in the delete response")
	public void i_should_get_success_status_code_in_the_delete_response(int statusCode) {
		Response response = methods.deleteUser();
		Assert.assertEquals(response.getStatusCode(), statusCode);
	}

}
