package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import java.util.Arrays;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Post {
    protected static String url = "https://be-qa.alta.id/api";
    private int body;
    private int responsecode;
    private String price, categories;
    private int name, code;

    // categories
    @Step("I set POST api endpoints")
    public String setPostApi(){
        return url + "/categories";
    }

    @Step("I send POST HTTP Request")
    public void sendPostHttp(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "kesehatan");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(setPostApi());
    }

    @Step("I receive valid data for new category")
    public void validateDataCreateCategory(){
        restAssuredThat(response -> response.body("'data'.'Name'", equalTo("kesehatan")));
    }

    // invalid categories
    @Step("I send POST HTTP Request in {string} body")
    public void sendPostReqInvalidCreateCategories(int body){
        this.body = body;
        JSONObject reqBody = new JSONObject();
        reqBody.put("name", body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toJSONString()).post(setPostApi());
    }

    @Step("I receive valid HTTP {int} response code for create category")
    public void receiveValidHttpReqInvalidCreateCategory(int responsecode){
        this.responsecode = responsecode;
        restAssuredThat(response -> response.statusCode(responsecode));
    }

    //Product
    @Step("I set POST api endpoints for products")
    public String setPostApiForProducts(){
        return url + "/products";
    }

    @Step("I send POST HTTP Request for products")
    public void sendPostHttpForProducts(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Tensi Darah Elektrik");
        requestBody.put("price", 240000);
        requestBody.put("categories", Arrays.asList(3,6));

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(setPostApiForProducts());
    }

    @Step("I receive valid data for new product")
    public void validateDataNewProduct(){
        restAssuredThat(response -> response.body("'data'.'Name'", equalTo("Tensi Darah Elektrik")));
    }

    // create invalid product
    @Step("I send POST HTTP Request in {int}, {string}, {string} body for product")
    public void sendPostHttpReqCreateInvalidProduct(int name, String price, String categories){
        this.name = name;
        this.price = price;
        this.categories = categories;
        JSONObject reqBody = new JSONObject();
        reqBody.put("name", name);
        reqBody.put("price", price);
        reqBody.put("categories", categories);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toJSONString()).post(setPostApi());
    }

    @Step("I receive valid HTTP {int} response code for create product")
    public void receiveValidHttpResponseCodeForCreateProduct(int code){
        this.code = code;
        restAssuredThat(response -> response.statusCode(code));
    }
}
