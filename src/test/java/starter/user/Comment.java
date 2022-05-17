package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Comment {
    protected static String url ="https://be-qa.alta.id/api";
    private int content, statusresponse;

    @Step("I set GET api endpoints for comment")
    public String setGetApiForComment(){
        return url + "/products/2/comments";
    }

    @Step("I send GET HTTP Request for comment")
    public void sendGetHttpReqForComment(){
        SerenityRest.given().get(setGetApiForComment());
    }

    //Give comment
    @Step("I set POST api endpoints for comment")
    public String setPostApiForComment(){
        return url + "/products/2/comments";
    }

    @Step("I send POST HTTP Request for comment")
    public void sendPostHttpReqForComment(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("content", "mantap dong!");

        SerenityRest.given().header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkVsZnJpZGEgVGFtcHVib2xvbiIsIkVtYWlsIjoiZWxmMTIzQGVtYWlsLmNvbSJ9.26p_Tq9YA1ySy8UuTGPKwVJpt61uXpugluMOChFqOoo ")
                .body(requestBody.toJSONString()).post(setPostApiForComment());
    }

    // invalid give comment
    @Step("I send POST HTTP Request in {int} body for invalid give comment")
    public void sendPostHttpReqForInvalidGiveComment(int content){
        this.content = content;
        JSONObject reqBody = new JSONObject();
        reqBody.put("content", content);

        SerenityRest.given().header("Authorization", "Bearer "+"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkVsZnJpZGEgVGFtcHVib2xvbiIsIkVtYWlsIjoiZWxmMTIzQGVtYWlsLmNvbSJ9.26p_Tq9YA1ySy8UuTGPKwVJpt61uXpugluMOChFqOoo").body(reqBody)
                .post(setPostApiForComment());
    }

    @Step("I receive valid HTTP {int} response code for invalid give comment")
    public void receiveValidHttpResponseCodeForInvalidGiveComment(int statusresponse){
        this.statusresponse = statusresponse;
        restAssuredThat(response -> response.statusCode(statusresponse));
    }
}
