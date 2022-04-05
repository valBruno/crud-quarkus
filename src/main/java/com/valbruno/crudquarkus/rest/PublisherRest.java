package com.valbruno.crudquarkus.rest;

import com.valbruno.crudquarkus.model.Publisher;
import com.valbruno.crudquarkus.repository.PublisherRepo;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/publisher")
public class PublisherRest {

    @Inject
    PublisherRepo publisherRepo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Publisher> listPublishers() {

        List<Publisher> publishers = publisherRepo.listAll();

        return publishers;
    }
}