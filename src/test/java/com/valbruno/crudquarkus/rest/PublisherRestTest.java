package com.valbruno.crudquarkus.rest;

import com.valbruno.crudquarkus.model.Publisher;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.util.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
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

    @Test
    void getPublisher() {

        Long idPublisher = 1L;

        Publisher pub = given()
                .when().get("/publisher/{id}", idPublisher)
                .then()
                .statusCode(200)
                .extract().response().as(Publisher.class);

        Assert.equals(pub.getId(), idPublisher);
    }
}