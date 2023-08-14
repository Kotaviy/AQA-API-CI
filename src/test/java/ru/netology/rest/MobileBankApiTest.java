package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

class MobileBankApiTestV4 {
    @Test
    void shouldReturnAccounts() {
        given()
                .baseUri("http://localhost:9999/api/v1")
                .when()
                .get("/demo/accounts")
                .then().log().all()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"))
        ;
    }
}
