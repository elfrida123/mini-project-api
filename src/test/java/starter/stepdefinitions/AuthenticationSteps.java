package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Authentication;

public class AuthenticationSteps {
    @Steps
    Authentication authentication;

    @Given("I set POST api endpoints for register")
    public void setPostApiRegister() {
        authentication.setPostApiForRegister();
    }

    @When("I send POST HTTP Request for register")
    public void sendPostRegister() {
        authentication.sendPostHttpForRegister();
    }

    @Then("I receive valid data for new account")
    public void receiveValidDataRegister() {
        authentication.validateDataNewAccount();
    }

    // login
    @Given("I set POST api endpoints for login")
    public void setPostApiForLogin(){
        authentication.setPostApiForLogin();
    }

    @Then("I send POST HTTP Request for login")
    public void sendHttpReqForLogin(){
        authentication.sendPostHttpForLogin();
    }

    // invalid register
    @When("I send POST HTTP Request in {string}, {string}, {string} body")
    public void iSendPOSTHTTPRequestInBody(String fullname, String email, String password) {
        authentication.sendPostHttpReqInvalidRegister(fullname, email, password);
    }

    @Then("I receive valid HTTP {int} status")
    public void iReceiveValidHTTPStatusStatus(int status) {
        authentication.receiveValidHttpStatusForInvalidRegister(status);
    }

    // invalid login
    @When("I send POST HTTP Request in {string}, {string} body")
    public void iSendPOSTHTTPRequestInBody(String email, String password) {
        authentication.sendPostHttpReqInvalidLogin(email, password);
    }

    @Then("I receive valid HTTP {int} response code for invalid login")
    public void iReceiveValidHTTPResponseCodeForInvalidLogin(int coderesponse) {
        authentication.receiveValidHttpInvalidLogin(coderesponse);
    }
}
