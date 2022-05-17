package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Ratings {
    protected static String url ="https://be-qa.alta.id/api";
    private String count;
    private int responsestatus;

    @Step("I set GET api endpoints for get ratings")
    public String setGetApiForGetRatings(){
        return url + "/products/1568/ratings";
    }

    @Step("I send GET HTTP Request for get ratings")
    public void sendHttpReqForGetRatings(){
        SerenityRest.given().get(setGetApiForGetRatings());
    }

    // give ratings
    @Step("I set POST api endpoints for give ratings")
    public String setPostApiForGiveRatings(){
        return url + "/products/1568/ratings";
    }

    @Step("I send POST HTTP Request for give ratings")
    public void sendHttpReqForGiveRatings(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("count", 2);

        SerenityRest.given().header("Authorization", "Bearer "+"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkVsZnJpZGEgVGFtcHVib2xvbiIsIkVtYWlsIjoiZWxmMTIzQGVtYWlsLmNvbSJ9.26p_Tq9YA1ySy8UuTGPKwVJpt61uXpugluMOChFqOoo")
                .body(requestBody.toJSONString()).post(setPostApiForGiveRatings());
    }

    // invalid give ratings
    @Step("I send POST HTTP Request in {string} body for invalid give ratings")
    public void sendPostHttpReqInvalidGiveRatings(String count){
        this.count = count;
        JSONObject reqBody = new JSONObject();
        reqBody.put("count", count);

        SerenityRest.given().header("Authorization", "Bearer "+"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkVsZnJpZGEgVGFtcHVib2xvbiIsIkVtYWlsIjoiZWxmMTIzQGVtYWlsLmNvbSJ9.26p_Tq9YA1ySy8UuTGPKwVJpt61uXpugluMOChFqOoo").body(reqBody)
                .post(setPostApiForGiveRatings());
    }

    @Step("I receive valid HTTP {int} response code for invalid give ratings")
    public void receiveValidHttpResponseCodeInvalidGiveRatings(int responsestatus){
        this.responsestatus = responsestatus;
        restAssuredThat(response -> response.statusCode(responsestatus));

    }
}
