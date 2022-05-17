package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.user.Get;

public class GetSteps {
    @Steps
    Get get;

    private String endpoints;
    private String endpointsforproduct;

    // all categories
    @Given("I set GET api endpoints")
    public void setGetApi(){
        get.setGetApi();
    }

    @When("I send GET HTTP Request")
    public void sendGetHttp(){
        get.sendGetHttp();
    }

    @Then("I receive valid HTTP response code 200")
    public void receiveValidResponseCode200(){
        get.validateResponseCode200();
    }

    // category by id
    @Given("I set GET api endpoints for get category by id")
    public void setGetApiForCategoryById(){
        get.setGetApiForCategoryById();
    }

    @When("I send GET HTTP Request by id")
    public void sendGetHttpReqForCategoryById(){
        get.sendGetHttpReqCategoryById();
    }

    // Invalid Get Category By Id
    @Given("I set GET api {string} endpoints for get category by invalid id")
    public String iSetGETApiEndpointsForGetCategoryByInvalidId(String endpoints) {
        this.endpoints = endpoints;
        return get.setGetApiEndpointsForGetCategorYByInvalidID(endpoints);
    }

    @When("I send GET HTTP Request by invalid id")
    public void sendGetHttpReqInvalidById(){
        SerenityRest.given().get(iSetGETApiEndpointsForGetCategoryByInvalidId(endpoints));
    }

    @Then("I receive valid HTTP {int} response code")
    public void iReceiveValidHTTPResponsecodeResponseCode(int endpoints) {
        get.receiveValidHttpResponseCodeGetCategoriesByInvalidId(endpoints);
    }

    //Products
    @Given("I set GET api endpoints for products")
    public void setGetApiForProducts(){
        get.setGetApiForProducts();
    }

    @When("I send GET HTTP Request for products")
    public void sendGetHtppForProducts(){
        get.sendGetHttpForProducts();
    }

    // Products by id
    @Given("I set GET api endpoints for products by id")
    public void setGetApiById(){
        get.setGetApiById();
    }

    @When("I send GET HTTP Request for products by id")
    public void sendGetHttpById(){
        get.sendGetHttpById();
    }

    // get invalid product by id
    @Given("I set GET api {string} for products by invalid id")
    public String setGetApiGetProductByInvalidId(String endpointsforproduct){
        this.endpointsforproduct = endpointsforproduct;
        return get.setGetApiEndpointsForGetCategorYByInvalidID(endpointsforproduct);
    }

    @When("I send GET HTTP Request for products by invalid id")
    public void sendGetHttpReqProductsInvalidById(){
        SerenityRest.given().get(setGetApiGetProductByInvalidId(endpointsforproduct));
    }


    @Then("I receive valid HTTP {int} response code for products by invalid id")
    public void iReceiveValidHTTPStatuscodeResponseCodeForProductsByInvalidId(int statuscode) {
        get.receiveValidHttpResponseCodeGetProductByInvalidId(statuscode);
    }
}
