package service;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class CatFactsService {
    private static final String BASE_URL = "https://catfact.ninja";

    public Response getBreeds(int limit) {
        return given()
                .param("limit", limit)
                .when()
                .get(BASE_URL + "/breeds");
    }

    public Response getRandomFact(int maxLength) {
        return given()
                .param("max_length", maxLength)
                .when()
                .get(BASE_URL + "/fact");
    }

    public Response getFacts(int maxLength, int limit) {
        return given()
                .param("max_length", maxLength)
                .param("limit", limit)
                .when()
                .get(BASE_URL + "/facts");
    }
}
