package requests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import kraken.configuration.Configuration;
import utilities.DateTimeUtils;
import utilities.RandomUtils;
import utilities.TestData;

import java.util.*;

public class Requests {

    public static String getRandomCrypto(){
        String endpoint = TestData.getStringValue("cryptoListEndpoint");

        RestAssured.baseURI = Configuration.apiUrl;
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

    public static Double getPriceValue(String currencyName){
        String pair = currencyName + "USD";
        long yesterdayTimestamp = DateTimeUtils.getYesterdayTimestamp();

        String endpoint = String.format("/Trades?pair=%s&since=%d&count=1", pair, yesterdayTimestamp);

        RestAssured.baseURI = Configuration.apiUrl;

        Response response = RestAssured
                .given()
                .header("accept", "application/json")
                .get(endpoint);


        if (response.statusCode() == 200) {

            JsonPath jsonPath = response.jsonPath();
            String priceString = jsonPath.getString("result." + pair + "[0][0]");

            return Double.valueOf(priceString);
        } else {
            throw new IllegalArgumentException("Request failed with status code: " + response.statusCode());
        }
    }



}
