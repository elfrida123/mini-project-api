package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Authentication {
    protected static String url ="https://be-qa.alta.id/api";

    private String fullname,email,password;
    private int status, coderesponse;

    @Step("I set POST api endpoints for register")
    public String setPostApiForRegister(){
        return url + "/auth/register";
    }

    @Step("I send POST HTTP Request for register")
    public void sendPostHttpForRegister(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("fullname", "Geby Abigael");
        requestBody.put("email", "gabyabigael@gmail.com");
        requestBody.put("password", "Akucantik88@");
        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(setPostApiForRegister());
    }

    @Step("I receive valid data for new account")
    public void validateDataNewAccount(){
        restAssuredThat(response -> response.body("'data'.'Fullname'", equalTo("Geby Abigael")));
    }

    //Login
    @Step("I set POST api endpoints for login")
    public String setPostApiForLogin(){
        return url + "/auth/login";
    }

    @Step("I send POST HTTP Request for login")
    public void sendPostHttpForLogin(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "elf123@email.com");
        requestBody.put("password", "Akucantik88@");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(setPostApiForLogin());
    }

    // invalid register
    @Step("I send POST HTTP Request in {string}, {string}, {string} body")
    public void sendPostHttpReqInvalidRegister(String fullname, String email, String password){
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        JSONObject reqBody = new JSONObject();
        reqBody.put("fullname", fullname);
        reqBody.put("email", email);
        reqBody.put("password", password);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toJSONString()).post(setPostApiForRegister());
    }

    @Step("I receive valid HTTP {int} status")
    public void receiveValidHttpStatusForInvalidRegister(int status){
        this.status = status;
        restAssuredThat(response -> response.statusCode(status));
    }

    // invalid login
    @Step("I send POST HTTP Request in {string}, {string} body")
    public void sendPostHttpReqInvalidLogin(String email, String password){
        this.email = email;
        this.password = password;
        JSONObject reqBody = new JSONObject();
        reqBody.put("email", email);
        reqBody.put("password", password);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toJSONString()).post(setPostApiForLogin());
    }

    @Step("I receive valid HTTP {int} response code for invalid login")
    public void receiveValidHttpInvalidLogin(int coderesponse){
        this.coderesponse = coderesponse;
        restAssuredThat(response -> response.statusCode(coderesponse));
    }
}
