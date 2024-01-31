package tests;

import io.restassured.response.Response;
import org.junit.Test;
import service.CatFactsService;
import util.LoggerUtil;

import static org.hamcrest.Matchers.equalTo;

public class CatFactsAPITest {

    private CatFactsService catFactsService = new CatFactsService();

    @Test
    public void testGetBreeds() {
        Response response = catFactsService.getBreeds(13);
        response.then()
                .statusCode(200)
                .body("size()", equalTo(13));

        LoggerUtil.LOGGER.info("Response: " + response.prettyPrint());
    }

    @Test
    public void testGetRandomFact() {
        Response response = catFactsService.getRandomFact(50);
        response.then()
                .statusCode(200);

        LoggerUtil.LOGGER.info("Response: " + response.prettyPrint());
    }

    @Test
    public void testGetFacts() {
        Response response = catFactsService.getFacts(50, 5);
        response.then()
                .statusCode(200)
                .body("size()", equalTo(13));
        LoggerUtil.LOGGER.info("Response: " + response.prettyPrint());

    }
}
