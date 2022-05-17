package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Transactions;

public class TransactionsSteps {
    @Steps
    Transactions transactions;

    @Given("I set GET api endpoints for get all transactions")
    public void setGetApiGetAllTransactions(){
        transactions.setGetApiAllTransactions();
    }

    @When("I send GET HTTP Request for get all transactions")
    public void sendGetApiAllTransactions(){
        transactions.sendGetApiGetAllTransactions();
    }

    // valid create
    @Given("I set POST api endpoints for create transaction")
    public void setPostApiForCreateTransaction(){
        transactions.setPostApiForCreateTransaction();
    }

    @When("I send POST HTTP Request for create transaction")
    public void sendPostHttpReqForCreateTransaction(){
        transactions.sendPostHttpReqForTransaction();
    }

    // invalid create
    @When("I send POST HTTP Request in {string}, {string} in body for invalid create transaction")
    public void iSendPOSTHTTPRequestIn(String productid, String quantity) {
        transactions.sendPostReqInvalidCreateTransactions(productid, quantity);
    }

    @Then("I receive valid HTTP {int} response code for invalid transaction")
    public void iReceiveValidHTTPCodestatusResponseCodeForInvalidTransaction(int codestatus) {
        transactions.receiveValidHttpResponseForInvalidTransaction(codestatus);
    }
}
