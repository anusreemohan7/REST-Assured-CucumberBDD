package apiMethods;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;

import config.URLsFile;
import io.restassured.response.Response;
import java.util.HashMap;

public class APIMethods extends URLsFile {

	URLsFile endpoints = new URLsFile();

	String tempBaseURI = "https://httpbin.test.k6.io/";

	// TODO Auto-generated constructor stub
	private static Logger logger = LogManager.getLogger(APIMethods.class);

	public Response getUserDetails() {
		Response userResponse = when().get(baseURI + endpoints.getUser()).then().using().extract().response();
		logger.info("Response received");
		return userResponse;
	}

	public Response getInvalidUserDetails() {
		Response userResponse = when().get(baseURI + endpoints.getInvalidUser()).then().using().extract().response();
		logger.info("Response received for invalid user");
		return userResponse;
	}

	public Response postUserDetails() {
		HashMap<String, String> request = new HashMap<String, String>();
		request.put("name", "lorem");
		request.put("surname", "ipsum");

		Response userResponse = given().body(request.toString()).when().post(tempBaseURI + "/post").then().using()
				.extract().response();
		logger.error("post response");
		return userResponse;
	}

	public Response postUserEmailOnly() {
		HashMap<String, String> request = new HashMap<String, String>();
		request.put("email", "eve.holt@reqres.in");
		Response userResponse = given().contentType("application/json").body(request.toString()).when()
				.post(baseURI + endpoints.postUserWithEmail()).then().using().extract().response();
		logger.info("Response received for email only user");
		return userResponse;
	}

	public Response putUserDetails() {
		HashMap<String, String> request = new HashMap<String, String>();
		request.put("name", "morpheus");
		request.put("job", "zion resident");

		Response userResponse = given().body(request.toString()).when().put(baseURI + "/api/users/2").then().using()
				.extract().response();
		logger.info("Response received for put request");
		return userResponse;
	}

	public Response deleteUser() {
		Response userResponse = when().delete(baseURI + endpoints.getUser()).then().using().extract().response();
		return userResponse;
	}
}
