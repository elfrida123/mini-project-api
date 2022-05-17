package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Comment;

public class CommentSteps {
    @Steps
    Comment comment;

    @Given("I set GET api endpoints for comment")
    public void setGetApiForComment(){
        comment.setGetApiForComment();
    }

    @When("I send GET HTTP Request for comment")
    public void sendGetHttpReqForComment(){
        comment.sendGetHttpReqForComment();
    }

    // valid give comment
    @Given("I set POST api endpoints for comment")
    public void setPostApiForComment(){
        comment.setPostApiForComment();
    }

    @When("I send POST HTTP Request for comment")
    public void sendPostHttpReqForComment(){
        comment.sendPostHttpReqForComment();
    }

    // invalid give comments
    @When("I send POST HTTP Request in {int} body for invalid give comment")
    public void iSendPOSTHTTPRequestInContentBodyForInvalidGiveComment(int content) {
        comment.sendPostHttpReqForInvalidGiveComment(content);
    }

    @Then("I receive valid HTTP {int} response code for invalid give comment")
    public void iReceiveValidHTTPStatusresponseResponseCodeForInvalidGiveComment(int statusresponse) {
        comment.receiveValidHttpResponseCodeForInvalidGiveComment(statusresponse);
    }
}
