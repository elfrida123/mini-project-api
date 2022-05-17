package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Transactions {
    protected static String url ="https://be-qa.alta.id/api";
    private String productid, quantity;
    private int codestatus;

    @Step("I set GET api endpoints for get all transactions")
    public String setGetApiAllTransactions(){
        return url + "/orders";
    }

    @Step("I send GET HTTP Request for get all transactions")
    public void sendGetApiGetAllTransactions(){
        SerenityRest.given().header("Authorization", "Bearer "+"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkVsZnJpZGEgVGFtcHVib2xvbiIsIkVtYWlsIjoiZWxmMTIzQGVtYWlsLmNvbSJ9.26p_Tq9YA1ySy8UuTGPKwVJpt61uXpugluMOChFqOoo")
                .get(setGetApiAllTransactions());
    }

    // valid create
    @Step("I set POST api endpoints for create transaction")
    public String setPostApiForCreateTransaction(){
        return url + "/orders";
    }

    @Step("I send POST HTTP Request for create transaction")
    public void sendPostHttpReqForTransaction(){
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("product_id", 1);
        jsonObject.put("quantity", 2);
        jsonArray.add(jsonObject);
        jsonArray.toArray();

        SerenityRest.given().header("Authorization", "Bearer "+"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkVsZnJpZGEgVGFtcHVib2xvbiIsIkVtYWlsIjoiZWxmMTIzQGVtYWlsLmNvbSJ9.26p_Tq9YA1ySy8UuTGPKwVJpt61uXpugluMOChFqOoo").body(jsonArray)
                .post(setPostApiForCreateTransaction());
    }

    // invalid create
    @Step("I send POST HTTP Request in {string}, {string} in body for invalid create transaction")
    public void sendPostReqInvalidCreateTransactions(String productid, String quantity){
        this.productid = productid;
        this.quantity = quantity;
        JSONObject reqBody = new JSONObject();
        reqBody.put("product_id", productid);
        reqBody.put("price", quantity);

        SerenityRest.given().header("Authorization", "Bearer "+"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkVsZnJpZGEgVGFtcHVib2xvbiIsIkVtYWlsIjoiZWxmMTIzQGVtYWlsLmNvbSJ9.26p_Tq9YA1ySy8UuTGPKwVJpt61uXpugluMOChFqOoo").body(reqBody)
                .post(setPostApiForCreateTransaction());
    }

    @Step("I receive valid HTTP {int} response code for invalid transaction")
    public void receiveValidHttpResponseForInvalidTransaction(int codestatus){
        this.codestatus = codestatus;
        restAssuredThat(response -> response.statusCode(codestatus));
    }
}
