package tests;

import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
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
    public void testGetFirstBreedNameVerify() {
        LoggerUtil.LOGGER.info("testGetFirstBreedNameVerify başladı...");

        Response response = catService.getBreeds(14);
        response.then().statusCode(200);

        String firstBreedName = response.jsonPath().getString("data[0].breed");
        Assert.assertEquals(firstBreedName, "Abyssinian");

        LoggerUtil.LOGGER.info("Response: " + response.prettyPrint());
        LoggerUtil.LOGGER.info("testGetFirstBreedNameVerify bitti...");
    }


    @Test
    public void testGetRandomFact() {
        LoggerUtil.LOGGER.info("testGetRandomFact başladı...");

        Response response = catService.getRandomFact(911);
        response.then()
                .statusCode(200);

        LoggerUtil.LOGGER.info("Response: " + response.prettyPrint());
        LoggerUtil.LOGGER.info("testGetRandomFact bitti...");

    }

    @Test
    public void testRandomFactNotEmpty() {
        LoggerUtil.LOGGER.info("testRandomFactNotEmpty başladı...");

        Response response = catService.getRandomFact(112);
        response.then()
                .statusCode(200);

        String fact = response.jsonPath().getString("fact");
        Assert.assertFalse(fact.isEmpty());

        LoggerUtil.LOGGER.info("Response: " + response.prettyPrint());
        LoggerUtil.LOGGER.info("testRandomFactNotEmpty bitti...");

    }

    @Test
    public void testGetFacts() {
        LoggerUtil.LOGGER.info("testGetFacts başladı...");

        Response response = catService.getFacts(50, 4);
        response.then()
                .statusCode(200)
                .body("data.size()", equalTo(4));

        LoggerUtil.LOGGER.info("Response: " + response.prettyPrint());
        LoggerUtil.LOGGER.info("testGetFacts bitti...");
    }

    @Test
    public void testGetFactsContentTypeVerify() {
        LoggerUtil.LOGGER.info("testGetFactsContentTypeVerify başladı...");

        Response response = catService.getFacts(50, 7);
        response.then()
                .statusCode(200).header("Content-Type", "application/json");

        LoggerUtil.LOGGER.info("Response: " + response.prettyPrint());
        LoggerUtil.LOGGER.info("testGetFactsContentTypeVerify bitti...");
    }

}
