package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Post;

public class PostSteps {

    @Steps
    Post post;

    @Given("I set POST api endpoints")
    public void setPostApi(){
        post.setPostApi();
    }

    @When("I send POST HTTP Request")
    public void sendPostHttp(){
        post.sendPostHttp();
    }

    @Then("I receive valid data for new category")
    public void receiveValidDataForCreateCategory(){
        post.validateDataCreateCategory();
    }

    //Product
    @Given("I set POST api endpoints for products")
    public void setPostApiForProducts(){
        post.setPostApiForProducts();
    }

    @When("I send POST HTTP Request for products")
    public void sendPostHttpForProducts(){
        post.sendPostHttpForProducts();
    }

    @Then("I receive valid data for new product")
    public void receiveValidDataNewProducts(){
        post.validateDataNewProduct();
    }

    // create invalid categories
    @When("I send POST HTTP Request in {int} body")
    public void iSendPOSTHTTPRequestInBodyBody(int body) {
        post.sendPostReqInvalidCreateCategories(body);
    }

    @Then("I receive valid HTTP {int} response code for create category")
    public void iReceiveValidHTTPResponsecodeResponseCode(int responsecode) {
        post.receiveValidHttpReqInvalidCreateCategory(responsecode);
    }

    // create invalid product
    @When("I send POST HTTP Request in {int}, {string}, {string} body for product")
    public void iSendPOSTHTTPRequestInPriceCategoriesBodyForProduct(int name, String price, String categories) {
        post.sendPostHttpReqCreateInvalidProduct(name, price, categories);
    }

    @Then("I receive valid HTTP {int} response code for create product")
    public void iReceiveValidHTTPCodeResponseCodeForCreateProduct(int code) {
        post.receiveValidHttpResponseCodeForCreateProduct(code);
    }
}
