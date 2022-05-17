package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Ratings;

public class RatingsSteps {
    @Steps
    Ratings ratings;

    @Given("I set GET api endpoints for get ratings")
    public void setGetApiForGetRatings(){
        ratings.setGetApiForGetRatings();
    }

    @When("I send GET HTTP Request for get ratings")
    public void sendHttpReqForGetRatings(){
        ratings.sendHttpReqForGetRatings();
    }

    // give ratings
    @Given("I set POST api endpoints for give ratings")
    public void setGetApiForGiveRatings(){
        ratings.setPostApiForGiveRatings();
    }

    @When("I send POST HTTP Request for give ratings")
    public void sendPostHttpReqForGiveRatings(){
        ratings.sendHttpReqForGiveRatings();
    }

    // invalid give ratings
    @When("I send POST HTTP Request in {string} body for invalid give ratings")
    public void iSendPOSTHTTPRequestInBodyForInvalidGiveRatings(String count) {
        ratings.sendPostHttpReqInvalidGiveRatings(count);
    }

    @Then("I receive valid HTTP {int} response code for invalid give ratings")
    public void iReceiveValidHTTPResponsestatusResponseCodeForInvalidGiveRatings(int responsestatus) {
        ratings.receiveValidHttpResponseCodeInvalidGiveRatings(responsestatus);
    }
}
