package requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.RandomUtils;

import java.util.*;

public class Requests {
    public static void main(String[] args) {
        String baseUri = "https://api.kraken.com/0/public";
        String endpoint = "/Assets";

        RestAssured.baseURI = baseUri;
        Response response = RestAssured
                .given()
                .header("accept", "application/json")
                .get(endpoint);


        if (response.statusCode() == 200) {
            Map<String, Object> resultObject = response.jsonPath().getMap("result");
            List<String> resultKeys = new ArrayList<>(resultObject.keySet());

            String randomKey = resultKeys.get(RandomUtils.getRandomNumber(0, resultKeys.size()-1));
            System.out.println("Random Key: " + randomKey);
        } else {
            System.out.println("Request failed with status code: " + response.statusCode());
        }



    }
}
