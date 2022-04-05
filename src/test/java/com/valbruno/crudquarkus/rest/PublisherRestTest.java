package com.valbruno.crudquarkus.rest;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTestResource(H2DatabaseTestResource.class)
@QuarkusTest
class PublisherRestTest {

    @Test
    public void listPublishers() {
        given()
                .when().get("/publisher")
                .then()
                .statusCode(200)
                .assertThat()
                .body("size()", is(6));
    }
}