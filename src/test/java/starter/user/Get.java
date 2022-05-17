package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Get {
    protected static String url ="https://be-qa.alta.id/api";

    @Step("I set GET api endpoints")
    public String setGetApi(){
        return url + "/categories";
    }

    @Step("I send GET HTTP Request")
    public void sendGetHttp(){
        SerenityRest.given().get(setGetApi());
    }

    @Step("I receive valid HTTP response code 200")
    public void validateResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    // get category by id
    @Step("I set GET api endpoints for get category by id")
    public String setGetApiForCategoryById(){
        return url + "/categories/1";
    }

    @Step("I send GET HTTP Request by id")
    public void sendGetHttpReqCategoryById(){
        SerenityRest.given().get(setGetApiForCategoryById());
    }

    // get category by id invalid
    @Step("I set GET api {string} endpoints for get category by invalid id")
    public String setGetApiEndpointsForGetCategorYByInvalidID(String endpoints){
        return endpoints;
    }

    @Step("I receive valid HTTP {int} response code")
    public void receiveValidHttpResponseCodeGetCategoriesByInvalidId(int responsecode){
        restAssuredThat(response -> response.statusCode(responsecode));
    }

    //Products
    @Step("I set GET api endpoints for products")
    public String setGetApiForProducts(){
        return url + "/products";
    }

    @Step("I send GET HTTP Request for products")
    public void sendGetHttpForProducts(){
        SerenityRest.given().get(setGetApiForProducts());
    }

    // Product by id
    @Step("I set GET api endpoints for products by id")
    public String setGetApiById(){
        return url + "/products/428";
    }

    @Step("I send GET HTTP Request for products by id")
    public void sendGetHttpById(){
        SerenityRest.given().get(setGetApiById());
    }

    // Get product by invalid id
    @Step("I set GET api {string} for products by invalid id")
    public String setGetApiProductByInvalidId(String endpointsforproduct){
        return endpointsforproduct;
    }

    @Step("I receive valid HTTP {int} response code")
    public void receiveValidHttpResponseCodeGetProductByInvalidId(int statuscode){
        restAssuredThat(response -> response.statusCode(statuscode));
    }

}
