package com.joy.suite.android;

import java.io.File;
import java.io.FileNotFoundException;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;


public class promopost {

    @Test(priority = 2)
    void testpost() throws FileNotFoundException {

        File f = new File("C:\\Users\\RajaThakur\\Documents\\JoyAppMobileAutomation\\body.json");
        if (!f.exists()) {
            System.out.println("File not found: " + f.getAbsolutePath());
            // Add further error handling or terminate the test
        }

        FileReader fr = new FileReader(f);

        JSONTokener jt = new JSONTokener(fr);

        JSONObject data = new JSONObject(jt);

        // Adding GraphQL body
        JSONObject graphqlBody = new JSONObject();
        graphqlBody.put("id", 44051);
        graphqlBody.put("parentId", 5);

        JSONObject input = new JSONObject();
        input.put("name", "AutoScriptSetup");

        JSONObject contentRole = new JSONObject();
        contentRole.put("type", "object");
        contentRole.put("id", 10187);

        input.put("contentRole", contentRole);

        input.put("jsonData", "{\"title\":\"AutoScriptSetup\",\"body\":\"<p>AutoScriptSetupAutoScriptSetupAutoScriptSetup</p>\\n\",\"versionNumber\":2}");
        input.put("displayStart", "Fri, 12 Jan 2024 18:30:00 GMT");
        input.put("displayEnd", "Sat, 30 Mar 2024 18:30:00 GMT");
        input.put("activeStart", "Fri, 12 Jan 2024 18:30:00 GMT");
        input.put("activeEnd", "Wed, 28 Feb 2024 18:30:00 GMT");

        graphqlBody.put("input", input);

        Response response = given()
                .contentType("application/json")
                .auth().basic("yourUsername", "yourPassword") // Replace with your actual credentials
                .body(graphqlBody.toString())
                .when()
                .post("https://admin.d2c.cep.mx.qa.pepsico.com/pepsico-graphql/loyalty-admin")
                .then()
                .log().all() // Log the response details
                .extract().response();

// Add additional checks or debugging based on the response
        int statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);




    }
}










