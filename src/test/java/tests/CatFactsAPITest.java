package tests;

import io.restassured.response.Response;
import org.junit.Test;
import service.CatService;
import util.LoggerUtil;
import static org.hamcrest.Matchers.equalTo;

public class CatFactsAPITest {
    private CatService catService = new CatService();

    @Test
    public void testGetBreeds() {
        LoggerUtil.LOGGER.info("testGetBreeds başladı...");

        Response response = catService.getBreeds(13);
        response.then()
                .statusCode(200)
                .body("size()", equalTo(13));
        LoggerUtil.LOGGER.info("Response: " + response.prettyPrint());

        LoggerUtil.LOGGER.info("testGetBreeds bitti...");

    }

    @Test
    public void testGetRandomFact() {
        LoggerUtil.LOGGER.info("testGetRandomFact başladı...");

        Response response = catService.getRandomFact(50);
        response.then()
                .statusCode(200);
        LoggerUtil.LOGGER.info("Response: " + response.prettyPrint());

        LoggerUtil.LOGGER.info("testGetRandomFact bitti...");

    }

    @Test
    public void testGetFacts() {
        LoggerUtil.LOGGER.info("testGetFacts başladı...");

        Response response = catService.getFacts(50, 13);
        response.then()
                .statusCode(200)
                .body("size()", equalTo(13));
        LoggerUtil.LOGGER.info("Response: " + response.prettyPrint());

        LoggerUtil.LOGGER.info("testGetFacts bitti...");

    }

  }