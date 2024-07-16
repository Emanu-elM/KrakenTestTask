package requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import kraken.configuration.Configuration;
import utilities.RandomUtils;
import utilities.TestData;

import java.util.*;

public class Requests {

    public static String getRandomCrypto(){
        String baseUri = Configuration.apiUrl;
        String endpoint = TestData.getStringValue("cryptoListEndpoint");

        RestAssured.baseURI = baseUri;
        Response response = RestAssured
                .given()
                .header("accept", "application/json")
                .get(endpoint);


        if (response.statusCode() == 200) {
            Map<String, Object> resultObject = response.jsonPath().getMap("result");
            List<String> resultKeys = new ArrayList<>(resultObject.keySet());

            return resultKeys.get(RandomUtils.getRandomNumber(0, resultKeys.size()-1));
        } else {
            throw new IllegalArgumentException("Request failed with status code: " + response.statusCode());
        }
    }



}
