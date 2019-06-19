package com.express.stepDefinitions.servicesSteps;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.express.backend.ExpressServicesUtils;
import com.express.framework.utils.ServicesUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ServicesDefinitions {

    String baseHost;
    String resourceURL;
    Response response;
    ExpressServicesUtils ExpressServices;
    
//    EXPRESS
    @Given("^I consult \"([^\"]*)\" used for Express$")
    public void setBaseHostAndResourceURL(String resource)
            throws EncryptedDocumentException, InvalidFormatException, IOException {
        baseHost = ServicesUtils.getEndpoint();
        resourceURL = resource;
    }
    
    @When("^perform a get request$")
    public void doGetWithoutData() {
        RestAssured.useRelaxedHTTPSValidation();
        ExpressServices = new ExpressServicesUtils();
//        Map<String, Object> map = ExpressServices.getClientInfo();
//        response = ExpressServices.requestPost(map, baseHost, resourceURL);
    }
    
    
// END EXPRESS    

    @Given("^consulto a \"([^\"]*)\" usado para Onboarding$")
    public void setBaseHostAndResourceURLZZZ(String resource)
            throws EncryptedDocumentException, InvalidFormatException, IOException {
        baseHost = ServicesUtils.getEndpoint(ServicesUtils.ONBOARDING_APPLICATION);
        resourceURL = resource;

    }

    @When("^realizo el post request con el cuil (\\d+), mail \"([^\"]*)\" y tipo de oferta \"([^\"]*)\"$")
    public void doPostWithData(long cuil, String mail, String tipoOferta) {
        RestAssured.useRelaxedHTTPSValidation();
        ExpressServices = new ExpressServicesUtils();
        Map<String, Object> map = ExpressServices.getClientInfo(cuil, mail, tipoOferta);
        response = ExpressServices.requestPost(map, baseHost, resourceURL);
    }

    @Then("^el servicio responde (\\d+)$")
    public void verifyServiceResponse(String status) {
        Assert.assertTrue("El servicio " + baseHost + resourceURL + " NO MUESTRA RESULTADOS ",
                ExpressServices.validateStatus(response, status));
    }

}
